package com.cyy.chinamobile.tianditu.point;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.cyy.chinamobile.tianditu.point.dao.mapper")
@EnableEncryptableProperties
@EnableCircuitBreaker
public class PointApplication {

	public static void main(String[] args) {
		SpringApplication.run(PointApplication.class, args);

	}

}
