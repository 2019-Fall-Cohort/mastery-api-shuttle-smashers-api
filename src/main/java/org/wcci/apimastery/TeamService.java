package org.wcci.apimastery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}