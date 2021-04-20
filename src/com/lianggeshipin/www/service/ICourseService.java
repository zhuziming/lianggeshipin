package com.lianggeshipin.www.service;

import java.util.List;

import com.lianggeshipin.www.model.Course;

public interface ICourseService {

	public int add(Course course);
	public int del(Integer id);
	public int up(Course course);
	public Course getOne(Integer id);
	
	public List<Course> getListByPlotID(Integer plotID);
}
