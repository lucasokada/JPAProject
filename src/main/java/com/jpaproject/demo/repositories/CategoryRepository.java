package com.jpaproject.demo.repositories;

import com.jpaproject.demo.model.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
