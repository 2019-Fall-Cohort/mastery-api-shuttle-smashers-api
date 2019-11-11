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

public class PlayerServiceTest {

	@InjectMocks
	private PlayerService underTest;
	
	@Mock
	private PlayerRepository playerRepo;
	@Mock
	private Player mockPlayer;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldAddPlayerToRepo() throws Exception {
		Player storedPlayer = underTest.savePlayer(mockPlayer);
		verify(playerRepo).save(mockPlayer);
	}
	
	@Test
	public void shouldFetchOnePlayer() throws Exception {
		when(playerRepo.findById(1L)).thenReturn(Optional.of(mockPlayer));
		Player retrievedPlayer = underTest.fetchPlayer(1L);
		verify(playerRepo).findById(1L);
		assertThat(retrievedPlayer, is(equalTo(mockPlayer)));
	}
	
	@Test
	public void shouldFetchAllPlayers() throws Exception {
		when(playerRepo.findAll()).thenReturn(Collections.singletonList(mockPlayer));
		List<Player> retrievedPlayers = underTest.fetchAllPlayers();
		verify(playerRepo).findAll();
		assertThat(retrievedPlayers, contains(mockPlayer));
	}
	
	@Test
	public void shouldThrowNotFoundExceptionWhenPlayerDoesntExist() throws Exception {
		when(playerRepo.findById(1L)).thenReturn(Optional.empty());
		try {
			underTest.fetchPlayer(1L);
			fail("Exception not thrown");
		}catch (PlayerNotFoundException e) {
			assertThat(e.getMessage(), is(equalTo("Player not found.")));
		}
	}
}
