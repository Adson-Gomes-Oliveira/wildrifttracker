package com.wildrifttracker.infra.database.repositories;

import com.wildrifttracker.infra.database.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
