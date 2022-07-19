package dao;

import java.util.List;

import domain.Watch;

public interface WatchDao {
	List<Watch> findAll() throws Exception;

	Watch findById(Integer id) throws Exception;

	void insert(Watch watch) throws Exception;

	void update(Watch watch) throws Exception;

	void delete(Watch watch) throws Exception;

}
