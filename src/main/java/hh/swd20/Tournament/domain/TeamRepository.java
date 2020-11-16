package hh.swd20.Tournament.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface TeamRepository extends CrudRepository <Team, Long> {
	
	public List<Team> findByName(String name);
	
}
