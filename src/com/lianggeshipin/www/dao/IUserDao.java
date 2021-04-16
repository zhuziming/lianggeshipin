package com.lianggeshipin.www.dao;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lianggeshipin.www.model.User;

public interface IUserDao {

	public int add(User user);
	public int del(Integer id);
	public int up(User user);
	public User getOne(Integer id);
	public List<User> getListPage(@Param("pageNum") int pageNum);
	public List<User> getListByNickname(String nickname);
	public int getCount();
	public User getOneByAppID(String appID);
	public int upVipTime(User user);
}
