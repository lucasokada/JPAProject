package com.jpaproject.demo.repositories;

import com.jpaproject.demo.model.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
