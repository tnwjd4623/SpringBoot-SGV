package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mapper.MovieMapper;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
@Controller
public class HelloController {
	
	@Resource(name="mapper.MovieMapper")
	MovieMapper movieMapper;
	
	@RequestMapping("/")
	public String dbTest() throws Exception {
		System.out.println(movieMapper.MovieCount());
		return "hello";
	}
}
