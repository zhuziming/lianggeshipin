package com.lianggeshipin.www.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.lianggeshipin.www.model.User;
import com.lianggeshipin.www.service.IUserService;
import com.lianggeshipin.www.util.HTTPUtil;
import com.lianggeshipin.www.util.WeiXinUtil;

@Controller
public class IndexController {

	@Resource
	private IUserService userService;
	
	/**
	 * @description 微信授权重定向的地址
	 * @author zhuziming
	 * @time 2021年3月28日 下午2:45:10
	 * @return
	 */
	@RequestMapping("/weixinRedirect.action")
	public String weixinRedirect(HttpServletRequest request){
		try{
			/* 第一步：得到code，若用户拒绝授权则不会有code
			code : 061WFXzm15Zr9p0i5Uym1BwmAm1WFXz1
			state : STATE
			*/
			String code = request.getParameter("code");
			String state = request.getParameter("state");
			if(code==null || code.equals("")){
				return "redirect:index.html";
			}
			
			/*
			 第二步：通过code获取access_token
			 {
			 	接口调用凭证
			 	"access_token":"18_DPAb9SnjSKKagLZ-5re-WrciBn4K_vby3R3r42fuCeqGVSeogpAlOYRJjLAdER5F5_CysNklsA7g_nEQr4P75A",
			 	接口调用凭证超时时间，单位（秒）
			 	"expires_in":7200,
			 	用户刷新access_token
			 	"refresh_token":"18_TlVmax0ZfUnrurPoPwyAmeVmRkABfBlUGn89BlOeDJZxGXfehvnBzhrfBN_z34jEQuMgtXyhaqrHG790zhfJmA",
			 	授权用户唯一标识
			 	"openid":"oLFgI53HSP8RwGUAdaUuvgb9x3FE",
			 	用户授权的作用域，使用逗号（,）分隔
			 	"scope":"snsapi_login",
			 	当且仅当该网站应用已获得该用户的userinfo授权时，才会出现该字段。
			 	"unionid":"obuRDxF51lsYf-9QBbS7vLN4SAqs"
			 }
			 
			 */
			String getTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token";
			String getTokenParam = "appid="+WeiXinUtil.appid+"&secret="+WeiXinUtil.appSecret+"&code="+code+"&grant_type=authorization_code";
			String tokenResult = HTTPUtil.httpsRequest(getTokenUrl, "GET", getTokenParam);
			JSONObject tokenJsonResult = JSONObject.parseObject(tokenResult);
			
			/* 第三步：获取用户信息
			 {"city":"Zhengzhou",
			 "country":"CN",
			 "headimgurl":"https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJvQAGEVpjYNuYqsencm9HOOzGwNpicCLPZeXxQ5AkEtce7ic9OnbXOd0fCHg485yZFwVqOoVSfibo5w/132",
			 "language":"zh_CN",
			 "nickname":"大力",
			 "openid":"ol8YU6j2MuuILpRCq_z_bddCVSms",
			 "privilege":[],
			 "province":"Henan",
			 "sex":1,
			 "unionid":"o0AaI6Bg2_a0gTrgucpTerYfCIVs"}
			 * */
			
			String getInfoUrl = "https://api.weixin.qq.com/sns/userinfo";
			String getInfoParam = "access_token="+tokenJsonResult.getString("access_token")+"&openid="+tokenJsonResult.getString("openid");
			String getInfoResult = HTTPUtil.httpsRequest(getInfoUrl, "GET", getInfoParam);
			JSONObject infoJsonResult = JSONObject.parseObject(getInfoResult);

			String openid = infoJsonResult.getString("openid");
			String nickname = infoJsonResult.get("nickname").toString();
			String sex = infoJsonResult.get("sex").toString(); // 1为男性，2为女性
			String unionid = infoJsonResult.get("unionid").toString();
			String headimgurl = infoJsonResult.get("headimgurl").toString();

			User user = userService.getOneByAppID(unionid);
			// 若用户第一次登陆，插入数据库
			if(user==null){
				user = new User();
				user.setOnlyID(openid);
				user.setAppID(unionid);
				user.setSex(sex);
				user.setPicture(headimgurl);
				user.setNickname(nickname);
				userService.add(user);
				// 第一次登陆时，user对象还没有时间参数，所以从数据库中查一次
				user = userService.getOneByAppID(unionid);
			}else{
			// 若用户第二次登陆，则不做操作	
				
			}
			request.getSession().setAttribute("user", user);

		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:index.html";
	}
	
}
