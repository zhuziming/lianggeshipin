package com.lianggeshipin.www.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lianggeshipin.www.dao.ICourseWhichDao;
import com.lianggeshipin.www.model.CourseWhich;
import com.lianggeshipin.www.service.ICourseWhichService;

@Service("courseWhichService")
public class CourseWhichService implements ICourseWhichService {

	@Resource
	private ICourseWhichDao dao;
	
	@Override
	public int add(CourseWhich courseWhich) {
		return dao.add(courseWhich);
	}

	@Override
	public int del(Integer id) {
		return dao.del(id);
	}

	@Override
	public int up(CourseWhich courseWhich) {
		return dao.up(courseWhich);
	}

	@Override
	public CourseWhich getOne(Integer id) {
		return dao.getOne(id);
	}

	@Override
	public List<CourseWhich> getListByCourseID(Integer courseID) {
		return dao.getListByCourseID(courseID);
	}

}
