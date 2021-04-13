package com.lianggeshipin.www.service;


import com.lianggeshipin.www.model.User;

public interface IUserService {

	public int add(User user);
	public int del(Integer id);
	public int up(User user);
	public User getOne(Integer id);
	public User getOneByAppID(String appID);
	public int upVipTime(User user);
}
