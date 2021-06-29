package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/hello-mvc")
	public String sayHello() {
		System.out.println("HelloController.invoked... ");
		return "/WEB-INF/pages/hello.jsp"; 
	}
}
