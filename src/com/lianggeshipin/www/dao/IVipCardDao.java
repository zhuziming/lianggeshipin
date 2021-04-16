package com.lianggeshipin.www.dao;

import java.util.List;

import com.lianggeshipin.www.model.VipCard;

public interface IVipCardDao {
	public int add(VipCard vipCard);
	public int del(Integer id);
	public int up(VipCard vipCard);
	public VipCard getOne(Integer id);
	public List<VipCard> getListByUserID(Integer userID);
	public int getCountByUserID(Integer userID);
}
