package com.lianggeshipin.www.dao;

import java.util.List;

import com.lianggeshipin.www.model.Plot;

public interface IPlotDao {

	public int add(Plot p);
	public int del(Integer id);
	public int up(Plot p);
	public Plot queOne(Integer id);
	public List<Plot> queListByAnimatedID(Integer animatedID);
}
