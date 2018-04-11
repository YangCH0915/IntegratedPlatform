package com.xinruiyun.platform.utils;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class Log {

	private static Logger getLogger(@SuppressWarnings("rawtypes") Class c){
		return (Logger) LoggerFactory.getLogger(c);
	}
	
	public static void i(@SuppressWarnings("rawtypes") Class c,String msg){
		getLogger(c).info(msg);
	}
	
	public static void d(@SuppressWarnings("rawtypes") Class c,String msg){
		getLogger(c).debug(msg);
	}
	
	public static void e(@SuppressWarnings("rawtypes") Class c,String msg){
		getLogger(c).error(msg);
	}
	
}
