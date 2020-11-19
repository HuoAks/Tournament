package hh.swd20.Tournament.webcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.Tournament.domain.Player;
import hh.swd20.Tournament.domain.PlayerRepository;
import hh.swd20.Tournament.domain.Team;
import hh.swd20.Tournament.domain.TeamRepository;



@Controller
public class PlayerController {
	
	



		
		@Autowired
		private PlayerRepository pRepository;
		
		@Autowired
		private TeamRepository tRepository;
		
		
				//List all players
				@RequestMapping(value = "/playerlist", method = RequestMethod.GET)
				public String getPlayers(Model model) {
					model.addAttribute("players", pRepository.findAll());
					
					return "playerlist";
		
		}
				//Add a new player
				@RequestMapping(value = "/add")
				public String addPlayer(Model model) {
					model.addAttribute("player", new Player());
					model.addAttribute("teams", tRepository.findAll());
					
					return "addplayer";
		}
				//Save a player
				@RequestMapping(value = "/save", method = RequestMethod.POST)
				public String savePlayer(Player player) {
					pRepository.save(player);
					
					return "redirect:playerlist";
		}
				// Remove a player
				@PreAuthorize("hasAuthority('ADMIN')")
				@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
				public String deletePlayer(@PathVariable("id") Long playerId, Model model) {
					pRepository.deleteById(playerId);
					
					return "redirect:../playerlist";
				}
				// Edit a player
				@RequestMapping(value = "/modify/{id}")
				public String editPlayer(@PathVariable("id") Long playerId, Model model) {
				model.addAttribute("player", pRepository.findById(playerId));
				model.addAttribute("teams", tRepository.findAll());
			
				return "editplayer";
				}
				// RESTful service to get all players
				
			    @RequestMapping(value="/players", method = RequestMethod.GET)
			    public @ResponseBody List<Player> playerListRest() {	
			        return (List<Player>) pRepository.findAll();
			    }    

				// RESTful service to get a player by id
				
			    @RequestMapping(value="/players/{id}", method = RequestMethod.GET)
			    public @ResponseBody Optional<Player> findPlayerRest(@PathVariable("id") Long Id) {	
			    	return pRepository.findById(Id);
			    } 	

}		

