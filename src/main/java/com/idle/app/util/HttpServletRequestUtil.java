package com.idle.app.util;

import javax.servlet.http.HttpServletRequest;

public class HttpServletRequestUtil {
	public static int getInt(HttpServletRequest request, String key) {
		try {
			return Integer.decode(request.getParameter(key));
		}catch(Exception e) {
			return -1;
		}
	}
	
	public static long getLong(HttpServletRequest request, String key) {
		try {
			return Long.valueOf(request.getParameter(key));
		}catch(Exception e) {
			return -1;
		}
	}
	
	public static Double getDouble(HttpServletRequest request, String key) {
		try {
			return Double.valueOf(request.getParameter(key));
		}catch(Exception e) {
			return -1d;
		}
	}
	
	public static Boolean getBoolean(HttpServletRequest request, String key) {
		try {
			return Boolean.valueOf(request.getParameter(key));
		}catch(Exception e) {
			return false;
		}
	}
	
	public static String getString(HttpServletRequest request, String key) {
		try {
			//读取request中body的值并转化为字符串
//			StringBuilder buffer = new StringBuilder();
//		    BufferedReader reader = request.getReader();
//		    String line;
//		    while ((line = reader.readLine()) != null) {
//		        buffer.append(line);
//		    }
//		    String data = buffer.toString();
//		    System.out.println("data:"+data);
//		    
//			int beginForApply = data.indexOf("\"{\\\"lostPersonName");
//			int endForApply = data.indexOf(",\"peopleSearchApplyImg");
//			String result = data.substring(beginForApply, endForApply);
//			System.out.println("result:"+result);
			
			String result = request.getParameter(key);
			if(result != null) {
				result = result.trim();
			}
			if("".equals(result)) {
				result = null;
			}
			return result;
		}catch(Exception e) {
			return null;
		}
	}
}