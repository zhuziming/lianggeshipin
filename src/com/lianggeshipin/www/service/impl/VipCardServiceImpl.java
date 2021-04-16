package com.lianggeshipin.www.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lianggeshipin.www.dao.IVipCardDao;
import com.lianggeshipin.www.model.VipCard;
import com.lianggeshipin.www.service.IVipCardService;

@Service("vipCardServiceImpl")
public class VipCardServiceImpl implements IVipCardService {

	@Resource
	public IVipCardDao dao;
	
	@Override
	public int add(VipCard vipCard) {
		return dao.add(vipCard);
	}

	@Override
	public int del(Integer id) {
		return dao.del(id);
	}

	@Override
	public int up(VipCard vipCard) {
		return dao.up(vipCard);
	}

	@Override
	public VipCard getOne(Integer id) {
		return dao.getOne(id);
	}
	
	@Override
	public List<VipCard> getListByUserID(Integer userID){
		return dao.getListByUserID(userID);
	}
	
	public int getCountByUserID(Integer userID){
		return dao.getCountByUserID(userID);
	}
}
