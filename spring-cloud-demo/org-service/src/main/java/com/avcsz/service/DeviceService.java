package com.avcsz.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * 
 * @author lping
 * @date 2018年1月22日
 */
@FeignClient("device-service")
public interface DeviceService {


	@GetMapping("/device/{id}")
	Device getDevice(@PathVariable("id") String id);

	@GetMapping("/device")
	public List<Device> queryDevice(@RequestParam("type") String type);

	@PostMapping("/device/{id}")
	public Device updateDevice(@PathVariable("id") String id, Device device);
}
