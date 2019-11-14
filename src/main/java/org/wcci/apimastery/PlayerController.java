package org.wcci.apimastery;

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

@CrossOrigin
@RestController 
@RequestMapping("/api/players")
public class PlayerController {

	@Autowired 
	private PlayerService playerService; 

	@GetMapping("")
	public List<Player> getPlayers() {
		return playerService.fetchAllPlayers();
	}

	@GetMapping("/{id}")
	public Player getSinglePlayer(@PathVariable Long id) {
		return playerService.fetchPlayer(id);
	}
	
	@PostMapping("/add-player")
	public Player addPlayer(@RequestBody Player player) {
		return playerService.savePlayer(player);
	}
	
	@DeleteMapping("/{id}/remove-player")
	public void removePlayer(@PathVariable Long id) {
		Player player = playerService.fetchPlayer(id);
		playerService.removePlayer(player);
	}
	
}
	
	
	
	
	
	
