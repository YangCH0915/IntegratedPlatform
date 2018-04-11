package com.xinruiyun.platform.exception;

/**
 * 秒杀相关业务异常
 * 
 * @author yan
 */
public class ProductException extends RuntimeException {

	public ProductException(String message) {
		super(message);
	}

	public ProductException(String message, Throwable cause) {
		super(message, cause);
	}

}
