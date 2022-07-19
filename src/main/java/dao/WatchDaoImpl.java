package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import domain.Watch;

public class WatchDaoImpl implements WatchDao {
	private DataSource ds;

	public WatchDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Watch> findAll() throws Exception {
		List<Watch> watchList = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			String sql = "select * from watcing";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				watchList.add(mapToWatch(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return watchList;
	}

	private Watch mapToWatch(ResultSet rs) throws Exception {
		Integer id = (Integer) rs.getObject("id");
		Date matchDay = rs.getTimestamp("match_day");
		String game = rs.getString("game");
		String place = rs.getString("place");

		return new Watch(id, matchDay, game, place);
	}

	@Override
	public Watch findById(Integer id) throws Exception {
		Watch watch = new Watch();

		try (Connection con = ds.getConnection()) {
			String sql = "select * from watcing "
					+ " where id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject( 1,id, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				watch = mapToWatch(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return watch;
	}

	@Override
	public void insert(Watch watch) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "insert into watcing"
					+ "( match_day,game,place)"
					+ " values(now(),?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			//stmt.setObject(1, watch.getId());
			//stmt.setDate(2, watch.getMatchDay());
			stmt.setString(1, watch.getGame());
			stmt.setString(2, watch.getPlace());
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void update(Watch watch) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "update watcing"
					+ " set game=?,place=? where id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(3, watch.getId(), Types.INTEGER);
			stmt.setString(1, watch.getGame());
			stmt.setString(2, watch.getPlace());
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void delete(Watch watch) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = " delete from watcing "
					+ " where id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, watch.getId(), Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

}
