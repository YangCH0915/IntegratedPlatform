package com.xinruiyun.platform.exception;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xinruiyun.platform.utils.Log;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


public class GlobalExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o,
			Exception e) {
		Log.i(this.getClass(),"全局异常捕获："+getExceptionAllinformation(e));
		return null;
	}

	public static String getExceptionAllinformation(Exception ex) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();  
		PrintStream pout = new PrintStream(out);
		ex.printStackTrace(pout);  
		String ret = new String(out.toByteArray());  
		pout.close();  
		try {  
			out.close();  
		} catch (Exception e) {  
		}  
		return ret;  
	}  
}
