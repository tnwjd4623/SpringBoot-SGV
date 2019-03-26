package mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.Cinema;
import com.example.demo.Movie;

@Repository("mapper.CinemaMapper")
public interface CinemaMapper {
	public List<Cinema> CinemaList() throws Exception;
	
}
