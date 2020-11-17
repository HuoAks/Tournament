package hh.swd20.Tournament;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.Tournament.domain.TeamRepository;
import hh.swd20.Tournament.domain.Team;


@ExtendWith(SpringExtension.class)
@DataJpaTest



public class TeamRepositoryTest {
	
	@Autowired
	private TeamRepository tRepository;
	
	@Test
	public void findByNameReturnsTeam() {
		
        List<Team> teams = tRepository.findByName("Tigers");
        
        assertThat(teams).hasSize(1);


	}
	
    @Test
    public void createNewTeam() {
    	Team team = new Team("Kataja", "Joensuu", "Petri Virtanen");
    	tRepository.save(team);
    	assertThat(team.getTeamid()).isNotNull();
    }  
    
	@Test
	public void deleteTeams() {

		tRepository.deleteAll();
		
		List<Team> teams = tRepository.findByName("The Sankarit");
		
		assertThat(teams).hasSize(0);
		
	
	}
}
