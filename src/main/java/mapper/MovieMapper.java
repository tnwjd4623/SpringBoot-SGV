package mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.Movie;
import com.example.demo.Schedule;
import com.example.demo.Booking;

@Repository("mapper.MovieMapper")
public interface MovieMapper {
	//Movie count
	public int MovieCount() throws Exception;
	
	//Insert Movie
	public void MovieInsert(Movie movie) throws Exception;
	
	//Movie list
	public List<Movie> MovieList() throws Exception;
	
	//Delete Movie
	public void MovieDelete() throws Exception;
	
	//Movie number
	public int MovieNumber(Movie movie) throws Exception;
	
	//Insert schedule
	public void ScheduleInsert(Schedule schedule) throws Exception;
	
	//Insert Booking
	public void Booking(Booking booking) throws Exception;
	
	//scheduleList
	public List<Schedule> scheduleList(int m_no) throws Exception;
	
}
