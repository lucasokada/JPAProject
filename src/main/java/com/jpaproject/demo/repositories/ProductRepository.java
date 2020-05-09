package com.jpaproject.demo.repositories;

import com.jpaproject.demo.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
