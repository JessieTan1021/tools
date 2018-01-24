package com.avcsz;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**  
* 
* 
* @author lping
* @date 2018年1月19日
*/
@RestController
@RequestMapping("/device")
public class DeviceController {
	
	@GetMapping("/{id}")
	public Device getDevice(@PathVariable("id") String id) {
		return new Device(id, "device:" + id);
	}
	
	@GetMapping("")
	public List<Device> queryDevice(@RequestParam("type") String type) {
		
		if (type.equals("IN")) {
			return Arrays.asList(new Device("11", "device"), new Device("12", "device"));
		} else {
			return Arrays.asList(new Device("21", "device"), new Device("22", "device"));
		}
		
	}
	
	@PostMapping("/{id}")
	public Device updateDevice(@PathVariable("id") String id, @RequestBody Device device) {
		return device;
	}
	
}
