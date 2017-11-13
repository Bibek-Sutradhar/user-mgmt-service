package com.cts.user_mgmt_service;

import com.cts.user_mgmt_service.service.UserMgmtService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.cts.user_mgmt_service.Repository","com.cts.user_mgmt_service.resource",
										"com.cts.user_mgmt_service.service"})
@SpringBootApplication
public class UserMgmtServiceApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext =  SpringApplication.run(UserMgmtServiceApplication.class, args);

		UserMgmtService userMgmtService = applicationContext.getBean("userMgmtService", UserMgmtService.class);
	}
}
