package com.lianggeshipin.www.util;

import org.springframework.ui.Model;

public class InitUtil {
	
	/**
	 * @desctiption 初始化system.properties文件
	 * @author zhuziming
	 * @time 2018年4月28日下午4:59:14
	 */
	public static void iniSystem(Model model){
		String indexpath = PropertiesUtil.getValue("system.properties", "indexpath");
		String imgpath = PropertiesUtil.getValue("system.properties", "imgpath");
		String csspath = PropertiesUtil.getValue("system.properties", "csspath");
		String jspath = PropertiesUtil.getValue("system.properties", "jspath");
		String webMp4Path = PropertiesUtil.getValue("system.properties", "webMp4Path");
		String animatedImgPath = PropertiesUtil.getValue("system.properties", "animatedImgPath");
		model.addAttribute("indexpath",indexpath);
		model.addAttribute("imgpath",imgpath);
		model.addAttribute("csspath",csspath);
		model.addAttribute("jspath",jspath);
		model.addAttribute("webMp4Path",webMp4Path);
		model.addAttribute("animatedImgPath",animatedImgPath);
	}

}
