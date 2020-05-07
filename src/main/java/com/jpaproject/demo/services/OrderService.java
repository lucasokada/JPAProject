package com.jpaproject.demo.services;

import com.jpaproject.demo.model.Order;
import com.jpaproject.demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Integer id) {
        Optional<Order> obj = orderRepository.findById(id);
        return obj.get();
    }
}
