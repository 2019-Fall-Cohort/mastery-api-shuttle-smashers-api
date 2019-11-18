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
		
		Team teamChinaMale = new Team("China-Male Doubles", "https://cdn.britannica.com/90/7490-004-415899A0/Flag-China.jpg", 
				Gender.MALE);	
		Team teamMalaysiaMale = new Team("Malaysia-Male Doubles", "https://www.malaysia-traveller.com/images/xflag-of-malaya.jpg.pagespeed.ic.ea2dJAnceG.jpg",
				Gender.MALE);
		Team teamUkMale = new Team("UK-Male Doubles", "https://www.united-states-flag.com/media/catalog/product/cache/2/image/9df78eab33525d08d6e5fb8d27136e95/g/r/greatbritain-nylon.jpg", 
				Gender.MALE);	

		Team teamJapanFemale = new Team("Japan-Female Doubles", "https://cdn.bannerbuzz.com/media/catalog/product/resize/560/j/a/japan-flag.jpg",
				Gender.FEMALE);
		Team teamDenmarkFemale = new Team("Denmark-Female Doubles", "https://images-na.ssl-images-amazon.com/images/I/51pW7YkWFCL._SX425_.jpg",
				Gender.FEMALE);		
		Team teamSKoreaFemale = new Team("SKorea-Female Doubles", "https://images.homedepot-static.com/productImages/798cfc69-a420-4360-9aab-86f446b6dc36/svn/anley-house-flags-a-flag-southkorea-64_1000.jpg", 
				Gender.FEMALE);
		
		Team teamIndonesiaMixed = new Team("Indonesia-Mixed Doubles", "https://img5.goodfon.com/wallpaper/nbig/9/d9/indonesia-flag-of-indonesia-indonesia-flag-flag-country.jpg",
				Gender.MIXED);
		Team teamMalaysiaMixed = new Team("Malaysia-Mixed Doubles", "https://www.malaysia-traveller.com/images/xflag-of-malaya.jpg.pagespeed.ic.ea2dJAnceG.jpg",
				Gender.MIXED);
		Team teamChinaMixed = new Team("China-Mixed Doubles", "https://cdn.britannica.com/90/7490-004-415899A0/Flag-China.jpg",
				Gender.MIXED);

		teamService.saveTeam(teamChinaMale);
		teamService.saveTeam(teamMalaysiaMale);
		teamService.saveTeam(teamUkMale);

		teamService.saveTeam(teamJapanFemale);
		teamService.saveTeam(teamDenmarkFemale);
		teamService.saveTeam(teamSKoreaFemale);
		
		teamService.saveTeam(teamIndonesiaMixed);
		teamService.saveTeam(teamMalaysiaMixed);
		teamService.saveTeam(teamChinaMixed);
		
		// Winning 2016 Olympic Badminton Players
		
		Player player1 = new Player("Zhang Nan", "China", Gender.MALE, 
				teamChinaMale);
		Player player2 = new Player("Fu Haifeng", "China", Gender.MALE, 
				teamChinaMale);
		Player player3 = new Player("Goh V Shem", "Malaysia", Gender.MALE, 
				teamMalaysiaMale);
		Player player4 = new Player("Tan Wee Kiong", "Malaysia", Gender.MALE, 
				teamMalaysiaMale);				
		Player player5 = new Player("Chris Langridge", "UK", Gender.MALE, 
				teamUkMale);
		Player player6 = new Player("Marcus Ellis", "UK", Gender.MALE, 
				teamUkMale);	
		
		Player player7 = new Player("Misaki Matsutomo", "Japan", Gender.FEMALE, 
				teamJapanFemale);
		Player player8 = new Player("Ayaka Takahashi", "Japan", Gender.FEMALE, 
				teamJapanFemale);
		Player player9 = new Player("Christinna Pedersen", "Denmark", Gender.FEMALE, 
				teamDenmarkFemale);
		Player player10 = new Player("Kamilla Rytter Juhl", "Denmark", Gender.FEMALE, 
				teamDenmarkFemale);
		Player player11 = new Player("Jung Kyung-eun", "South Korea", Gender.FEMALE, 
				teamSKoreaFemale);
		Player player12 = new Player("Shin Seung-chan", "South Korea", Gender.FEMALE, 
				teamSKoreaFemale);

		Player player13 = new Player("Tontowi Ahmad", "Indonesia", Gender.MALE, 
				teamIndonesiaMixed);
		Player player14 = new Player("Fu Haifeng", "Indonesia", Gender.FEMALE, 
				teamIndonesiaMixed);
		Player player15 = new Player("Chan Peng Soon", "Malaysia", Gender.MALE, 
				teamMalaysiaMixed);
		Player player16 = new Player("Goh Liu Ying", "Malaysia", Gender.FEMALE, 
				teamMalaysiaMixed);		
		Player player17 = new Player("Xu Chen", "China", Gender.MALE, 
				teamChinaMixed);
		Player player18 = new Player("Zhao Yunlei", "China", Gender.FEMALE, 
				teamChinaMixed);	
		
		playerService.savePlayer(player1);		
		playerService.savePlayer(player2);		
		playerService.savePlayer(player3);		
		playerService.savePlayer(player4);
		playerService.savePlayer(player5);		
		playerService.savePlayer(player6);		
		playerService.savePlayer(player7);		
		playerService.savePlayer(player8);
		playerService.savePlayer(player9);		
		playerService.savePlayer(player10);		
		playerService.savePlayer(player11);		
		playerService.savePlayer(player12);
		playerService.savePlayer(player13);		
		playerService.savePlayer(player14);		
		playerService.savePlayer(player15);		
		playerService.savePlayer(player16);
		playerService.savePlayer(player17);		
		playerService.savePlayer(player18);		
		
	}
	
}
		
		