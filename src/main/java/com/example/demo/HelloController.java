package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mapper.MovieMapper;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
@Controller
public class HelloController {
	
	@Resource(name="mapper.MovieMapper")
	MovieMapper movieMapper;
	
	@RequestMapping("/hello")
	public String dbTest() throws Exception {
		System.out.println(movieMapper.MovieCount());
		return "hello";
	}
	
	
}
