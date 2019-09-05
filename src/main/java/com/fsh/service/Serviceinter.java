package com.fsh.service;

import java.util.List;
import java.util.Map;

import com.fsh.bean.Movie;

/**
 * @作者：Mr.冯
 * @日期：2019年9月3日
 */
public interface Serviceinter {

	List<Map<String, Object>> getmovieAll(Map<String, Object> map);

	List<Map<String, Object>> gettypesAll();

	int addMovie(Movie movie);

	Map<String, Object> getById(int mid);

	int updateMovie(Movie movie);

	int delete(String[] mids);

}
