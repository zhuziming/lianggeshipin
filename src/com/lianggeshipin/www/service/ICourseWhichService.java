package com.lianggeshipin.www.service;

import java.util.List;

import com.lianggeshipin.www.model.CourseWhich;

public interface ICourseWhichService {
	
	public int add(CourseWhich courseWhich);
	public int del(Integer id);
	public int up(CourseWhich courseWhich);
	public CourseWhich getOne(Integer id);
	
	public List<CourseWhich> getListByCourseID(Integer courseID);
}
