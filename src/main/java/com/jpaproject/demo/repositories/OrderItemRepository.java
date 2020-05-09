package com.jpaproject.demo.repositories;

import com.jpaproject.demo.model.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
