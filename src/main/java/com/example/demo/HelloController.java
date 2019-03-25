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
	
	@RequestMapping("/insert_movie")
	public String movieInsert(HttpServletRequest request) throws Exception {
		Movie movie = new Movie(request.getParameter("title"));
		movie.setM_director(request.getParameter("director"));
		movie.setM_img(request.getParameter("img"));
		movie.setM_pubDate(request.getParameter("pubDate"));
		movie.setM_rating(request.getParameter("rating"));
		
		
		movieMapper.MovieInsert(movie);
		return "redirect:/hello";
	}
}
