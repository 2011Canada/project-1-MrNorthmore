package com.revature.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ErsLogger {
	
	private static Logger ersLogger = LogManager.getLogger("e720");
	
	public static Logger getLogger() {
		return ersLogger;
	}
	
}
