package com.lianggeshipin.www.model;

/**
 * @description 剧情
 * @author zhuziming
 * @time 2020年11月3日 下午3:19:27
 */
public class Plot {
	public int id;
	public int animatedID; // 影片的id
	public String plotNameCh; // 剧情的中文名字
	public String plotNameEn; // 剧情的英文名字
	public int whichEpisode; // 哪一集
	public String videoUrlCh; // 中文视频的地址
	public String videoUrlEn; // 英文视频的地址
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
	public String getPlotNameCh() {
		return plotNameCh;
	}
	public void setPlotNameCh(String plotNameCh) {
		this.plotNameCh = plotNameCh;
	}
	public String getPlotNameEn() {
		return plotNameEn;
	}
	public void setPlotNameEn(String plotNameEn) {
		this.plotNameEn = plotNameEn;
	}
	public int getWhichEpisode() {
		return whichEpisode;
	}
	public void setWhichEpisode(int whichEpisode) {
		this.whichEpisode = whichEpisode;
	}
	public String getVideoUrlCh() {
		return videoUrlCh;
	}
	public void setVideoUrlCh(String videoUrlCh) {
		this.videoUrlCh = videoUrlCh;
	}
	public String getVideoUrlEn() {
		return videoUrlEn;
	}
	public void setVideoUrlEn(String videoUrlEn) {
		this.videoUrlEn = videoUrlEn;
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
