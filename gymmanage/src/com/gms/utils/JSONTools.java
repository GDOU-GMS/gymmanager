package com.gms.utils;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

public class JSONTools {

	/**
	 * 得到json数据留返回给客户端 
	 * @param statusCode 200成功，300失败，301超时
	 * @param message 返回的消息
	 * @param navTabId 需要重新加载的navTab的id
	 * @param callbackType closeCurrent||forward
	 * @param forwardUrl 转发页面的地址
	 * @return
	 */
	public static String getJSONString(String statusCode, String message,String navTabId,String callbackType,String forwardUrl){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("statusCode", statusCode);// 200成功，300失败，301超时
		map.put("message", message);//返回的消息
		map.put("navTabId", navTabId);//需要重新加载的navTab的id
		map.put("forwardUrl", forwardUrl);//转发页面的地址
		map.put("callbackType", callbackType);//callbackType如果是closeCurrent就会关闭当前tab------如果是"forward"转发到其他页面
		return JSONObject.fromObject(map).toString();
	}
}
