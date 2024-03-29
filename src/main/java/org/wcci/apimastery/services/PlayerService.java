package org.wcci.apimastery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcci.apimastery.exceptions.PlayerNotFoundException;
import org.wcci.apimastery.models.Player;
import org.wcci.apimastery.repositories.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	PlayerRepository playerRepo;
	
	public Player savePlayer(Player player) {
		return playerRepo.save(player);
	}
	
	public Player fetchPlayer(Long id) {
		Optional<Player> retrievedPlayerOptional = playerRepo.findById(id);
		if (!retrievedPlayerOptional.isPresent()) {
			throw new PlayerNotFoundException("Player not found.");
		}
		return retrievedPlayerOptional.get();
	}
	
	public List<Player> fetchAllPlayers() {
		return (List<Player>) playerRepo.findAll();
	}
	
	public void removePlayer(Player player) {
		playerRepo.delete(player);
	}
	
}
