package com.lianggeshipin.www.dao;

import java.util.List;

import com.lianggeshipin.www.model.Animated;

public interface IAnimatedDao {
	
	public int add(Animated ani);
	public int del(Integer id);
	public int up(Animated ani);
	public Animated queOne(Integer id);
	public List<Animated> queList();
	
}
