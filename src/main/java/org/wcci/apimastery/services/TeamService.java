package org.wcci.apimastery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcci.apimastery.exceptions.TeamNotFoundException;
import org.wcci.apimastery.models.Team;
import org.wcci.apimastery.repositories.TeamRepository;

@Service
public class TeamService {
	
	@Autowired
	TeamRepository teamRepo;
	
	public Team saveTeam(Team team) {
		return teamRepo.save(team);
	}

	public Team fetchTeam(Long id) {
		Optional<Team> retrievedTeamOptional = teamRepo.findById(id);
		if (!retrievedTeamOptional.isPresent()) {
			throw new TeamNotFoundException("Team not found.");
		}
		return retrievedTeamOptional.get();
	}
	
	public List<Team> fetchAllTeams() {
		return (List<Team>) teamRepo.findAll();
	}

	public void removeTeam(Team team) {
		teamRepo.delete(team);
		
	}
}
