package org.wcci.apimastery;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TeamServiceTest {

	@InjectMocks
	private TeamService underTest;
	
	@Mock
	private TeamRepository teamRepo;
	@Mock
	private Team mockTeam;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldAddTeamToRepo() throws Exception {
		Team storedTeam = underTest.saveTeam(mockTeam);
		verify(teamRepo).save(mockTeam);
	}
	
	@Test
	public void shouldFetchOneTeam() throws Exception {
		when(teamRepo.findById(1L)).thenReturn(Optional.of(mockTeam));
		Team retrievedTeam = underTest.fetchTeam(1L);
		verify(teamRepo).findById(1L);
		assertThat(retrievedTeam, is(equalTo(mockTeam)));
	}
	
	@Test
	public void shouldFetchAllTeams() throws Exception {
		when(teamRepo.findAll()).thenReturn(Collections.singletonList(mockTeam));
		List<Team> retrievedTeams = underTest.fetchAllTeams();
		verify(teamRepo).findAll();
		assertThat(retrievedTeams, contains(mockTeam));
	}
	
	@Test
	public void shouldThrowNotFoundExceptionWhenTeamDoesntExist() throws Exception {
		when(teamRepo.findById(1L)).thenReturn(Optional.empty());
		try {
			underTest.fetchTeam(1L);
			fail("Exception not thrown");
		}catch (TeamNotFoundException e) {
			assertThat(e.getMessage(), is(equalTo("Team not found.")));
		}
	}
}
