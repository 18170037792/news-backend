package com.xiafei.newsbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="com.xiafei.newsbackend.dao")
public class NewsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsBackendApplication.class, args);
	}
}
