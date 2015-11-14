package com.xkeam.event_bus;

import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import com.xkeam.util.LoggerUtil;

public class LogAPI {
	public static Logger logger = LoggerUtil.getDailyLogger("RedisCache" + "_log");
	
	public static class Log {
		private Map<String, Logger> logMap = new HashMap<String, Logger>();
		
		public void initMinuteLog(String channel) {
			logMap.put(channel, LoggerUtil.getMinuteLogger(channel));
		}
		public void initHourLog(String channel) {
			logMap.put(channel, LoggerUtil.getHourLogger(channel));
		}
		public void initDailyLog(String channel) {
			logMap.put(channel, LoggerUtil.getDayLogger(channel));
		}
		
		public void append(String channel, String message) {
			logMap.get(channel).info(message);
		}
	}
	
	private static Log _logInstance = new Log();
	
	public static void initMinuteLog(String channel) {
		_logInstance.initMinuteLog(channel);
	}
	public static void initHourLog(String channel) {
		_logInstance.initHourLog(channel);
	}
	public static void initDailyLog(String channel) {
		_logInstance.initDailyLog(channel);
	}
	
	public static void append(String channel, String message) {
		_logInstance.append(channel, message);
	}
	
	

}
