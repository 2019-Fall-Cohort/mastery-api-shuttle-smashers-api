package org.wcci.apimastery.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.models.Player;

public interface PlayerRepository extends CrudRepository<Player, Long> {

}
