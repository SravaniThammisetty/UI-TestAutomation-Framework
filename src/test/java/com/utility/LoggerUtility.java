package com.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {
	
	/*
	 * In this class we will be creating Global config for setup for logger
	 * This class will be used in all of our classes or all of our components that we want to log
	 */
	private LoggerUtility() {
		// In single ton class, the constructor is always private
	}
		
	public static Logger getLogger(Class<?> clazz) {
		Logger logger = null;
		if(logger == null) {
			logger = LogManager.getLogger(clazz);
		}
		return logger;
	}
	
}
