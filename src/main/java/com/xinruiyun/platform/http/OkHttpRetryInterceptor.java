package com.xinruiyun.platform.http;

import java.io.IOException;
import java.io.InterruptedIOException;
import com.xinruiyun.platform.utils.Log;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpRetryInterceptor  implements Interceptor {

	public int executionCount;//最大重试次数
	private long retryInterval;//重试的间隔
	
	public OkHttpRetryInterceptor(Builder builder) {
		this.executionCount = builder.executionCount;
		this.retryInterval = builder.retryInterval;
	}

	@SuppressWarnings("resource")
	@Override
	public Response intercept(Chain chain) throws IOException {
		Request request = chain.request();
		Response response = doRequest(chain, request);
		int retryNum = 0;
		while ((response == null || !response.isSuccessful()) && retryNum <= executionCount) {
			Log.i(this.getClass(),"intercept Request is not successful - "+retryNum);
			final long nextInterval = getRetryInterval();
			try {
				Log.i(this.getClass(),"Wait for {}"+nextInterval);
				Thread.sleep(nextInterval);
			} catch (final InterruptedException e) {
				Thread.currentThread().interrupt();
				throw new InterruptedIOException();
			}
			retryNum++;
			response = doRequest(chain, request);
		}
		return response;
	}

	private Response doRequest(Chain chain, Request request) {
		Response response = null;
		try {
			response = chain.proceed(request);
		} catch (Exception e) {
		}
		return response;
	}

	/**
	 * retry间隔时间
	 */
	public long getRetryInterval() {
		return this.retryInterval;
	}

	public static final class Builder {
		private int executionCount;
		private long retryInterval;
		
		public Builder() {
			executionCount = 3;
			retryInterval = 5000;
		}

		public Builder executionCount(int executionCount){
			this.executionCount =executionCount;
			return this;
		}

		public Builder retryInterval(long retryInterval){
			this.retryInterval =retryInterval;
			return this;
		}
		
		public OkHttpRetryInterceptor build() {
			return new OkHttpRetryInterceptor(this);
		}
	}
}
