package com.cyy.chinamobile.tianditu.microservice.eureka.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.cyy.chinamobile.tianditu.microservice.util.log.LogIdThreadLocal;
import com.cyy.chinamobile.tianditu.microservice.util.log.LogIdWorker;

@EnableZuulProxy
@SpringBootApplication
@EnableFeignClients
public class ZuulServer implements CommandLineRunner {

	@Value("${spring.cloud.client.ip-address}")
	private String ipAddress;

	@Value("${server.port}")
	private Integer port;

	@Autowired
	private LogIdWorker logIdWorker;

	public static void main(String[] args) {
		SpringApplication.run(ZuulServer.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LogIdThreadLocal.setLogIdWorker(logIdWorker);
	}

	@Bean
	public LogIdWorker getLogIdWorker() {
		//暂用ip地址最后三位作为节点Id
		int workId = Integer.parseInt(ipAddress.substring(ipAddress.lastIndexOf(".")+1));
		return new LogIdWorker(workId);
	}
}
