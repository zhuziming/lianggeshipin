package com.lianggeshipin.www.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.lianggeshipin.www.model.CourseWhich;
import com.lianggeshipin.www.model.Plot;
import com.lianggeshipin.www.model.User;
import com.lianggeshipin.www.model.VipCard;
import com.lianggeshipin.www.model.Word_1000;
import com.lianggeshipin.www.model.Word_4500;
import com.lianggeshipin.www.service.ICourseWhichService;
import com.lianggeshipin.www.service.IPlotService;
import com.lianggeshipin.www.service.IUserService;
import com.lianggeshipin.www.service.IVipCardService;
import com.lianggeshipin.www.service.IWord_1000Service;
import com.lianggeshipin.www.service.IWord_4500Service;
import com.lianggeshipin.www.util.DateUtil;
import com.lianggeshipin.www.util.InitUtil;
import com.lianggeshipin.www.util.PropertiesUtil;

@Controller
@RequestMapping("/front")
public class FrontController {

	@Resource
	private IWord_1000Service word_1000Service;
	@Resource
	private IWord_4500Service word_4500Service;
	@Resource
	private IPlotService plotService;
	@Resource
	private IUserService userService;
	@Resource
	private IVipCardService vipCardService;
	@Resource
	private ICourseWhichService courseWhichService;
	/**
	 * @description 得到页数，然后返回页面
	 * @author zhuziming
	 * @time 2020年12月18日 下午12:59:37
	 * @return
	 */
	@RequestMapping("/word1000Page.action")
	public String getWord1000Page(HttpServletRequest request,Model model){
		Integer num=null;
		try{
			num = Integer.valueOf(request.getParameter("pageNum")); // 页数
		}catch(Exception e){
			num=1;
		}
		// 一共有822条数据，每一页20条，最多有42页。
		if(num<1){ num=1; } 
		if(num>42){ num=42; }
		List<Word_1000> wordList = word_1000Service.getPage(num);
		for (Word_1000 word_1000 : wordList) {
			word_1000.setDescription(word_1000.getDescription().replaceAll("\r", "<br>").replaceAll("\t", "<br>"));
		}
		model.addAttribute("wordList", wordList);
		model.addAttribute("pageNum",num); // 当前第几页
		InitUtil.iniSystem(model);
		return "front/word1000";
	}
	
	@ResponseBody
	@RequestMapping("/getWord1000.action")
	public String getWord1000(HttpServletRequest request){
		try{
			Integer num=null;
			try{
				num = Integer.valueOf(request.getParameter("pageNum")); // 页数
			}catch(Exception e){
				num=1;
			}
			// 一共有822条数据，每一页20条，最多有42页。
			if(num<1){ num=1; } 
			if(num>42){ 
				return "{\"success\":\"2\"}";
			}
			List<Word_1000> wordList = word_1000Service.getPage(num);
			StringBuffer sb = new StringBuffer();
			for (Word_1000 word_1000 : wordList) {
				sb.append("<div class='col-xl-6 col-lg-6 col-md-6 col-sm-12'>");
				sb.append("<img src='"+ PropertiesUtil.getValue("system.properties", "indexpath") +"/word1000Img/"+ word_1000.getWord() +"."+ word_1000.getImg_format() +"' class='img-fluid rounded float-right'>");
				sb.append("</div>");
				sb.append("<div class='col-xl-6 col-lg-6 col-md-6 col-sm-12'>");
				sb.append("<table class='table'>");
				sb.append("<tbody>");
				sb.append("<tr>");
				sb.append("<td>");
				sb.append("<h1>"+ word_1000.getWord() +"</h1>");
				sb.append(word_1000.getDescription());
				sb.append("</td>");
				sb.append("</tr>");
				if(word_1000.getEn_sentence_1()!=null && !word_1000.getEn_sentence_1().isEmpty()){
					sb.append("<tr>");
					sb.append("<td>");
					sb.append("<button type='button' class='btn btn-success'>英文句1</button>");
					sb.append(word_1000.getEn_sentence_1());
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td>");
					sb.append("<button type='button' class='btn btn-success'>中文句1</button>");
					sb.append(word_1000.getCh_sentence_1());
					sb.append("</td>");
					sb.append("</tr>");
				}
				if(word_1000.getEn_sentence_2()!=null && !word_1000.getEn_sentence_2().isEmpty()){
					sb.append("<tr>");
					sb.append("<td>");
					sb.append("<button type='button' class='btn btn-info'>英文句2</button>");
					sb.append(word_1000.getEn_sentence_2());
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td>");
					sb.append("<button type='button' class='btn btn-info'>中文句2</button>");
					sb.append(word_1000.getCh_sentence_2());
					sb.append("</td>");
					sb.append("</tr>");
				}
				
				sb.append("<tr>");
				sb.append("<td>");
				sb.append("<button onclick=\"document.getElementById('uk_"+ word_1000.getWord() +"').play()\" type=\"button\" class=\"btn btn-primary\"><audio id=\"uk_"+ word_1000.getWord() +"\" src=\""+ PropertiesUtil.getValue("system.properties", "indexpath") +"/mp3/word1000/uk/"+ word_1000.getWord() +".mp3\"  class=\"musicFlag\"></audio>英语发音<svg viewBox=\"0 0 24 24\" width=\"24\" height=\"24\" stroke=\"currentColor\" stroke-width=\"2\" fill=\"none\" stroke-linecap=\"round\" stroke-linejoin=\"round\" class=\"css-i6dzq1\"><path d=\"M9 18V5l12-2v13\"></path><circle cx=\"6\" cy=\"18\" r=\"3\"></circle><circle cx=\"18\" cy=\"16\" r=\"3\"></circle></svg></button>");
				sb.append("<button onclick=\"document.getElementById('us_"+ word_1000.getWord() +"').play()\" type=\"button\" class=\"btn btn-primary\"><audio id=\"us_"+ word_1000.getWord() +"\" src=\""+ PropertiesUtil.getValue("system.properties", "indexpath") +"/mp3/word1000/us/"+ word_1000.getWord() +".mp3\"></audio>美语发音<svg viewBox=\"0 0 24 24\" width=\"24\" height=\"24\" stroke=\"currentColor\" stroke-width=\"2\" fill=\"none\" stroke-linecap=\"round\" stroke-linejoin=\"round\" class=\"css-i6dzq1\"><path d=\"M9 18V5l12-2v13\"></path><circle cx=\"6\" cy=\"18\" r=\"3\"></circle><circle cx=\"18\" cy=\"16\" r=\"3\"></circle></svg></button>");
				sb.append("</td>");
				sb.append("</tr>");
				sb.append("</tbody>");
				sb.append("</table>");
				sb.append("</div>"); 
			}
			JSONObject jo = new JSONObject();
			jo.put("success", "1");
			jo.put("pageNum", num);
			jo.put("ele", sb.toString());
			return jo.toJSONString();
		}catch(Exception e){
			return "{\"success\":\"2\"}";
		}
	}
	
	
	@RequestMapping("/word4500Page.action")
	public String getWord4500Page(HttpServletRequest request,Model model){
		Integer num=null;
		try{
			num = Integer.valueOf(request.getParameter("pageNum")); // 页数
		}catch(Exception e){
			num=1;
		}
		// 一共有4310条数据，每一页20条，最多有216页。
		if(num<1){ num=1; } 
		if(num>216){ num=216; }
		List<Word_4500> wordList = word_4500Service.getPage(num);
		for (Word_4500 word_4500 : wordList) {
			word_4500.setDescription(word_4500.getDescription().replaceAll("\r", "<br>").replaceAll("\t", "<br>"));
		}
		model.addAttribute("wordList", wordList);
		model.addAttribute("pageNum",num); // 当前第几页
		InitUtil.iniSystem(model);
		return "front/word4500";
	}
	
	
	@ResponseBody
	@RequestMapping("/getWord4500.action")
	public String getWord4500(HttpServletRequest request){
		try{
			Integer num=null;
			try{
				num = Integer.valueOf(request.getParameter("pageNum")); // 页数
			}catch(Exception e){
				num=1;
			}
			// 一共有4310条数据，每一页20条，最多有216页。
			if(num<1){ num=1; } 
			if(num>216){ 
				return "{\"success\":\"2\"}";
			}
			List<Word_4500> wordList = word_4500Service.getPage(num);
			StringBuffer sb = new StringBuffer();
			for (Word_4500 word_4500 : wordList) {
				sb.append("<div class='col-xl-6 col-lg-6 col-md-6 col-sm-12'>");
				sb.append("<img src='"+ PropertiesUtil.getValue("system.properties", "indexpath") +"/word4500Img/"+ word_4500.getWord() +"."+ word_4500.getImg_format() +"' class='img-fluid rounded float-right'>");
				sb.append("</div>");
				sb.append("<div class='col-xl-6 col-lg-6 col-md-6 col-sm-12'>");
				sb.append("<table class='table'>");
				sb.append("<tbody>");
				sb.append("<tr>");
				sb.append("<td>");
				sb.append("<h1>"+ word_4500.getWord() +"</h1>");
				sb.append(word_4500.getDescription());
				sb.append("</td>");
				sb.append("</tr>");
				if(word_4500.getEn_sentence_1()!=null && !word_4500.getEn_sentence_1().isEmpty()){
					sb.append("<tr>");
					sb.append("<td>");
					sb.append("<button type='button' class='btn btn-success'>英文句1</button>");
					sb.append(word_4500.getEn_sentence_1());
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td>");
					sb.append("<button type='button' class='btn btn-success'>中文句1</button>");
					sb.append(word_4500.getCh_sentence_1());
					sb.append("</td>");
					sb.append("</tr>");
				}
				if(word_4500.getEn_sentence_2()!=null && !word_4500.getEn_sentence_2().isEmpty()){
					sb.append("<tr>");
					sb.append("<td>");
					sb.append("<button type='button' class='btn btn-info'>英文句2</button>");
					sb.append(word_4500.getEn_sentence_2());
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td>");
					sb.append("<button type='button' class='btn btn-info'>中文句2</button>");
					sb.append(word_4500.getCh_sentence_2());
					sb.append("</td>");
					sb.append("</tr>");
				}
				
				sb.append("<tr>");
				sb.append("<td>");
				sb.append("<button onclick=\"document.getElementById('uk_"+ word_4500.getWord() +"').play()\" type=\"button\" class=\"btn btn-primary\"><audio id=\"uk_"+ word_4500.getWord() +"\" src=\""+ PropertiesUtil.getValue("system.properties", "indexpath") +"/mp3/word4500/uk/"+ word_4500.getWord() +".mp3\"  class=\"musicFlag\"></audio>英语发音<svg viewBox=\"0 0 24 24\" width=\"24\" height=\"24\" stroke=\"currentColor\" stroke-width=\"2\" fill=\"none\" stroke-linecap=\"round\" stroke-linejoin=\"round\" class=\"css-i6dzq1\"><path d=\"M9 18V5l12-2v13\"></path><circle cx=\"6\" cy=\"18\" r=\"3\"></circle><circle cx=\"18\" cy=\"16\" r=\"3\"></circle></svg></button>");
				sb.append("<button onclick=\"document.getElementById('us_"+ word_4500.getWord() +"').play()\" type=\"button\" class=\"btn btn-primary\"><audio id=\"us_"+ word_4500.getWord() +"\" src=\""+ PropertiesUtil.getValue("system.properties", "indexpath") +"/mp3/word4500/us/"+ word_4500.getWord() +".mp3\"></audio>美语发音<svg viewBox=\"0 0 24 24\" width=\"24\" height=\"24\" stroke=\"currentColor\" stroke-width=\"2\" fill=\"none\" stroke-linecap=\"round\" stroke-linejoin=\"round\" class=\"css-i6dzq1\"><path d=\"M9 18V5l12-2v13\"></path><circle cx=\"6\" cy=\"18\" r=\"3\"></circle><circle cx=\"18\" cy=\"16\" r=\"3\"></circle></svg></button>");
				sb.append("</td>");
				sb.append("</tr>");
				sb.append("</tbody>");
				sb.append("</table>");
				sb.append("</div>"); 
			}
			JSONObject jo = new JSONObject();
			jo.put("success", "1");
			jo.put("pageNum", num);
			jo.put("ele", sb.toString());
			return jo.toJSONString();
		}catch(Exception e){
			return "{\"success\":\"2\"}";
		}
	}
	
	
	// 只有管理员能用的登录
	@ResponseBody
	@RequestMapping("/signIn.action")
	public String signIn(HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if("18237126723".equals(username) && "ming0000".equals(password)){
			request.getSession().setAttribute("username", "18237126723");
			return "{\"success\":\"1\"}";
		}else{
			return "{\"success\":\"2\"}";
		}
	}
	
	@ResponseBody
	@RequestMapping("/getPlot.action")
	public String getPlot(HttpServletRequest request){
		try{
			Integer animatedID = Integer.valueOf(request.getParameter("animatedID"));
			Integer pageNum = Integer.valueOf(request.getParameter("pageNum"));
			List<Plot> pList = plotService.queListByAnimatedIDLimit(animatedID,pageNum);
			if(pList.size()>0){
				StringBuffer sb = new StringBuffer();
				String indexpath = PropertiesUtil.getValue("system.properties", "indexpath");
				String animatedImgPath = PropertiesUtil.getValue("system.properties", "animatedImgPath");
				for(Plot plot:pList){
					sb.append("<div class=\"col-xl-3 col-lg-4 col-md-6 col-sm-12\">");
					sb.append("<a target=\"_blank\" href=\""+indexpath+"/"+animatedID+"/"+plot.whichEpisode+".html\">");
					sb.append("<img src=\""+animatedImgPath+"/"+animatedID+"/"+plot.imgUrl+"\" class=\"img-fluid\" alt=\""+plot.plotNameCh+"\">");
					sb.append("<p class=\"l-plot-sort\">"+plot.plotNameCh+"</p>");
					sb.append("</a>");
					sb.append("</div>");
				}
				JSONObject jo = new JSONObject();
				jo.put("success", "1");
				jo.put("ele", sb.toString());
				return jo.toJSONString();
			}else{
				JSONObject jo = new JSONObject();
				jo.put("success", "2");
				return jo.toJSONString();
			}
		}catch(Exception e){
			e.printStackTrace();
			JSONObject jo = new JSONObject();
			jo.put("success", "3");
			return jo.toJSONString();
		}
	}
	
	@ResponseBody
	@RequestMapping("/getUserName.action")
	public String getUserName(HttpSession session){
		Object obj = session.getAttribute("user");
		JSONObject jo = new JSONObject();
		
		if(obj==null){
			jo.put("success", "2");
		}else{
			jo.put("success", "1");
			jo.put("ele", ((User)obj).getNickname());
		}
		return jo.toJSONString();
	}
	
	@ResponseBody
	@RequestMapping("/isVip.action")
	public String isVip(HttpSession session){
		Object obj = session.getAttribute("user");
		JSONObject jo = new JSONObject();
		if(obj==null){
			jo.put("success", "2");
			jo.put("msg", "你还没有登录，请先登录");
			return jo.toString();
		}
		long vip_time = ((User)obj).getVipTime().getTime(); // 会员时间
		long now_time = System.currentTimeMillis(); // 系统当前时间
		if(vip_time < now_time){ // 如果会员时间，小于当前时间，说明不是会员
			jo.put("success", "2");
			jo.put("msg", "你还不是会员，请先充值");
			return jo.toString();
		}
		jo.put("success", "1");
		return jo.toString();
	}
	
	@RequestMapping("/getPlay.action")
	public String getPlay(HttpServletRequest request,HttpSession session){
		Object obj = session.getAttribute("user");
		if(obj==null){
			return "你还没有登录，请先登录";
		}
		long vip_time = ((User)obj).getVipTime().getTime(); // 会员时间
		long now_time = System.currentTimeMillis(); // 系统当前时间
		if(vip_time < now_time){ // 如果会员时间，小于当前时间，说明不是会员
			return "你还不是会员，请先充值";
		}
		
		
		String type = request.getParameter("type");  // [ch:中文][en:英文]
		String plotID = request.getParameter("plotID");// 视频id
		
		if(plotID==null || "".equals(plotID)){
			return "错误的请求";
		}
		
		Plot plot = plotService.queOne(Integer.valueOf(plotID));
		if(plot==null){
			return "错误的请求";
		}
		
		if("ch".equals(type)){
			return "redirect:" + plot.getVideoUrlCh();
		}else if("en".equals(type)){
			return "redirect:" + plot.getVideoUrlEn();
		}else{
			return "错误的请求";
		}
	}
	
	@RequestMapping("/personal.action")
	public String personal(HttpSession session,Model model){
		Object obj = session.getAttribute("user");
		if(obj==null){
			return "404";
		}

		User user = (User)obj;
		List<VipCard> vipCardList = vipCardService.getListByUserID(user.getId());
		int vipCardNum = vipCardService.getCountByUserID(user.getId());
		
		model.addAttribute("user",user);
		model.addAttribute("vipCardList",vipCardList);
		model.addAttribute("vipCardNum",vipCardNum);
		InitUtil.iniSystem(model);
		return "front/personal";
	}
	
	/**
	 * @description 激活会员卡
	 * @author zhuziming
	 * @time 2021年4月16日 下午3:54:07
	 * @param request
	 * @return
	 */
	@ResponseBody
	@Transactional
	@RequestMapping("/activation.action")
	public String activation(HttpServletRequest request){
		String vipCardID = request.getParameter("vipCardID");
		VipCard vipCard = vipCardService.getOne(Integer.valueOf(vipCardID));
		JSONObject jo = new JSONObject();
		if(vipCard!=null){
			Object obj = request.getSession().getAttribute("user");
			if(obj!=null){
				User user = (User)obj;
				if(user.getId()==vipCard.getUserID()){ // 验证这个会员卡是否是这个用户的
					// 1、把会员卡的状态改为使用过
					vipCard.setEmploy("yes");
					vipCardService.up(vipCard);
					// 2、把用户的会员时间改变
					Timestamp user_timestamp = user.getVipTime();
					Timestamp newTime = new Timestamp(System.currentTimeMillis());
					if(user_timestamp.getTime() < System.currentTimeMillis()){
						// 如果用户的时间小于当前时间，说明会员已过期，将当前时间做为开始时间
						user_timestamp = new Timestamp(System.currentTimeMillis());
					}
					if("1天会员".equals(vipCard.getName())){
						newTime = DateUtil.timeAddDayToTimestamp(user_timestamp,1);
					}else if("7天会员".equals(vipCard.getName())){
						newTime = DateUtil.timeAddDayToTimestamp(user_timestamp,7);
					}else if("30天会员".equals(vipCard.getName())){
						newTime = DateUtil.timeAddDayToTimestamp(user_timestamp,30);
					}else if("1年会员".equals(vipCard.getName())){
						newTime = DateUtil.timeAddDayToTimestamp(user_timestamp,365);
					}
					user.setVipTime(newTime);
					userService.upVipTime(user);
					request.getSession().setAttribute("user", user); // 刷新session
					jo.put("success", "1");
					jo.put("msg", "激活成功");
					return jo.toString();
				}
			}
		}
		jo.put("success", "2");
		jo.put("msg", "失败，请联系客服处理");
		return jo.toString();
	}
	
	@RequestMapping("/getCourse.action")
	public String getCourse(HttpServletRequest request,HttpSession session){
		String courseWhichID = request.getParameter("courseWhichID");
		CourseWhich courseWhich = courseWhichService.getOne(Integer.valueOf(courseWhichID));
		
		Object obj = session.getAttribute("user");
		if(obj==null){ // 未登录的流程
			if(courseWhich.getStatus()==1){ // 免费
				return "redirect:" + courseWhich.getFreeUrl();
			}
		}else{ // 登录后的流程
			long vip_time = ((User)obj).getVipTime().getTime(); // 会员时间
			long now_time = System.currentTimeMillis(); // 系统当前时间
			if(vip_time < now_time){ // 不是会员
				if(courseWhich.getStatus()==1){ // 免费
					return "redirect:" + courseWhich.getFreeUrl();
				}
			}else{ // 是会员
				return "redirect:" + courseWhich.getChargeUrl();
			}
		}
		return "您还不是会员";
	}
	
	@ResponseBody
	@RequestMapping("/isCoursePlay.action")
	public boolean isCoursePlay(HttpServletRequest request,HttpSession session){
		String courseWhichID = request.getParameter("courseWhichID");
		CourseWhich courseWhich = courseWhichService.getOne(Integer.valueOf(courseWhichID));
		boolean flag=false ; // 这个课程能播吗？
		Object obj = session.getAttribute("user");
		if(obj==null){ // 未登录的流程
			if(courseWhich.getStatus()==1){ // 免费
				flag=true;
			}
		}else{ // 登录后的流程
			long vip_time = ((User)obj).getVipTime().getTime(); // 会员时间
			long now_time = System.currentTimeMillis(); // 系统当前时间
			if(vip_time < now_time){ // 不是会员
				if(courseWhich.getStatus()==1){ // 免费
					flag=true;
				}
			}else{ // 是会员
				flag=true;
			}
		}
		return flag;
	}
	
}
