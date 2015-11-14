package com.xkeam.util;

import java.util.Date;

public class CommonUtil {
	public static String toString(Object o) throws Exception {
		return ResourceUtil.getObjectMapper().writeValueAsString(o);
	}
	
	
	public static String timeStamp() {
		return (new Date()).toString();
	}
	
	public static long time() {
		return System.currentTimeMillis();
	}
	
	public static long duration(long start) {
		return System.currentTimeMillis() - start;
	}
	
	public static byte[] stringToBytes(String input) {
		return input.getBytes();
	}
	
	public static String bytesToString(byte[] input) {
		return new String(input);
	}
	
	public static String bytes(byte[] input) {
		String result = "";
		for(int i = 0 ; i < input.length ; i ++) {
			result += input[i];
		}
		
		return result;
	}


}
