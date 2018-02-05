package com.riri.grocerystore.repository;

import com.riri.grocerystore.model.Cosmetics;
import org.springframework.data.repository.CrudRepository;

public interface CosmeticsRepo  extends CrudRepository<Cosmetics, Long> {
}
