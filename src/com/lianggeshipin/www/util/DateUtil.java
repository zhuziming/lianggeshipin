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
	
	public static long timeAddDayToLong(Timestamp timestamp,Integer day){
		long nowTime = timestamp.getTime() + day*24*60*60*1000L;
		return nowTime;
	}
	
	public static Timestamp timeAddDayToTimestamp(Timestamp timestamp,Integer day){
		long nowTime = timestamp.getTime() + day*24*60*60*1000L;
		return new Timestamp(nowTime);
	}
	
	public static void main(String[] args) throws ParseException {
		
		
		Timestamp t = timeAddDayToTimestamp(new Timestamp(System.currentTimeMillis()),1);
		System.out.println(t);
	}
	
}
