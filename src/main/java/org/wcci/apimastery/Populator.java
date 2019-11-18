package org.wcci.apimastery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.apimastery.models.Team;
import org.wcci.apimastery.models.Player;
import org.wcci.apimastery.models.Gender;
import org.wcci.apimastery.services.PlayerService;
import org.wcci.apimastery.services.TeamService;

@Component
public class Populator implements CommandLineRunner{
	
	@Autowired
	private TeamService teamService;
	@Autowired
	private PlayerService playerService;
	
	@Override
	public void run(String... args) throws Exception {
		
		// Winning 2016 Olympic Badminton Teams
		
		Team teamChinaMale = new Team("China-Male", Gender.MALE);	
		Team teamMalaysiaMale = new Team("Malaysia-Male", Gender.MALE);
		Team teamUkMale = new Team("UK-Male", Gender.MALE);	

		Team teamJapanFemale = new Team("Japan-Female", Gender.FEMALE);
		Team teamDenmarkFemale = new Team("Denmark-Female", Gender.FEMALE);		
		Team teamSKoreaFemale = new Team("SKorea-Female", Gender.FEMALE);
		
		Team teamIndonesiaMixed = new Team("Indonesia-Mixed", Gender.MIXED);
		Team teamMalaysiaMixed = new Team("Malaysia-Mixed", Gender.MIXED);
		Team teamChinaMixed = new Team("China-Mixed", Gender.MIXED);

		teamService.saveTeam(teamChinaMale);
		teamService.saveTeam(teamMalaysiaMale);
		teamService.saveTeam(teamUkMale);

		teamService.saveTeam(teamJapanFemale);
		teamService.saveTeam(teamDenmarkFemale);
		teamService.saveTeam(teamSKoreaFemale);
		
		teamService.saveTeam(teamIndonesiaMixed);
		teamService.saveTeam(teamMalaysiaMixed);
		teamService.saveTeam(teamChinaMixed);
		
		
		
		
	}
	
}
		
		