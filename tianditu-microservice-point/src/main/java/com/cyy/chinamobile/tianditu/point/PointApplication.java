package com.cyy.chinamobile.tianditu.point;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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
