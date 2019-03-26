package com.example.demo;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.NaverMovie;

import mapper.CinemaMapper;
import mapper.MovieMapper;

@Controller
public class MovieController {
	@Autowired
	private NaverMovie naverMovie;
	
	//search 
	@RequestMapping("/search")
	public ModelAndView movieList(@RequestParam(required=false)String text) {
		ModelAndView mav = new ModelAndView();
		
		if(text != null) {
			mav.addObject("movieList", naverMovie.searchMovie(text, 10));
		}
		mav.setViewName("/movieList");
		
		return mav;
	}
	
	@Resource(name="mapper.MovieMapper")
	MovieMapper movieMapper;
	
	@Resource(name="mapper.CinemaMapper")
	CinemaMapper cinemaMapper;
	
	@RequestMapping("/insert_movie")
	public String movieInsert(HttpServletRequest request) throws Exception {
		Movie movie = new Movie();
		movie.setM_title(request.getParameter("title"));
		movie.setM_director(request.getParameter("director"));
		movie.setM_img(request.getParameter("img"));
		movie.setM_pubDate(request.getParameter("pubDate"));
		movie.setM_rating(request.getParameter("rating"));
		
		movieMapper.MovieInsert(movie);
		return "redirect:/home";
	}
	
	@RequestMapping("/home")
	public String home() throws Exception {
		return "home";
	}
	
	
	@RequestMapping("/addSchedule")
	public ModelAndView addSchedule() throws Exception {
		List<Movie> m_list = movieMapper.MovieList();
		List<Cinema> c_list = cinemaMapper.CinemaList();
		
		
		ModelAndView schedule = new ModelAndView();
		schedule.addObject("movieList", m_list);
		schedule.addObject("cinemaList", c_list);
		schedule.setViewName("schedule");
		
		return schedule;
	}
	
	@RequestMapping("/insert_schedule")
	public String insertSchedule(HttpServletRequest request) throws Exception {
		Schedule schedule = new Schedule();
		
		System.out.println(Integer.parseInt(request.getParameter("cinema")));
		System.out.println(request.getParameter("date"));
		System.out.println(request.getParameter("s_time"));
		System.out.println(request.getParameter("e_time"));
		
		
		schedule.setM_no(Integer.parseInt(request.getParameter("movie")));
		schedule.setC_no(Integer.parseInt(request.getParameter("cinema")));
		schedule.setDate(request.getParameter("date"));
		schedule.setS_time(request.getParameter("s_time"));
		schedule.setE_time(request.getParameter("e_time"));
		
		movieMapper.ScheduleInsert(schedule);
		return "redirect:/home";
	}
	
	@RequestMapping("/cinema")
	public ModelAndView cinemaList() throws Exception {
		List<Cinema> list = cinemaMapper.CinemaList();
		ModelAndView cinemaList = new ModelAndView();
		cinemaList.addObject("cinemaList", list);
		
		cinemaList.setViewName("/insert_detail");
		return cinemaList;
	}
	
}
