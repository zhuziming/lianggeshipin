package com.lianggeshipin.www.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lianggeshipin.www.dao.IUserDao;
import com.lianggeshipin.www.model.User;
import com.lianggeshipin.www.service.IUserService;
@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {
	@Resource
	public IUserDao dao;
	
	@Override
	public int add(User user) {
		return dao.add(user);
	}

	@Override
	public int del(Integer id) {
		return dao.del(id);
	}

	@Override
	public int up(User user) {
		return dao.up(user);
	}

	@Override
	public User getOne(Integer id) {
		return dao.getOne(id);
	}
	@Override
	public User getOneByAppID(String appID){
		return dao.getOneByAppID(appID);
	}
	@Override
	public int upVipTime(User user) {
		return dao.upVipTime(user);
	}
}
