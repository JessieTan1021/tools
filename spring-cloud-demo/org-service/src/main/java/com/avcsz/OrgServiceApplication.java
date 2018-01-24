package com.avcsz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

/**  
* service gateway
* 
* @author lping
* @date 2018年1月12日
*/
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@RestController
public class OrgServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrgServiceApplication.class, args);
	}


}
