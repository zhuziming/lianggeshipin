package com.lianggeshipin.www.model;


// 课程的每一集信息
public class CourseWhich {

	private int id;
	private int courseID; // 课程ID
	private int whichEpisode; // 哪一集
	private String name; // 这一集的名字
	private String chargeUrl; // 收费的视频Url
	private String freeUrl;   // 免费的视频Url
	private int status;   // 视频状态[1:免费][2:收费]
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public int getWhichEpisode() {
		return whichEpisode;
	}
	public void setWhichEpisode(int whichEpisode) {
		this.whichEpisode = whichEpisode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChargeUrl() {
		return chargeUrl;
	}
	public void setChargeUrl(String chargeUrl) {
		this.chargeUrl = chargeUrl;
	}
	public String getFreeUrl() {
		return freeUrl;
	}
	public void setFreeUrl(String freeUrl) {
		this.freeUrl = freeUrl;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
