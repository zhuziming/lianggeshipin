package com.lianggeshipin.www.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lianggeshipin.www.dao.IWord1000Dao;
import com.lianggeshipin.www.model.Animated;
import com.lianggeshipin.www.model.Plot;
import com.lianggeshipin.www.model.Word_1000;
import com.lianggeshipin.www.service.IAnimatedService;
import com.lianggeshipin.www.service.IPlotService;
import com.lianggeshipin.www.service.IWord_1000Service;
import com.lianggeshipin.www.util.FreeMarkerUtil;
import com.lianggeshipin.www.util.InitUtil;

@Controller
@RequestMapping("/manage")
public class ManageController {

	@Resource
	private IAnimatedService animatedService;
	@Resource
	private IPlotService plotService;
	@Resource
	private IWord_1000Service word_1000Service;
	
	
	@RequestMapping("/index.action")
	public String indexPage(Model model){
		InitUtil.iniSystem(model);
		return "manage/index";
	}
	
	/**
	 * @description 添加动漫 页面
	 * @author zhuziming
	 * @time 2020年11月3日 下午7:51:14
	 * @param model
	 * @return
	 */
	@RequestMapping("/addAnimatedPage.action")
	public String addAnimatedPage(Model model){
		InitUtil.iniSystem(model);
		return "manage/addAnimatedPage";
	}
	
	/**
	 * @description 添加动漫
	 * @author zhuziming
	 * @time 2020年11月3日 下午8:03:17
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addAnimated.action")
	public String addAnimated(HttpServletRequest request){
		try{
			String animatedName = request.getParameter("animatedName");
			String url = request.getParameter("url");
			if(animatedName==null || animatedName.isEmpty()){
				return "参数不能为空";
			}
			Animated ani = new Animated();
			ani.setAnimatedName(animatedName);
			ani.setUrl(url);
			animatedService.add(ani);
			return "添加成功";
		}catch(Exception e){
			e.printStackTrace();
			return "失败";
		}
	}
	
	/**
	 * @description 查询所有动漫页面
	 * @author zhuziming
	 * @time 2020年11月4日 上午9:21:54
	 * @return
	 */
	@RequestMapping("/queAnimatedPage.action")
	public String queAnimatedPage(Model model){
		List<Animated> list = animatedService.queList();
		model.addAttribute("animatedList",list); // 添加所有动漫
		InitUtil.iniSystem(model);
		return "manage/queAnimatedPage";
	}
	
	/**
	 * @description 添加动漫子集页面
	 * @author zhuziming
	 * @time 2020年11月4日 上午9:42:29
	 * @return
	 */
	@RequestMapping("/addPlotPage.action")
	public String addPlotPage(HttpServletRequest request,Model model){
		Integer animatedID = Integer.valueOf(request.getParameter("animatedID"));
		Animated ani = animatedService.queOne(animatedID);
		model.addAttribute("animated", ani);
		InitUtil.iniSystem(model);
		return "manage/addPlotPage";
	}
	
	@RequestMapping("/addPlot.action")
	public String addPlot(HttpServletRequest request,Model model){
		// 动漫的ID
		Integer animatedID = Integer.valueOf(request.getParameter("animatedID"));
		Enumeration<String> enu =request.getParameterNames(); // 取得所有的参数名
		// 遍历所有参数，得到下标，再跟据下标取参数
		List<Integer> numList = new ArrayList<Integer>();
		while(enu.hasMoreElements()){
			String param = enu.nextElement();
			int ind = param.indexOf("which");
			if(ind != -1){// 取课程名
				String index = param.replace("which", ""); // 取参数后边的下标
				numList.add(Integer.valueOf(index));
			}
		}
		
		// 遍历所有参数，插入数据库
		for (Integer integer : numList) {
			String which    = request.getParameter("which"+integer);
			if(which!=null && !which.isEmpty()){ // 可能会进入空数据
				String plotName = request.getParameter("plotName"+integer);
				String videoUrlCh = request.getParameter("videoUrlCh"+integer);
				String videoUrlEn = request.getParameter("videoUrlEn"+integer);
				String imgUrl   = request.getParameter("imgUrl"+integer);
				Plot p = new Plot();
				p.setAnimatedID(animatedID);
				p.setWhichEpisode(Integer.valueOf(which));
				p.setPlotName(plotName);
				p.setVideoUrlCh(videoUrlCh);
				p.setVideoUrlEn(videoUrlEn);
				p.setImgUrl(imgUrl);
				plotService.add(p);
			}
		}
		
		InitUtil.iniSystem(model);
		return "manage/index";
	}
	
	/**
	 * @description 查看所有分集
	 * @author zhuziming
	 * @time 2020年11月4日 上午10:47:49
	 * @return
	 */
	@RequestMapping("/queAllPlot.action")
	public String queAllPlot(HttpServletRequest request,Model model){
		Integer animatedID = Integer.valueOf(request.getParameter("animatedID"));
		List<Plot> list = plotService.queListByAnimatedID(animatedID);
		
		model.addAttribute("plotList", list);
		InitUtil.iniSystem(model);
		return "manage/plotListPage";
	}
	
	/**
	 * @description 编缉子集信息页面
	 * @author zhuziming
	 * @time 2020年11月4日 下午1:23:49
	 * @return
	 */
	@RequestMapping("/editPlotPage.action")
	public String editPlotPage(HttpServletRequest request,Model model){
		Integer pid = Integer.valueOf(request.getParameter("plotID"));
		Plot p = plotService.queOne(pid);
		model.addAttribute("plot",p);
		InitUtil.iniSystem(model);
		return "manage/editPlotPage";
	}
	
	/**
	 * @description 编缉子集
	 * @author zhuziming
	 * @time 2020年11月4日 下午1:50:41
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/editPlot.action")
	public String editPlot(HttpServletRequest request,Model model){
		try{
			Integer pid = Integer.valueOf(request.getParameter("plotID"));
			String title = request.getParameter("title");
			String meta = request.getParameter("meta");
			String intro = request.getParameter("intro");
			String down  = request.getParameter("down");
			String plotName = request.getParameter("plotName");
			String whichEpisode = request.getParameter("whichEpisode");
			String videoUrlCh = request.getParameter("videoUrlCh");
			String videoUrlEn = request.getParameter("videoUrlEn");
			String imgUrl = request.getParameter("imgUrl");
			Plot p = plotService.queOne(pid);
			p.setTitle(title);
			p.setMeta(meta);
			p.setIntro(intro.replaceAll("\n", "<br/>"));  // 把换行换成html <br/>
			p.setDown(down); 
			p.setPlotName(plotName);
			p.setWhichEpisode(Integer.valueOf(whichEpisode));
			p.setVideoUrlCh(videoUrlCh);
			p.setVideoUrlEn(videoUrlEn);
			p.setImgUrl(imgUrl);
			plotService.up(p);
			return "更新成功";
		}catch(Exception e){
			e.printStackTrace();
			return "更新失败";
		}
	}
	
	/**
	 * @description 生成首页
	 * @author zhuziming
	 * @time 2020年11月5日 上午8:43:45
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/createIndex.action")
	public String createIndex(){
		List<Animated> aniList = animatedService.queList();
		Map<String,List<Plot>> mapPlotList = new HashMap<String, List<Plot>>();
		for(Animated ani:aniList){
			List<Plot> pList = plotService.queListByAnimatedIDLimit(ani.getId(),0);
			mapPlotList.put(ani.getAnimatedName(), pList);
		}
		FreeMarkerUtil.createIndex(aniList, mapPlotList);
		return "成功";
	}
	
	/**
	 * @description 生成播放页
	 * @author zhuziming
	 * @time 2020年11月5日 上午11:06:58
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/createPlay.action")
	public String createPlay(HttpServletRequest request){
		Integer aniID = Integer.valueOf(request.getParameter("animatedID"));
		Animated ani = animatedService.queOne(aniID);
		List<Plot> plotList = plotService.queListByAnimatedID(aniID);
		Map<String,Plot> m = new HashMap<String,Plot>(); // <集数,plot>
		// 排序，按照集数排
		int[] array = new int[plotList.size()];
		int ar_i = 0;
		for(Plot plot:plotList){
			array[ar_i] = plot.getWhichEpisode();
			m.put(plot.getWhichEpisode()+"", plot);
			ar_i++;
		}
		// 冒泡排序，从小到大
		int temp;
		for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;  // 两个数交换位置
                }
            }
        }
		List<Plot> arrayList = new ArrayList<Plot>(); // 用有序的arrayList放入排好的值
		for (int i = 0; i < array.length; i++) {
			arrayList.add(m.get(array[i]+""));
		}
		
		for(Plot plot:arrayList){
			FreeMarkerUtil.createPlay(plot,arrayList,ani);
		}
		return "成功";
	}
	
	@RequestMapping("/createBaiduXml.action")
	@ResponseBody
	public String createBaiduXml(){
		try{
			List<Animated> AniList = animatedService.queList();
			List<Plot> plotList = new ArrayList<Plot>();
			for (Animated animated : AniList) {
				plotList.addAll(plotService.queListByAnimatedID(animated.getId()));
			}
			FreeMarkerUtil.createWebMapXML(plotList);
			return "成功";
		}catch(Exception e){
			e.printStackTrace();
			return "失败";
		}
		
	}
	
	@RequestMapping("/test.action")
	@ResponseBody
	public String test(){
		
		return "测试连通";
	}
	
}
