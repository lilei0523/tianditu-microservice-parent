package com.iot.chinamobile.demo.microservice.util.log;

/**
 * 
 * @ClassName: LogIdThreadLocal 
 * @Description: 生成唯一日志流水号
 * @author: 张力
 * @date: 2017年9月22日 下午4:59:26
 */
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
