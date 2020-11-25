package com.lianggeshipin.www.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lianggeshipin.www.dao.IAnimatedDao;
import com.lianggeshipin.www.model.Animated;
import com.lianggeshipin.www.service.IAnimatedService;

@Service("animetedServiceImpl")
public class AnimetedServiceImpl implements IAnimatedService {
	
	
	@Resource
	private IAnimatedDao animatedDao;

	@Override
	public int add(Animated ani) {
		// TODO Auto-generated method stub
		return animatedDao.add(ani);
	}

	@Override
	public int del(Integer id) {
		// TODO Auto-generated method stub
		return animatedDao.del(id);
	}

	@Override
	public int up(Animated ani) {
		// TODO Auto-generated method stub
		return animatedDao.up(ani);
	}

	@Override
	public Animated queOne(Integer id) {
		// TODO Auto-generated method stub
		return animatedDao.queOne(id);
	}

	@Override
	public List<Animated> queList() {
		// TODO Auto-generated method stub
		return animatedDao.queList();
	}

}
