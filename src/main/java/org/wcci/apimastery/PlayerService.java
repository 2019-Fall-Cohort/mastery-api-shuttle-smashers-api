package org.wcci.apimastery;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public void deletePlayer(Player player) {
		playerRepo.delete(player);
	}

	public void removePlayer(Player player) {
		playerRepo.delete(player);
	}
	
}
