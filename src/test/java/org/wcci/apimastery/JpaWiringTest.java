package org.wcci.apimastery;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaWiringTest {

	@Autowired
	private TeamRepository teamRepo;
	@Autowired
	private PlayerRepository playerRepo;
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void teamWillHavePlayers() throws Exception {
		Team utTeam = new Team("Team1", Gender.MIXED);
		Player utPlayer = new Player("Player1", "Country1", Gender.FEMALE);
		
		utTeam = teamRepo.save(utTeam);
		utPlayer = playerRepo.save(utPlayer);
		
		entityManager.flush();
		entityManager.clear();
		
		Team retrievedTeam = teamRepo.findById(utTeam.getId()).get();
		
		assertEquals(utTeam, retrievedTeam);
		assertThat(retrievedTeam.getPlayers(), contains(utPlayer));
	}
}
