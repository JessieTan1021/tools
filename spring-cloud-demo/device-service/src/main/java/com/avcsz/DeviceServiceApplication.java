package com.avcsz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**  
* service gateway
* 
* @author lping
* @date 2018年1月12日
*/
@EnableEurekaClient
@SpringBootApplication
@RestController
public class DeviceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeviceServiceApplication.class, args);
	}
	@RequestMapping("/name")
	public String name() {
		return "device-service";
	}
	

}
