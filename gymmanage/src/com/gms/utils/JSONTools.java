package com.gms.utils;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

public class JSONTools {

	public static String getJSONString(String statusCode, String message){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("statusCode", statusCode);// 200³É¹¦£¬300Ê§°Ü£¬301³¬Ê±
		map.put("message", message);
		map.put("navTabId", "navNewsLi");
		map.put("forwardUrl", "");
		map.put("callbackType", "closeCurrent");
		return JSONObject.fromObject(map).toString();
	}
}
