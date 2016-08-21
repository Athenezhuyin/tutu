package com.common.util;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

/**
 * 
 * @Title: DateConvert.java
 * @Package com.common.util
 * @Description: 解决中英文浏览器兼容性问题
 * @author Guo
 * @date 2016年7月26日 下午5:30:55
 * @version 1.0
 */
public class DateConvert extends DefaultTypeConverter{

	@Override
	public Object convertValue(Map<String, Object> context, Object value,
			Class toType) {

		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleDateFormat1s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat simpleDateFormat2s = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy_MM_dd");
		SimpleDateFormat simpleDateFormat3s = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss");
		
		SimpleDateFormat simpleDateFormat4s = new SimpleDateFormat("HH:mm:ss");
		
		String[] para =  (String[]) value;
		
		String strDate = para[0];
		
		try {
	//1. java.util.date
			if(toType == Date.class){
				
				if(strDate.contains("-")){
					if(strDate.contains(":")){
						return simpleDateFormat1s.parse(strDate);
					}else{
						return simpleDateFormat1.parse(strDate);
					}
				}
				if(strDate.contains("/")){
					if(strDate.contains(":")){
						return simpleDateFormat2s.parse(strDate);
					}else{
						return simpleDateFormat2.parse(strDate);
					}
				}
				if(strDate.contains("_")){
					if(strDate.contains(":")){
						return simpleDateFormat3s.parse(strDate);
					}else{
						return simpleDateFormat3.parse(strDate);
					}
				}
			}
	//2. java.sql.Timestamp	
			if(toType == java.sql.Timestamp.class){
				
				if(strDate.contains("_")){
					if(strDate.contains(":")){
						return new Timestamp(simpleDateFormat3s.parse(strDate).getTime());
					}else{
						return new Timestamp(simpleDateFormat3.parse(strDate).getTime());
					}
				}
				
				if(strDate.contains("/")){
					if(strDate.contains(":")){
						return new Timestamp(simpleDateFormat2s.parse(strDate).getTime());
					}else{
						return new Timestamp(simpleDateFormat2.parse(strDate).getTime());
					}
				}
				
				if(strDate.contains("-")){
					if(strDate.contains(":")){
						return new Timestamp(simpleDateFormat1s.parse(strDate).getTime());
					}else{
						return new Timestamp(simpleDateFormat1.parse(strDate).getTime());
					}
				}
			}
		//3. Time
			if(toType == java.sql.Time.class){
				
				return new Time(simpleDateFormat4s.parse(strDate).getTime());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
