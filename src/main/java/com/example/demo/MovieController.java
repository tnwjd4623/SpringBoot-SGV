package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.NaverMovie;

@Controller
public class MovieController {
	@Autowired
	private NaverMovie naverMovie;
	
	@RequestMapping("/search")
	public ModelAndView movieList(@RequestParam(required=false)String text) {
		ModelAndView mav = new ModelAndView();
		
		if(text != null) {
			mav.addObject("movieList", naverMovie.searchMovie(text, 10));
		}
		mav.setViewName("/movieList");
		
		return mav;
	}
	
}
