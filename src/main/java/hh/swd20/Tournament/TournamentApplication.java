package hh.swd20.Tournament;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Tournament.domain.User;
import hh.swd20.Tournament.domain.UserRepository;
import hh.swd20.Tournament.domain.Team;
import hh.swd20.Tournament.domain.TeamRepository;
import hh.swd20.Tournament.domain.Player;
import hh.swd20.Tournament.domain.PlayerRepository;

@SpringBootApplication
public class TournamentApplication {
	
	private static final Logger log = LoggerFactory.getLogger(TournamentApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TournamentApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(TeamRepository teamRepository, UserRepository uRepository, PlayerRepository pRepository) {
		return (args) -> {
			
			log.info("Save some teams");
			Team team1 = new Team("The Sankarit", "Joensuu", "Marko Markonen");
			teamRepository.save(team1); // saving the 1st team
			Team team2 = new Team("Tigers", "Tikkala", "Jichael Mordan");
			teamRepository.save(team2);
			Team team3 = new Team("Lakers", "LA", "Frank Vogel");
			teamRepository.save(team3);
			
			pRepository.save(new Player("Lebron", "James", 23, 1984, team3));	// Saving players with a team
			pRepository.save(new Player("Hirmuinen", "Rölli", 00, 1970, team2)); 
			
			// Creates demousers akseli/akseli & user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "User@demouser.db");
			User user2 = new User("akseli", "$2a$10$W2UBzgej4CnLGB8cUEl0/OuxhR.ij1/QDgcc1ZZiWUCXlSdGgmwM.", "ADMIN", "akseli@demouser.db");
			uRepository.save(user1);
			uRepository.save(user2);
			
			log.info("fetch all teams");
			for (Team team : teamRepository.findAll()) {
				log.info(team.toString());
				
			log.info("fetch all players");
			for (Player player : pRepository.findAll()) {
				log.info(player.toString());
				
		}
			}
		};
	}
}
