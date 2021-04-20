package com.lianggeshipin.www.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lianggeshipin.www.dao.ICourseDao;
import com.lianggeshipin.www.model.Course;
import com.lianggeshipin.www.service.ICourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl implements ICourseService {

	@Resource
	private ICourseDao dao;
	
	@Override
	public int add(Course course) {
		return dao.add(course);
	}

	@Override
	public int del(Integer id) {
		return dao.del(id);
	}

	@Override
	public int up(Course course) {
		return dao.up(course);
	}

	@Override
	public Course getOne(Integer id) {
		return dao.getOne(id);
	}

	@Override
	public List<Course> getListByPlotID(Integer plotID) {
		return dao.getListByPlotID(plotID);
	}

}
