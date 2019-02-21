package com.cyy.chinamobile.tianditu.microservice.util.log;

public class LogIdThreadLocal {

	// 分布式ID生成类
	private static LogIdWorker logIdWorker;

	private static final ThreadLocal<Long> LOG_THREAD_LOCAL = new ThreadLocal<Long>() {
		@Override
		protected synchronized Long initialValue() {
			if (logIdWorker != null) {
				return logIdWorker.nextId();
			} else {
				return 1000000000000000L;
			}
		}
	};

	public static Long getLogId() {
		return LOG_THREAD_LOCAL.get();
	}

	public static void setLogIdWorker(LogIdWorker logIdWorker) {
		LogIdThreadLocal.logIdWorker = logIdWorker;
	}

}
