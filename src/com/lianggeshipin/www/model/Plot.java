package com.lianggeshipin.www.model;

/**
 * @description 剧情
 * @author zhuziming
 * @time 2020年11月3日 下午3:19:27
 */
public class Plot {
	public int id;
	public int animatedID; // 影片的id
	public String plotName; // 剧情的名字
	public int whichEpisode; // 哪一集
	public String videoUrl; // 视频的地址
	public String imgUrl;   // 图片的地址
	
	public String title; // 网页的标题
	public String meta;  // 网页的关键字
	public String intro; // 动漫信息
	public String down;  // 下载地址
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAnimatedID() {
		return animatedID;
	}
	public void setAnimatedID(int animatedID) {
		this.animatedID = animatedID;
	}
	public String getPlotName() {
		return plotName;
	}
	public void setPlotName(String plotName) {
		this.plotName = plotName;
	}
	public int getWhichEpisode() {
		return whichEpisode;
	}
	public void setWhichEpisode(int whichEpisode) {
		this.whichEpisode = whichEpisode;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMeta() {
		return meta;
	}
	public void setMeta(String meta) {
		this.meta = meta;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getDown() {
		return down;
	}
	public void setDown(String down) {
		this.down = down;
	}
	
	
}
