package com.riri.grocerystore.repository;

import com.riri.grocerystore.model.Snacks;
import org.springframework.data.repository.CrudRepository;

public interface SnacksRepo extends CrudRepository<Snacks, Long> {
}
