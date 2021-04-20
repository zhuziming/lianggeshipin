package com.lianggeshipin.www.controller;


import java.sql.Timestamp;
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

import com.alibaba.fastjson.JSONObject;
import com.lianggeshipin.www.model.Animated;
import com.lianggeshipin.www.model.Course;
import com.lianggeshipin.www.model.CourseWhich;
import com.lianggeshipin.www.model.Plot;
import com.lianggeshipin.www.model.User;
import com.lianggeshipin.www.model.VipCard;
import com.lianggeshipin.www.service.IAnimatedService;
import com.lianggeshipin.www.service.ICourseService;
import com.lianggeshipin.www.service.ICourseWhichService;
import com.lianggeshipin.www.service.IPlotService;
import com.lianggeshipin.www.service.IUserService;
import com.lianggeshipin.www.service.IVipCardService;
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
	@Resource
	private IUserService userService;
	@Resource
	private IVipCardService vipCardService;
	@Resource
	private ICourseService courseService;
	@Resource
	private ICourseWhichService courseWhichService;
	
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
				String plotNameCh = request.getParameter("plotNameCh"+integer);
				String plotNameEn = request.getParameter("plotNameEn"+integer);
				String videoUrlCh = request.getParameter("videoUrlCh"+integer);
				String videoUrlEn = request.getParameter("videoUrlEn"+integer);
				String imgUrl   = request.getParameter("imgUrl"+integer);
				Plot p = new Plot();
				p.setAnimatedID(animatedID);
				p.setWhichEpisode(Integer.valueOf(which));
				p.setPlotNameCh(plotNameCh);
				p.setPlotNameEn(plotNameEn);
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
			String plotNameCh = request.getParameter("plotNameCh");
			String plotNameEn = request.getParameter("plotNameEn");
			String whichEpisode = request.getParameter("whichEpisode");
			String videoUrlCh = request.getParameter("videoUrlCh");
			String videoUrlEn = request.getParameter("videoUrlEn");
			String imgUrl = request.getParameter("imgUrl");
			Plot p = plotService.queOne(pid);
			p.setTitle(title);
			p.setMeta(meta);
			p.setIntro(intro.replaceAll("\n", "<br/>"));  // 把换行换成html <br/>
			p.setDown(down); 
			p.setPlotNameCh(plotNameCh);
			p.setPlotNameEn(plotNameEn);
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
			List<Course> courseList = courseService.getListByPlotID(plot.getId());
			FreeMarkerUtil.createPlay(plot,arrayList,ani,courseList);
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
	
	@RequestMapping("/queUserPage.action")
	public String queUserPage(HttpServletRequest request,Model model){
		String s_page = request.getParameter("page");
		if(s_page==null || "".equals(s_page)){
			s_page="1";
		}
		List<User> userList = userService.getListPage(Integer.valueOf(s_page));
		// 如果数据量等于50，则进行分页查询
		if(userList.size() == 50){
			double count = userService.getUserCount();
			double pageSum =  Math.ceil(count / 50.0);
			model.addAttribute("pageSum",pageSum);
		}
		
		InitUtil.iniSystem(model);
		model.addAttribute("userList", userList);
		model.addAttribute("page",s_page);
		return "manage/userListPage";
	}
	
	@RequestMapping("/getUserByNickname.action")
	public String getUserByNickname(HttpServletRequest request,Model model){
		String nickname = request.getParameter("nickname");
		List<User> userList = userService.getUserByNickname(nickname);
		InitUtil.iniSystem(model);
		model.addAttribute("userList", userList);
		return "manage/userListPage";
	}
	
	@RequestMapping("/personal.action")
	public String personal(HttpServletRequest request,Model model){
		String userID = request.getParameter("userID");
		User user = userService.getOne(Integer.valueOf(userID));
		List<VipCard> vipCardList = vipCardService.getListByUserID(Integer.valueOf(userID));
		int vipCardNum = vipCardService.getCountByUserID(Integer.valueOf(userID));
		
		model.addAttribute("user",user);
		model.addAttribute("vipCardList",vipCardList);
		model.addAttribute("vipCardNum",vipCardNum);
		InitUtil.iniSystem(model);
		return "manage/personal";
	}
	
	@ResponseBody
	@RequestMapping("/sendVip.action")
	public String sendVip(HttpServletRequest request){
		String day = request.getParameter("day");
		String userID = request.getParameter("userID");
		JSONObject jo = new JSONObject();
		
		VipCard vipCard = new VipCard();
		vipCard.setEmploy("no");
		if("1".equals(day)){
			vipCard.setName("1天会员");
		}else if("7".equals(day)){
			vipCard.setName("7天会员");
		}else if("30".equals(day)){
			vipCard.setName("30天会员");
		}else if("365".equals(day)){
			vipCard.setName("1年会员");
		}else{
			jo.put("success", "2");
			jo.put("msg", "错误的参数");
			return jo.toString();
		}
		
		vipCard.setTime(new Timestamp(System.currentTimeMillis()));
		vipCard.setUserID(Integer.valueOf(userID));
		vipCardService.add(vipCard);
		jo.put("success", "1");
		jo.put("msg", "添加成功");
		return jo.toString();
	}
	
	@RequestMapping("/addCoursePage.action")
	public String addCoursePage(HttpServletRequest request,Model model){
		String plotID = request.getParameter("plotID");
		Plot plot = plotService.queOne(Integer.valueOf(plotID));
		model.addAttribute("plot",plot);
		InitUtil.iniSystem(model);
		return "manage/addCoursePage";
	}
	
	@ResponseBody
	@RequestMapping("/addCourse.action")
	public String addCourse(HttpServletRequest request){
		try{
			String plotID = request.getParameter("plotID");
			String courseName = request.getParameter("courseName");
			String userID = request.getParameter("userID");
			String courseUrl = request.getParameter("courseUrl");
			if(courseName==null || courseName.equals("") || userID==null || userID.equals("")){
				return "参数不能为空";
			}
			
			Course course = new Course();
			course.setName(courseName);
			course.setPlotID(Integer.valueOf(plotID));
			course.setUserID(Integer.valueOf(userID));
			course.setUrl(courseUrl);
			courseService.add(course);
			return "添加成功";
		}catch(Exception e){
			e.printStackTrace();
		}
		return "添加失败";
	}
	
	@RequestMapping("/getCourseListPage.action")
	public String getCourseListPage(HttpServletRequest request,Model model){
		String plotID = request.getParameter("plotID");
		List<Course> courseList = courseService.getListByPlotID(Integer.valueOf(plotID));
		InitUtil.iniSystem(model);
		model.addAttribute("courseList",courseList);
		return "manage/courseListPage";
	}
	
	@RequestMapping("/editCoursePage.action")
	public String editCoursePage(HttpServletRequest request,Model model){
		String courseID = request.getParameter("courseID");
		Course course = courseService.getOne(Integer.valueOf(courseID));
		model.addAttribute("course",course);
		InitUtil.iniSystem(model);
		return "manage/editCoursePage";
	}
	
	@ResponseBody
	@RequestMapping("/editCourse.action")
	public String editCourse(HttpServletRequest request){
		try{
			String courseID = request.getParameter("courseID");
			String plotID = request.getParameter("plotID");
			String userID = request.getParameter("userID_");
			String name = request.getParameter("name_");
			String url = request.getParameter("url_");
			
			Course course = new Course();
			course.setId(Integer.valueOf(courseID));
			course.setPlotID(Integer.valueOf(plotID));
			course.setUserID(Integer.valueOf(userID));
			course.setName(name);
			course.setUrl(url);
			courseService.up(course);
			
			return "修改成功";
		}catch(Exception e){
			e.printStackTrace();
		}
		return "修改失败";
	}
	
	@RequestMapping("/addCourseWhichPage.action")
	public String addCourseWhichPage(HttpServletRequest request,Model model){
		String courseID = request.getParameter("courseID");
		Course course = courseService.getOne(Integer.valueOf(courseID));
		model.addAttribute("course",course);
		InitUtil.iniSystem(model);
		return "manage/addCourseWhichPage";
	}
	
	@RequestMapping("/addCourseWhich.action")
	public String addCourseWhich(HttpServletRequest request,Model model){
		// 动漫的ID
		Integer courseID = Integer.valueOf(request.getParameter("courseID"));
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
				String name = request.getParameter("name"+integer); // 子集名
				String chargeUrl = request.getParameter("chargeUrl"+integer); // 收费URL
				String freeUrl = request.getParameter("freeUrl"+integer); // 免费URL
				String status   = request.getParameter("status"+integer); // 状态
				CourseWhich cw = new CourseWhich();
				cw.setChargeUrl(chargeUrl);
				cw.setCourseID(courseID);
				cw.setFreeUrl(freeUrl);
				cw.setName(name);
				cw.setStatus(Integer.valueOf(status));
				cw.setWhichEpisode(Integer.valueOf(which));
				courseWhichService.add(cw);
			}
		}
		
		InitUtil.iniSystem(model);
		return "manage/index";
	}
	
	@RequestMapping("/getCourseWhichListPage.action")
	public String getCourseWhichListPage(HttpServletRequest request,Model model){
		String courseID = request.getParameter("courseID");
		List<CourseWhich> whichList = courseWhichService.getListByCourseID(Integer.valueOf(courseID));
		model.addAttribute("whichList",whichList);
		InitUtil.iniSystem(model);
		return "manage/courseWhichListPage";
	}
	
	@RequestMapping("/editCourseWhichPage.action")
	public String editCourseWhichPage(HttpServletRequest request,Model model){
		String whichID = request.getParameter("whichID");
		CourseWhich courseWhich = courseWhichService.getOne(Integer.valueOf(whichID));
		model.addAttribute("courseWhich",courseWhich);
		InitUtil.iniSystem(model);
		return "manage/editCourseWhichPage";
	}
	
	@ResponseBody
	@RequestMapping("/editCourseWhich.action")
	public String editCourseWhich(HttpServletRequest request){
		try{
			String whichID = request.getParameter("whichID");
			String courseID = request.getParameter("courseID");
			String whichEpisode = request.getParameter("whichEpisode");
			String name = request.getParameter("name");
			String chargeUrl = request.getParameter("chargeUrl");
			String freeUrl = request.getParameter("freeUrl");
			String status = request.getParameter("status");
			
			CourseWhich cw = new CourseWhich();
			cw.setChargeUrl(chargeUrl);
			cw.setCourseID(Integer.valueOf(courseID));
			cw.setFreeUrl(freeUrl);
			cw.setId(Integer.valueOf(whichID));
			cw.setName(name);
			cw.setStatus(Integer.valueOf(status));
			cw.setWhichEpisode(Integer.valueOf(whichEpisode));
			courseWhichService.up(cw);
			return "修改成功";
		}catch(Exception e){
			e.printStackTrace();
		}
		return "修改失败";
	}
	
	@ResponseBody
	@RequestMapping("/createCourseHtml.action")
	public String createCourseHtml(HttpServletRequest request){
		String courseID = request.getParameter("courseID");
		Course course = courseService.getOne(Integer.valueOf(courseID));
		List<CourseWhich> whichList = courseWhichService.getListByCourseID(Integer.valueOf(courseID));
		
		Map<String,CourseWhich> m = new HashMap<String,CourseWhich>(); // <集数,CourseWhich>
		// 排序，按照集数排
		int[] array = new int[whichList.size()];
		int ar_i = 0;
		for(CourseWhich which:whichList){
			array[ar_i] = which.getWhichEpisode();
			m.put(which.getWhichEpisode()+"", which);
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
		List<CourseWhich> arrayList = new ArrayList<CourseWhich>(); // 用有序的arrayList放入排好的值
		for (int i = 0; i < array.length; i++) {
			arrayList.add(m.get(array[i]+""));
		}
		for(CourseWhich courseWhich:arrayList){
			FreeMarkerUtil.createCourse(course, courseWhich, arrayList);
		}
		return "成功";
	}
	
}