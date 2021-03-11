package com.lianggeshipin.www.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lianggeshipin.www.dao.IPlotDao;
import com.lianggeshipin.www.model.Plot;
import com.lianggeshipin.www.service.IPlotService;

@Service("plotServiceImpl")
public class PlotServiceImpl implements IPlotService {
	
	
	@Resource
	private IPlotDao plotDao;

	@Override
	public int add(Plot p) {
		return plotDao.add(p);
	}

	@Override
	public int del(Integer id) {
		return plotDao.del(id);
	}

	@Override
	public int up(Plot p) {
		return plotDao.up(p);
	}

	@Override
	public Plot queOne(Integer id) {
		return plotDao.queOne(id);
	}

	@Override
	public List<Plot> queListByAnimatedID(Integer animatedID) {
		return plotDao.queListByAnimatedID(animatedID);
	}

	@Override
	public List<Plot> queListByAnimatedIDLimit(Integer animatedID,Integer pageNum) {
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("animatedID", animatedID);
		map.put("pageNum", pageNum);
		return plotDao.queListByAnimatedIDLimit(map);
	}

}
