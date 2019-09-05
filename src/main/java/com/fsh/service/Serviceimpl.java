package com.fsh.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fsh.bean.Movie;
import com.fsh.mapper.MapperDao;

/**
 * @作者：Mr.冯
 * @日期：2019年9月3日
 */
@Service
public class Serviceimpl implements Serviceinter{

	@Resource
	private MapperDao dao;
	
	@Override
	public List<Map<String, Object>> getmovieAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.getmovieAll(map);
	}
	
	@Override
	public List<Map<String, Object>> gettypesAll() {
		// TODO Auto-generated method stub
		return dao.gettypesAll();
	}
	
	@Override
	public int addMovie(Movie movie) {
		// TODO Auto-generated method stub
		return dao.addMovie(movie);
	}
	@Override
	public Map<String, Object> getById(int mid) {
		// TODO Auto-generated method stub
		return dao.getById(mid);
	}
	
	@Override
	public int updateMovie(Movie movie) {
		// TODO Auto-generated method stub
		return dao.updateMovie(movie);
	}
	@Override
	public int delete(String[] mids) {
		// TODO Auto-generated method stub
		return dao.delete(mids);
	}
}
