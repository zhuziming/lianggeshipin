package com.lianggeshipin.www.dao;

import java.util.List;

import com.lianggeshipin.www.model.CourseWhich;

public interface ICourseWhichDao {
	public int add(CourseWhich courseWhich);
	public int del(Integer id);
	public int up(CourseWhich courseWhich);
	public CourseWhich getOne(Integer id);
	
	public List<CourseWhich> getListByCourseID(Integer CourseID);
}
