package com.lianggeshipin.www.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lianggeshipin.www.model.Animated;
import com.lianggeshipin.www.model.Plot;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerUtil {
	
	
	
	

	/**
	 * @description 创建首页
	 * @author zhuziming
	 * @time 2020年11月5日 上午9:20:09
	 * @param aniList 动漫所有名称
	 * @param plotList 子集名称
	 * @param mapPlotList 各子集放入Map中，<动漫名,子集list>
	 */
	public static void createIndex(List<Animated> aniList,Map<String,List<Plot>> mapPlotList){
		// 准备数据
		Map<String ,Object> data = new HashMap<String, Object>();
		String indexpath = PropertiesUtil.getValue("system.properties", "indexpath");
		String imgpath = PropertiesUtil.getValue("system.properties", "imgpath");
		String csspath = PropertiesUtil.getValue("system.properties", "csspath");
		String jspath = PropertiesUtil.getValue("system.properties", "jspath");
		String projectPath = PropertiesUtil.getValue("system.properties", "projectPath");
		String freeMarkerFtlpath = PropertiesUtil.getValue("system.properties", "freeMarkerFtlpath");
		String webMp4Path = PropertiesUtil.getValue("system.properties", "webMp4Path");
		String animatedImgPath = PropertiesUtil.getValue("system.properties", "animatedImgPath");
		data.put("indexpath",indexpath);
		data.put("imgpath",imgpath);
		data.put("csspath",csspath);
		data.put("jspath",jspath);
		data.put("animatedList",aniList);
		data.put("mapPlotList",mapPlotList);
		data.put("webMp4Path",webMp4Path);
		data.put("animatedImgPath",animatedImgPath);
		
		// 目录要一级一级的创建，否则会失败
		String deskpath = projectPath+"/";
		String[] desks = deskpath.split("/");
		String deskpath_1="";
		for(String desk:desks){
			deskpath_1 += desk+"/";
			File deskFile =new File(deskpath_1);    
			if(!deskFile .exists()  && !deskFile .isDirectory()){
				deskFile.mkdir();
			}
		}
		
		// 得到ftl模版
		Template tmp = FreeMarkerUtil.getTemplate(freeMarkerFtlpath,"front/index.ftl");
		// 得到生成对象
		Writer writer = FreeMarkerUtil.getWriter(projectPath+"/index.html");	
		try {
			// 生成网页
			tmp.process(data, writer);
			// 清空缓存
			writer.flush();
			writer.close();
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @description 创建播放页
	 * @author zhuziming
	 * @time 2020年11月5日 上午11:13:34
	 * @param plotList
	 */
	public static void createPlay(Plot plot,List<Plot> plotList,Animated ani){
		// 准备数据
		Map<String ,Object> data = new HashMap<String, Object>();
		String indexpath = PropertiesUtil.getValue("system.properties", "indexpath");
		String imgpath = PropertiesUtil.getValue("system.properties", "imgpath");
		String csspath = PropertiesUtil.getValue("system.properties", "csspath");
		String jspath = PropertiesUtil.getValue("system.properties", "jspath");
		String projectPath = PropertiesUtil.getValue("system.properties", "projectPath");
		String freeMarkerFtlpath = PropertiesUtil.getValue("system.properties", "freeMarkerFtlpath");
		String webMp4Path = PropertiesUtil.getValue("system.properties", "webMp4Path");
		String animatedImgPath = PropertiesUtil.getValue("system.properties", "animatedImgPath");
		data.put("indexpath",indexpath);
		data.put("imgpath",imgpath);
		data.put("csspath",csspath);
		data.put("jspath",jspath);
		data.put("plot",plot);
		data.put("plotList",plotList);
		data.put("animated",ani);
		data.put("webMp4Path",webMp4Path);
		data.put("animatedImgPath",animatedImgPath);
		
		// 目录要一级一级的创建，否则会失败
		String deskpath = projectPath+"/"+ani.getId()+"/";
		String[] desks = deskpath.split("/");
		String deskpath_1="";
		for(String desk:desks){
			deskpath_1 += desk+"/";
			File deskFile =new File(deskpath_1);    
			if(!deskFile .exists()  && !deskFile .isDirectory()){
				deskFile.mkdir();
			}
		}
		
		// 得到ftl模版
		Template tmp = FreeMarkerUtil.getTemplate(freeMarkerFtlpath,"front/play.ftl");
		// 得到生成对象
		Writer writer = FreeMarkerUtil.getWriter(projectPath+"/"+ani.getId()+"/"+plot.getWhichEpisode()+".html");	
		try {
			// 生成网页
			tmp.process(data, writer);
			// 清空缓存
			writer.flush();
			writer.close();
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @desctiption 得到Freemarker模块
	 * @param templateName 模版名称
	 * @author zhuziming
	 * @time 2018年3月30日下午5:03:15
	 */
	public static Template getTemplate(String ftlPath, String templateName){
		// 得到配置文件对象，并指定版本为VERSION_2_3_22
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
		try {
			// 设置读取ftl模版的位置
			cfg.setDirectoryForTemplateLoading(new File(ftlPath));
			// 模版的名字
			Template tmp = cfg.getTemplate(templateName);
			// 返回这个模版
			return tmp;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @desctiption 得到生成html文件的写入对象
	 * @author zhuziming
	 * @param htmlName 生成页面的名称
	 * @time 2018年3月30日下午5:06:25
	 */
	public static Writer getWriter(String htmlName){
		Writer writer = null;
		try {
			writer = new FileWriter(new File(htmlName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return writer;
	}

	public static void main(String[] args) {
		String freeMarkerFtlpath = PropertiesUtil.getValue("system.properties", "freeMarkerFtlpath");
		// 准备数据
		Map<String ,String> data = new HashMap<String, String>();
		data.put("username", "老潭?");
		// 得到ftl模版
		Template tmp = FreeMarkerUtil.getTemplate(freeMarkerFtlpath,"test.ftl");
		// 得到生成对象
		Writer writer = FreeMarkerUtil.getWriter("test.html");	
		try {
			// 生成网页
			tmp.process(data, writer);
			// 清空缓存
			writer.flush();
			writer.close();
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @desctiption 创建百度推送文件xml sitemap_example.xml
	 * @author zhuziming
	 * @time 2020年10月12日下午2:56:25
	 */
	public static boolean createWebMapXML(List<Plot> list){
		
		// 准备数据
		Map<String ,Object> data = new HashMap<String, Object>();
		String indexpath = PropertiesUtil.getValue("system.properties", "indexpath");
		String imgpath = PropertiesUtil.getValue("system.properties", "imgpath");
		String csspath = PropertiesUtil.getValue("system.properties", "csspath");
		String jspath = PropertiesUtil.getValue("system.properties", "jspath");
		String projectPath = PropertiesUtil.getValue("system.properties", "projectPath");
		String freeMarkerFtlpath = PropertiesUtil.getValue("system.properties", "freeMarkerFtlpath");
		
		data.put("indexpath", indexpath);
		data.put("imgpath", imgpath);
		data.put("csspath", csspath);
		data.put("jspath", jspath);
		data.put("PlotList", list);

		
		// 得到ftl模版
		Template tmp = FreeMarkerUtil.getTemplate(freeMarkerFtlpath,"front/sitemap_example_xml.ftl");
		// 得到生成对象
		Writer writer = FreeMarkerUtil.getWriter(projectPath+"/sitemap_example.xml");	
		try {
			// 生成网页
			tmp.process(data, writer);
			// 清空缓存
			writer.flush();
			writer.close();
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
}
