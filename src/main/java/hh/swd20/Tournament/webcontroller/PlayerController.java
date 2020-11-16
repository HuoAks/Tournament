package hh.swd20.Tournament.webcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.Tournament.domain.Player;
import hh.swd20.Tournament.domain.PlayerRepository;


@Controller
public class PlayerController {
	
	



		
		@Autowired
		public PlayerRepository pRepository;
		
		
//		// Front page
//		@RequestMapping(value = "/index", method = RequestMethod.GET) 
//			public String getIndex(Model model) {
//			return "index";
//			
//		}
//		// Login
//		@RequestMapping(value="/login")
//		    public String login() {	
//		    return "login";
//		    }
		
				//List all players
				@RequestMapping(value = "/playerlist", method = RequestMethod.GET)
				public String getPlayers(Model model) {
					model.addAttribute("players", pRepository.findAll());
					
					return "playerlist";
		
		}
				//Add a new player
				@RequestMapping(value = "/addplayer")
				public String addPlayer(Model model) {
					model.addAttribute("players", new Player());
					
					return "addplayer";
		}
				//Save a player
				@RequestMapping(value = "/saveplayer", method = RequestMethod.POST)
				public String savePlayer(Player player) {
					pRepository.save(player);
					
					return "redirect:playerlist";
		}
				// Remove a player
				@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
				public String deletePlayer(@PathVariable("id") Long playerId, Model model) {
					pRepository.deleteById(playerId);
					
					return "redirect:../playerlist";
				}
				// Edit a player
				@RequestMapping("/modify/{id}")
				public String editPlayer(@PathVariable("id") Long playerId, Model model) {
				model.addAttribute("team", pRepository.findById(playerId));
			
				return "editplayer";
				}
				
	

}
