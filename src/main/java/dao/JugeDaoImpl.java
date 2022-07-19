package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.sql.DataSource;

import domain.Juge;

public class JugeDaoImpl implements JugeDao {
	private DataSource ds;

	public JugeDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Juge> findAll() throws Exception {
		List<Juge> jugeList = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			String sql = "select juge.id,juge.text from juge where id =?";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				//Integer id = (Integer) rs.getObject("id");
				//String Text = rs.getString("text");
				jugeList.add(mapToJuge(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return jugeList;

	}

	@Override
	public Juge findById(Integer id) throws Exception {
		Juge juge = null;
		
		try (Connection con = ds.getConnection()) {
			String sql = " select juge.id,juge.text from juge where juge.id =?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				juge = mapToJuge(rs);
				System.out.println(juge.getId());
			}

		} catch (Exception e) {
			throw e;
		}
		return juge;
	}

	private Juge mapToJuge(ResultSet rs) throws Exception {
		Integer id = (Integer) rs.getObject("id");
		String Text = rs.getString("text");
		return new Juge(id, Text);
	}

	@Override
	public void insert(Juge juge) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update(Juge juge) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(Juge juge) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

}
