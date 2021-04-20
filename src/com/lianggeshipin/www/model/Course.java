package com.lianggeshipin.www.model;

public class Course {

	private int id;
	private int plotID; // 动漫的ID
	private int userID; // 用户的ID
	private String name; // 课程的名字
	private String url;  // 课程第一集的url
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPlotID() {
		return plotID;
	}
	public void setPlotID(int plotID) {
		this.plotID = plotID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
