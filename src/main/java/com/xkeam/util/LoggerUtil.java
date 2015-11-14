package com.xkeam.util;

import java.io.File;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

@SuppressWarnings("deprecation")
public class LoggerUtil {
	private static final String folder_logs = "./logs";

	public static Logger getLogger(String loggerName, String outputFile) {
		if (Logger.exists(loggerName) != null) {
			return Logger.getLogger(loggerName);
		}

		try {

			String folder = folder_logs + "/" + outputFile;
			folder = folder.replaceAll("[^/]+$", "");
			folder = folder.substring(0, folder.length() - 1);
			File file = new File(folder);
			if (!file.exists())
				file.mkdir();

			Properties properties = new Properties();
			properties.put("log4j.logger." + loggerName, "INFO, " + loggerName);
			properties.put("log4j.additivity." + loggerName, "false");
			properties.put("log4j.appender." + loggerName,
					"org.apache.log4j.FileAppender");
			properties.put("log4j.appender." + loggerName + ".File",
					folder_logs + "/" + outputFile);

			properties.put("log4j.appender." + loggerName + ".ImmediateFlush",
					"true");
			properties.put("log4j.appender." + loggerName + ".layout",
					"org.apache.log4j.PatternLayout");
			properties.put("log4j.appender." + loggerName
					+ ".layout.ConversionPattern",
					"%d{dd MMM yyyy HH:mm:ss.SSS} [%t] %-5p %c  - \n  %m%n \n");

			PropertyConfigurator.configure(properties);
			return LogManager.getLogger(loggerName);
		} catch (Exception e) {
			return Logger.getRootLogger();
		}
	}


	
	public static Logger getDailyLogger(String loggerName) {
		if (Logger.exists(loggerName) != null) {
			return Logger.getLogger(loggerName);
		}

		try {

			Properties properties = new Properties();
			properties.put("log4j.logger." + loggerName, "INFO, " + loggerName);
			properties.put("log4j.additivity." + loggerName, "false");
			properties.put("log4j.appender." + loggerName,
					"org.apache.log4j.DailyRollingFileAppender \n");
			properties.put("log4j.appender." + loggerName + ".File",
					folder_logs + "/" + loggerName + ".txt");
			properties.put("log4j.appender." + loggerName + ".DatePattern",
					"'.'yyyy-MM-dd");
			properties.put("log4j.appender." + loggerName + ".ImmediateFlush",
					"true");
			properties.put("log4j.appender." + loggerName + ".layout",
					"org.apache.log4j.PatternLayout");
			properties.put("log4j.appender." + loggerName
					+ ".layout.ConversionPattern",
					"%d{dd MMM yyyy HH:mm:ss.SSS} [%t] %-5p %c  - \n  %m%n \n");
			
			PropertyConfigurator.configure(properties);
			return LogManager.getLogger(loggerName);
		} catch (Exception e) {
			return Logger.getRootLogger();
		}

	}
	
	public static Logger getDayLogger(String loggerName) {
		if (Logger.exists(loggerName) != null) {
			return Logger.getLogger(loggerName);
		}

		try {

			Properties properties = new Properties();
			properties.put("log4j.logger." + loggerName, "INFO, " + loggerName);
			properties.put("log4j.additivity." + loggerName, "false");
			properties.put("log4j.appender." + loggerName,
					"org.apache.log4j.DailyRollingFileAppender \n");
			properties.put("log4j.appender." + loggerName + ".File",
					folder_logs + "/" + loggerName + ".txt");
			properties.put("log4j.appender." + loggerName + ".DatePattern",
					"'.'yyyy-MM-dd");
			properties.put("log4j.appender." + loggerName + ".ImmediateFlush",
					"true");
			properties.put("log4j.appender." + loggerName + ".layout",
					"org.apache.log4j.PatternLayout");
			properties.put("log4j.appender." + loggerName
					+ ".layout.ConversionPattern", "%m");
			
			PropertyConfigurator.configure(properties);
			return LogManager.getLogger(loggerName);
		} catch (Exception e) {
			return Logger.getRootLogger();
		}

	}
	
	public static Logger getHourLogger(String loggerName) {
		if (Logger.exists(loggerName) != null) {
			return Logger.getLogger(loggerName);
		}

		try {

			Properties properties = new Properties();
			properties.put("log4j.logger." + loggerName, "INFO, " + loggerName);
			properties.put("log4j.additivity." + loggerName, "false");
			properties.put("log4j.appender." + loggerName,
					"org.apache.log4j.DailyRollingFileAppender \n");
			properties.put("log4j.appender." + loggerName + ".File",
					folder_logs + "/" + loggerName + ".txt");
			properties.put("log4j.appender." + loggerName + ".DatePattern",
					"'.'yyyy-MM-dd-HH");
			properties.put("log4j.appender." + loggerName + ".ImmediateFlush",
					"true");
			properties.put("log4j.appender." + loggerName + ".layout",
					"org.apache.log4j.PatternLayout");
			properties.put("log4j.appender." + loggerName
					+ ".layout.ConversionPattern", "%m");
			
			PropertyConfigurator.configure(properties);
			return LogManager.getLogger(loggerName);
		} catch (Exception e) {
			return Logger.getRootLogger();
		}

	}


	public static Logger getMinuteLogger(String loggerName) {
		if (Logger.exists(loggerName) != null) {
			return Logger.getLogger(loggerName);
		}

		try {

			Properties properties = new Properties();
			properties.put("log4j.logger." + loggerName, "INFO, " + loggerName);
			properties.put("log4j.additivity." + loggerName, "false");
			properties.put("log4j.appender." + loggerName,
					"org.apache.log4j.DailyRollingFileAppender \n");
			properties.put("log4j.appender." + loggerName + ".File",
					folder_logs + "/" + loggerName + ".txt");
			properties.put("log4j.appender." + loggerName + ".DatePattern",
					"'.'yyyy-MM-dd-HH-mm");
			properties.put("log4j.appender." + loggerName + ".ImmediateFlush",
					"true");
			properties.put("log4j.appender." + loggerName + ".layout",
					"org.apache.log4j.PatternLayout");
			properties.put("log4j.appender." + loggerName
					+ ".layout.ConversionPattern", "%m");
			
			PropertyConfigurator.configure(properties);
			return LogManager.getLogger(loggerName);
		} catch (Exception e) {
			return Logger.getRootLogger();
		}

	}
	
}
