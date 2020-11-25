package com.lianggeshipin.www.service.impl;

import java.util.List;

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
		// TODO Auto-generated method stub
		return plotDao.add(p);
	}

	@Override
	public int del(Integer id) {
		// TODO Auto-generated method stub
		return plotDao.del(id);
	}

	@Override
	public int up(Plot p) {
		// TODO Auto-generated method stub
		return plotDao.up(p);
	}

	@Override
	public Plot queOne(Integer id) {
		// TODO Auto-generated method stub
		return plotDao.queOne(id);
	}

	@Override
	public List<Plot> queListByAnimatedID(Integer animatedID) {
		// TODO Auto-generated method stub
		return plotDao.queListByAnimatedID(animatedID);
	}

}
