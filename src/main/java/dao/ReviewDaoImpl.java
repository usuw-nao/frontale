package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Review;

public class ReviewDaoImpl implements ReviewDao {
	private DataSource ds;

	public ReviewDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Review> findAll() throws Exception {
		List<Review> reviews = new ArrayList<>();

		try (Connection con = ds.getConnection()) {
			String sql = "select * from review order by id desc "; 
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				reviews.add(mapToReview(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return reviews;
	}

	@Override
	public Review findById(int id) throws Exception {
		Review review = null;
		try (Connection con = ds.getConnection()) {
			String sql = "select * from watcing left outer join review " + "on watcing.id = review.id" + " where id=? ";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setObject(1, id, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				review = mapToReview(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return review;
	}

	@Override
	public void insert(Review review) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "insert into review " 
		                + " (name,text,evaluation,registered)" 
		                + " values(?,?,?,now()) ";
			PreparedStatement stmt = con.prepareCall(sql);
			stmt.setString(1, review.getName());
			stmt.setString(2, review.getText());
			stmt.setObject(3, review.getEvaluation(),Types.INTEGER);
			
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void update(Review review) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "update review set name=?, text=?, evaluation=? " + " where id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, review.getName());
			stmt.setString(2, review.getText());
			stmt.setObject(3, review.getEvaluation(), Types.INTEGER);
			stmt.setObject(4, review.getId(), Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void delete(Review review) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "delete from review wherer id=? ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, review.getId(), Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}

	protected Review mapToReview(ResultSet rs) throws Exception {
		Review review = new Review();
		review.setId(rs.getInt("id"));
		review.setName(rs.getString("name"));
		review.setText(rs.getString("text"));
		review.setRegistered(rs.getTimestamp("registered"));
		review.setEvaluation(rs.getInt("evaluation"));
		return review;
	}

}