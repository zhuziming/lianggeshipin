package com.lianggeshipin.www.dao;


import com.lianggeshipin.www.model.User;

public interface IUserDao {

	public int add(User user);
	public int del(Integer id);
	public int up(User user);
	public User getOne(Integer id);
	public User getOneByAppID(String appID);
}
