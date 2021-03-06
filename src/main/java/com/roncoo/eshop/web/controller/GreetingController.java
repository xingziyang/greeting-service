package com.roncoo.eshop.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roncoo.eshop.service.SayHelloService;

@EnableAutoConfiguration
@RestController
@RefreshScope
public class GreetingController {

//	@Autowired
//	private GreetingService greetingService;
	
	@Autowired
	private SayHelloService sayHelloService;
	
	@Value("${server.port}")
	private String port;
	
	@Value("${defaultName}")
	private String defaultName;
	@Value("${foo}")
	private String foo;
	
	@RequestMapping("/greeting")
	public String greeting(@RequestParam String name) {
		String result = null;
		
		if(name != null && !"".equals(name)) { 
			result = sayHelloService.sayHello(name);
		} else {
			result = "hello, this is default name: " + defaultName + ", foo:" + foo;
		}
		
		result += " , through greeting service from port: " + port;
		
		return result;
	}
	
}
