package hh.swd20.Tournament;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import hh.swd20.Tournament.domain.Player;
import hh.swd20.Tournament.domain.PlayerRepository;


@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest

public class PlayerRepositoryTest {
	
	@Autowired
	private PlayerRepository pRepository;
	
	@Test
	public void findByFirstnameReturnsPlayer() {
		
        List<Player> players = pRepository.findByFirstname("Lebron");
        
        assertThat(players).hasSize(1);
        assertThat(players.get(0).getLastname()).isEqualTo("James");
		
	}
    @Test
    public void createNewPlayer() {
    	Player player = new Player("Test", "Testerman", 20, 20, null);
    	pRepository.save(player);
    	assertThat(player.getId()).isNotNull();
    }  
	@Test 
	public void deletePlayers() {

		pRepository.deleteAll();
		
		List<Player> players = pRepository.findByFirstname("Hirmuinen");
		
		assertThat(players).hasSize(0);
		
	
	}

}
