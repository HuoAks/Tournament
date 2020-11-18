package hh.swd20.Tournament.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository <Player, Long> {
	
	public List<Player> findByFirstname(String firstname);
	
}
