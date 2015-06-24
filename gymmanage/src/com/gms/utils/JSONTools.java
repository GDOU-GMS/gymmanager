package com.gms.utils;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

public class JSONTools {

	/**
	 * �õ�json��������ظ�ͻ��� 
	 * @param statusCode 200�ɹ���300ʧ�ܣ�301��ʱ
	 * @param message ���ص���Ϣ
	 * @param navTabId ��Ҫ���¼��ص�navTab��id
	 * @param callbackType closeCurrent||forward
	 * @param forwardUrl ת��ҳ��ĵ�ַ
	 * @return
	 * 
	 * 
		statusCode:"200",
		message:"返回数据",
		navTabId:"",
		rel:"返回需要刷新的DIV的ID",				                                                        
		callbackType:"",
		forwardUrl:"",
		confirmMsg:""
	 */
	public static String getJSONString(String statusCode, String message,String navTabId,String callbackType,String forwardUrl){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("statusCode", statusCode);// 200�ɹ���300ʧ�ܣ�301��ʱ
		map.put("message", message);//���ص���Ϣ
		map.put("navTabId", navTabId);//��Ҫ���¼��ص�navTab��id
		map.put("forwardUrl", forwardUrl);//ת��ҳ��ĵ�ַ
		map.put("callbackType", callbackType);//callbackType�����closeCurrent�ͻ�رյ�ǰtab------�����"forward"ת��������ҳ��
		return JSONObject.fromObject(map).toString();
	}
}
