package com.lianggeshipin.www.model;

import java.sql.Timestamp;

public class VipCard {

	private int id;
	private int userID; // 用户id
	private Timestamp time; // 会员卡发放时间
	private String name; //会员卡名字[1天会员][7天会员][30天会员][1年会员]
	private String employ; // 是否使用[未使用:no][已使用:yes]
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmploy() {
		return employ;
	}
	public void setEmploy(String employ) {
		this.employ = employ;
	}
}
