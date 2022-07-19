package dao;

import java.util.List;

import domain.Login;

public interface LoginDao {
	List<Login> findAll() throws Exception;

	Login findById(Integer id) throws Exception;

	void insert(Login login) throws Exception;

	void update(Login login) throws Exception;

	void delete(Login login) throws Exception;

	Login findByUserIdAndPass(String userId, String pass) throws Exception;

}
