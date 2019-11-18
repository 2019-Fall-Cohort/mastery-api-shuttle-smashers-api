package org.wcci.apimastery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.models.Player;
import org.wcci.apimastery.models.Team;
import org.wcci.apimastery.services.PlayerService;
import org.wcci.apimastery.services.TeamService;



@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/teams")
public class TeamController {
	
	@Autowired
	private TeamService teamservice;
	
	@Autowired
	private PlayerService playerservice; 
	

	@GetMapping("")
	public List<Team>getTeams() {
		return teamservice.fetchAllTeams(); 
	}
	
	@GetMapping("/{id}")
	public Team getSingleTeam(@PathVariable Long id) {
		return teamservice.fetchTeam(id);
	}
	
	@PatchMapping("/{id}/add-player")
	public Team addPlayer(@PathVariable Long id, @RequestBody Player player) {
		Team team = teamservice.fetchTeam(id);
		Player playerToAdd = new Player(player.getName(), player.getCountry(), player.gender, team);
		playerservice.savePlayer(playerToAdd);
		return teamservice.saveTeam(team);
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
