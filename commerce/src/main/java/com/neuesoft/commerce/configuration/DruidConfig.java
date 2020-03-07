package com.neuesoft.commerce.configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
public class DruidConfig {
	
	
	@ConfigurationProperties(prefix = "spring.datasource")
	@Bean
	public DataSource druid(){
		return new DruidDataSource();
	}
	

	@Bean
	public ServletRegistrationBean statViewServlet(){
		ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
		Map<String, String> initParams = new HashMap<String, String>();
		initParams.put("loginUsername", "laodishu");
		initParams.put("loginPassword", "123");
		initParams.put("allow","");
		bean.setInitParameters(initParams);
		return bean;
	}
	
	
	@Bean
	public FilterRegistrationBean webStatFilter(){
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setFilter(new WebStatFilter());
		Map<String, String> initParams = new HashMap<String, String>();
		initParams.put("exclusion", "/druid/*,*.js,*.css,*.jpg,*.png");
		bean.setUrlPatterns(Arrays.asList("/*"));
		bean.setInitParameters(initParams);
		return bean;
	}
	
}
