package com.avcsz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avcsz.service.Device;
import com.avcsz.service.DeviceService;

/**  
* 
* 
* @author lping
* @date 2018年1月22日
*/
@RestController
public class OrgController {
	
	@Autowired
	private DeviceService deviceService;
	
	@RequestMapping("/name")
	public String name() {
		return "org-service";
	}
	
	@GetMapping("/device/{id}")
	public Device getDevice(@PathVariable("id") String id) {
		return deviceService.getDevice(id);
	}
	
	@GetMapping("/device")
	public List<Device> queryDevice(@RequestParam("type") String type) {
		return deviceService.queryDevice(type);
	}
	
	@PostMapping("/device/{id}")
	public Device updateDevice(@PathVariable("id") String id, @RequestBody Device device) {
		return deviceService.updateDevice(id, device);
	}
	
}
