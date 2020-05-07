package com.jpaproject.demo.config;

import com.jpaproject.demo.model.Order;
import com.jpaproject.demo.model.User;
import com.jpaproject.demo.model.enums.OrderStatus;
import com.jpaproject.demo.repositories.OrderRepository;
import com.jpaproject.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

@Configuration
@Profile("test")
public class Test implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Lucas okada", "l@gmail.com", "822222222", "senha");
        User u2 = new User(null, "nome teste", "teste@gmail.com", "233333333", "senha 10000");

        Order o1 = new Order(null, new java.sql.Date(new java.util.Date().getTime()), OrderStatus.PAID, u1);
        Order o2 = new Order(null, new java.sql.Date(new java.util.Date().getTime()), OrderStatus.CANCELED, u2);


        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2));
    }
}