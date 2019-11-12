package org.wcci.apimastery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.albums.entities.Artist;

@RestController 
@RequestMapping("/api/players")
public class PlayerController {

	@Autowired 
	private PlayerService playerService; 

	@GetMapping("")
	public Iterable<Player> getPlayers() {
		return playerService.fetchAllPlayers();
	}

	@GetMapping("/{id}")
	public Player getSinglePlayer(@PathVariable Long id) {
		return playerService.fetchPlayer(id);
	}
	
	@PostMapping("/{name}")
	public Player addPlayer(@PathVariable String name) {
		Player player = new Player(name);
		return playerService.savePlayer(player);
	}
	
	@DeleteMapping("/{id}/remove")
	public void removePlayer(@PathVariable Long id) {
		Player artist = playerService.findPlayer(id);
		playerService.removePlayer(player);
	}
	
	@PatchMapping("/{id}/{name}")
	public Player editPlayer(@PathVariable Long id, @PathVariable String name) {
		Player artist = playerService.findArtistById(id);
		return playerService.updatePlayerName(artist, name);
	}
	
	@PostMapping("/{id}/{name}/{RecordLabel}/{Hometown}")
	public Artist editAll(@PathVariable Long id, @PathVariable String name, @PathVariable String RecordLabel,
			@PathVariable String Hometown) {
		Artist artist = artistStorage.findArtistById(id);
		return artistStorage.updateArtistAll(artist, name, RecordLabel, Hometown);
	}

	@PostMapping("/{id}/{name}/{RecordLabel}/{Hometown}")
	public Player editAll(@PathVariable Long id, @PathVariable String name, @PathVariable String RecordLabel,
			@PathVariable String Hometown) {
		Player artist = playerService.fetchPlayer(id);
		return playerService.updatePlayerAll(artist, name, RecordLabel, Hometown);
	}
}
	
	
	
	
	
	
