package hh.swd20.Tournament.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;


import hh.swd20.Tournament.domain.Team;
import hh.swd20.Tournament.domain.TeamRepository;


@Controller
public class TeamController {
	
	@Autowired
	public TeamRepository teamRepository;
	
	
	// Front page
	@RequestMapping(value = "/index", method = RequestMethod.GET) 
		public String getIndex(Model model) {
		return "index";
		
	}
	// Login
	@RequestMapping(value="/login")
	    public String login() {	
	    return "login";
	    }
	
			//List all teams
			@RequestMapping(value = "/teamlist", method = RequestMethod.GET)
			public String getTeams(Model model) {
				model.addAttribute("teams", teamRepository.findAll());
				
				return "teamlist";
	
	}
			//Add a new team
			@RequestMapping(value = "/add")
			public String addTeam(Model model) {
				model.addAttribute("teams", new Team());
				
				return "addteam";
	}
			//Save a team
			@RequestMapping(value = "/save", method = RequestMethod.POST)
			public String saveTeam(Team team) {
				teamRepository.save(team);
				
				return "redirect:teamlist";
	}
			// Delete a team
			@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
			public String deleteTeam(@PathVariable("id") Long teamId, Model model) {
				teamRepository.deleteById(teamId);
				
				return "redirect:../teamlist";
			}
			// Edit a team
			@RequestMapping("/edit/{id}")
			public String editTeam(@PathVariable("id") Long teamId, Model model) {
			model.addAttribute("team", teamRepository.findById(teamId));
		
			return "editteam";
			}
			
}
