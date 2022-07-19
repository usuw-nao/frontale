package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.mindrot.jbcrypt.BCrypt;

import domain.Login;

public class LoginDaoImpl implements LoginDao {
	private DataSource ds;

	public LoginDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Login> findAll() throws Exception {

		return null;
	}

	@Override
	public Login findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(Login login) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void update(Login login) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(Login login) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public Login findByUserIdAndPass(String userId, String pass) throws Exception {
		Login login = null;
		try (Connection con = ds.getConnection()) {
			String sql = "select * from login where userId=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, userId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				if (BCrypt.checkpw(pass, rs.getString("pass"))) {
					login = mapToLogin(rs);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return login;
	}

	private Login mapToLogin(ResultSet rs) throws Exception {
		Login login = new Login();
		login.setId((Integer) rs.getObject("id"));
		login.setUserId(rs.getString("userId"));
		login.setPass(rs.getString("pass"));
		return login;
	}

}
