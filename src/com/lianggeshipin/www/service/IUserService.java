package com.lianggeshipin.www.service;


import java.util.List;

import com.lianggeshipin.www.model.User;

public interface IUserService {

	public int add(User user);
	public int del(Integer id);
	public int up(User user);
	public User getOne(Integer id);
	public List<User> getListPage(Integer pageNum);
	public List<User> getUserByNickname(String nickname);
	public int getUserCount();
	public User getOneByAppID(String appID);
	public int upVipTime(User user);
}
