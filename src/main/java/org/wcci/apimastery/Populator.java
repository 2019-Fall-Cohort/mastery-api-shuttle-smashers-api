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
		
		String chinaMale1;
		
		Team team1 = new Team(chinaMale1, MALE);
		
		
	}
	
}
		
		