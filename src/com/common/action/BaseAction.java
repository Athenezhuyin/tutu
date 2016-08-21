package com.common.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JsonUtil;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @Title: BaseAction.java
 * @Package com.common.action
 * @Description: 所有Action继承BaseAction,BaseAction继承ActionSupport
 * @author Guo
 * @date 2016年7月26日 下午3:36:21
 * @version 1.0
 */
public class BaseAction extends ActionSupport{
	public void write(String html){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().print(html);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeJson(Object obj){
		write(JsonUtil.fromObject(obj));
	}
	
	public void writeAddrJson(List<Object[]> list){
	//	String str = "{\"list\":[";
		String str = "{[";
		int count = list.size();
		if(list != null){
			for(Object[] objs : list){
				if((int)objs[0] < count){
					str = str + "{\"id\":" + objs[0] + ",\"name\":\"" + objs[1] + "\"},";
				}else{
					str = str + "{\"id\":" + objs[0] + ",\"name\":\"" + objs[1] + "\"}";
				}
			}
			str += "]}";
		}
		write(str);
	}
}
