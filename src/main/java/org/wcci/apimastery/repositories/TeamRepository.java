package org.wcci.apimastery.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.apimastery.models.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {

}
