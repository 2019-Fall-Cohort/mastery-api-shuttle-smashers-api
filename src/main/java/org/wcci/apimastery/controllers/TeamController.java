package org.wcci.apimastery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.models.Team;
import org.wcci.apimastery.services.TeamService;



@CrossOrigin
@RestController
@RequestMapping("/api/teams")
public class TeamController {
	
	@Autowired
	private TeamService teamservice;

	@GetMapping("")
	public List<Team>getTeams() {
		return teamservice.fetchAllTeams(); 
	}
	
	@GetMapping("/{id}")
	public Team getSingleTeam(@PathVariable Long id) {
		return teamservice.fetchTeam(id);
	}
	
	@PostMapping("/add-team")
	public Team addTeam(@RequestBody Team team) {
		return teamservice.saveTeam(team);
	}
	
	@DeleteMapping("/{id}/remove-team")
	public void removeTeam(@PathVariable Long id) {
		Team team = teamservice.fetchTeam(id);
		teamservice.removeTeam(team);
	}
		
	
	
}
