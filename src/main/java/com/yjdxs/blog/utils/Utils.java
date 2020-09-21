package com.yjdxs.blog.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/***
 * 工具类
 * @author 123456
 *
 */
public class Utils {
	/**
	 * 获取UUID
	 * @return
	 */
	public static String GetUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	/***
	 * 返回当前的时间
	 * @return
	 */
	public static String gryNowTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		return df.format(new Date());
	}
	/***
	 * 将当前的时间转化为字符串
	 * @param date
	 * @return
	 */
	public static String gryNowTime(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		return df.format(date);
	}
}
