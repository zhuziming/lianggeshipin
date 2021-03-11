package com.lianggeshipin.www.service;

import java.util.List;
import java.util.Map;

import com.lianggeshipin.www.model.Plot;

public interface IPlotService {
	public int add(Plot p);
	public int del(Integer id);
	public int up(Plot p);
	public Plot queOne(Integer id);
	public List<Plot> queListByAnimatedID(Integer animatedID);
	/**
	 * @description 
	 * @author zhuziming
	 * @time 2021年3月11日 上午11:01:31
	 * @param animatedID  动画id
	 * @param pageNum   第几页
	 * @return
	 */
	public List<Plot> queListByAnimatedIDLimit(Integer animatedID,Integer pageNum);
}
