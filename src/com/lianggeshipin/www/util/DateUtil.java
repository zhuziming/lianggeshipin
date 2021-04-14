package com.lianggeshipin.www.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description 时间工具类
 * @author zhuziming
 * @time 2018年6月24日 下午5:29:53
 */
public class DateUtil {

	/**
	 * @description 格式化时间为字符串
	 * @author zhuziming
	 * @time 2018年6月24日 下午5:34:50
	 * @param timestamp
	 * @return
	 */
	public static String formatTimestampToStr(Timestamp timestamp){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(timestamp);
	}
	
	/**
	 * @description 格式化时间为字符串
	 * @author zhuziming
	 * @time 2018年6月24日 下午5:34:50
	 * @param timestamp
	 * @return
	 * @throws ParseException 
	 */
	public static String formatTimestampToStr(String time) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse(time);
		return sdf.format(date);
	}
	
	/**
	 * @description 时间 + 天数
	 * @author zhuziming
	 * @time 2021年4月13日 下午3:58:28
	 * @param timestamp
	 * @param day
	 * @return
	 */
	public static String timeAddDay(Timestamp timestamp,Integer day){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long nowTime = timestamp.getTime() + day*24*60*60*1000L;
		return sdf.format(nowTime);
	}
	
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long curSysTime = System.currentTimeMillis();
	      System.out.println(curSysTime);
	      System.out.println(new Date(curSysTime));

	      long deadtime=curSysTime-7*24*60*60*1000L;
	      System.out.println(deadtime);
	      System.out.println(new Date(deadtime));
	      System.out.println(sdf.format(deadtime));
	      
	      Timestamp ta = new Timestamp(System.currentTimeMillis());
	      System.out.println(ta.getTime());
	      

	      Date date = sdf.parse("2022-01-01 00:00:00");
	      System.out.println(System.currentTimeMillis() > date.getTime());
	      
	      
	}
	
}
