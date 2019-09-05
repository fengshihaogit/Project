package com.fsh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fsh.bean.Movie;
import com.fsh.service.Serviceinter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @作者：Mr.冯
 * @日期：2019年9月3日
 */
@Controller
public class Controllersmovie {

	@Resource
	private Serviceinter ser;
	
	@RequestMapping(value="/list")
	public String getmovieAll(Model model,
				@RequestParam(defaultValue="1")int cpage,
				@RequestParam(defaultValue="")String mname
			){
		Map<String,  Object> map = new HashMap<String, Object>();
		
		map.put("mname", mname);
		
		PageHelper.startPage(cpage, 3);
		List<Map<String, Object>> getmovieAll = ser.getmovieAll(map);
		
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(getmovieAll);
		model.addAttribute("getmovieAll", getmovieAll);
		model.addAttribute("page", pageInfo);
		model.addAttribute("mname", mname);
		return "list";
	}
	
	@RequestMapping(value="/toadd")
	public String toadd(){
		return "add";
	}
	
	@RequestMapping(value="/gettypesAll")
	@ResponseBody
	public Object gettypesAll(){
		
		List<Map<String, Object>> gettypesAll = ser.gettypesAll();
		System.out.println(gettypesAll.toString());
		return gettypesAll;
	}
	@RequestMapping(value="/add")
	@ResponseBody
	public Object add(Movie movie){
		
		int add = ser.addMovie(movie);
		return add;
	}
	@RequestMapping(value="/update")
	@ResponseBody
	public Object update(Movie movie){
		
		int update = ser.updateMovie(movie);
		return update;
	}
	
	@RequestMapping(value="/toupdate")
	public  String toupdate(int mid,Model model){
		
		Map<String, Object> map = ser.getById(mid);
		model.addAttribute("m", map);
		return "update";
	}
	@RequestMapping(value="/delete")
	@ResponseBody
	public Object delete(String [] mids){
		
		int delete = ser.delete(mids);
		return delete;
	}
	
	
}
