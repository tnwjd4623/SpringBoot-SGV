package mapper;

import org.springframework.stereotype.Repository;

@Repository("mapper.MovieMapper")
public interface MovieMapper {
	public int MovieCount() throws Exception;
}
