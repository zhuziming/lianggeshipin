package com.lianggeshipin.www.model;

/**
 * @description 影片
 * @author zhuziming
 * @time 2020年11月3日 下午3:18:01
 */
public class Animated {
	public int id;
	public String animatedName; // 影片的名字
	public String url;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnimatedName() {
		return animatedName;
	}
	public void setAnimatedName(String animatedName) {
		this.animatedName = animatedName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
