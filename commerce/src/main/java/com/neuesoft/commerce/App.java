package com.neuesoft.commerce;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@MapperScan(value = "com.neuesoft.commerce.mapper") 
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
