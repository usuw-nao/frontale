package dao;

import java.util.List;

import domain.Juge;

public interface JugeDao {
	List<Juge> findAll() throws Exception;

	Juge findById(Integer id) throws Exception;

	void insert(Juge juge) throws Exception;

	void update(Juge juge) throws Exception;

	void delete(Juge juge) throws Exception;

}
