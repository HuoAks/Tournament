package hh.swd20.Tournament.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

import hh.swd20.Tournament.domain.Team;
import hh.swd20.Tournament.domain.TeamRepository;
import hh.swd20.Tournament.domain.PlayerRepository;



@Controller
public class TeamController {
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private PlayerRepository pRepository;
	
			// Front page
			@RequestMapping(value = "/home", method = RequestMethod.GET) 
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
			@PreAuthorize("hasAuthority('ADMIN')")
			@RequestMapping(value = "/new")
			public String newTeam(Model model) {
				model.addAttribute("teams", new Team());
				
				return "addteam";
	}
			//Save a team
			@PreAuthorize("hasAuthority('ADMIN')")
			@RequestMapping(value = "/create", method = RequestMethod.POST)
			public String saveTeam(Team team) {
				teamRepository.save(team);
				
				return "redirect:teamlist";
	}
			// Delete a team
			@PreAuthorize("hasAuthority('ADMIN')")
			@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
			public String deleteTeam(@PathVariable("id") Long teamId, Model model) {
				teamRepository.deleteById(teamId);
				
				return "redirect:../teamlist";
			}
			// Edit a team
			@PreAuthorize("hasAuthority('ADMIN')")
			@RequestMapping(value = "/edit/{id}")
			public String editTeam(@PathVariable("id") Long teamId, Model model) {
			model.addAttribute("team", teamRepository.findById(teamId));
		
			return "editteam";
			}
			
			// RESTful service to get all teams
		    @RequestMapping(value="/teams", method = RequestMethod.GET)
		    public @ResponseBody List<Team> teamListRest() {	
		        return (List<Team>) teamRepository.findAll();
		    }    

			// RESTful service to get a team by id
		    @RequestMapping(value="/teams/{id}", method = RequestMethod.GET)
		    public @ResponseBody Optional<Team> findTeamRest(@PathVariable("id") Long teamId) {	
		    	return teamRepository.findById(teamId);
		    }
		    

		    
		    //Team lineups
		    @RequestMapping(value="lineup/{id}", method = RequestMethod.GET)
		    public String getLineup() {
		    	
		    	return "lineups";
		    }
	}
