package com.wildrifttracker.infra.database.repositories;

import com.wildrifttracker.infra.database.models.Champion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionRepository extends JpaRepository<Champion, Long> {
}
