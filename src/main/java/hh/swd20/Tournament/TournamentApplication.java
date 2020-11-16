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
	public CommandLineRunner demo(TeamRepository teamRepository, UserRepository uRepository, PlayerRepository prepository) {
		return (args) -> {
			
			// Creates demousers akseli/akseli & user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "User@demouser.db");
			User user2 = new User("akseli", "$2a$10$W2UBzgej4CnLGB8cUEl0/OuxhR.ij1/QDgcc1ZZiWUCXlSdGgmwM.", "ADMIN", "akseli@demouser.db");
			uRepository.save(user1);
			uRepository.save(user2);
			
			log.info("Saving some demo teams");
			
			Team team1 = new Team("The Sankarit", "Joensuu", "Marko Markonen");
			Team team2 = new Team("Tigers", "Tikkala", "Jichael Mordan");
			Team team3 = new Team("Lakers", "LA", "Frank Vogel");
			teamRepository.save(team1);
			teamRepository.save(team2);
			teamRepository.save(team3);
			
			log.info("List all new teams");
			for (Team team : teamRepository.findAll()) {
				log.info(team.toString());
				
			log.info("Saving some demo players");
			
			Player player1 = new Player("Lebron", "James", 23, 1984, team3);
			Player player2 = new Player("Hirmuinen", "Rölli", 00, 1970, team2);
			prepository.save(player1);
			prepository.save(player2);
			
			log.info("List the demo players");
			for (Player player : prepository.findAll()) {
				log.info(player.toString());
				}
			}
		};
	}
}
