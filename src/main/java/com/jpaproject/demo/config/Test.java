package com.jpaproject.demo.config;

import com.jpaproject.demo.model.entities.*;
import com.jpaproject.demo.model.enums.OrderStatus;
import com.jpaproject.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class Test implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Lucas okada", "l@gmail.com", "822222222", "senha");
        User u2 = new User(null, "nome teste", "teste@gmail.com", "233333333", "senha 10000");

        Order o1 = new Order(null, new java.sql.Date(new java.util.Date().getTime()), OrderStatus.PAID, u1);
        Order o2 = new Order(null, new java.sql.Date(new java.util.Date().getTime()), OrderStatus.CANCELED, u2);

        Category cat1 = new Category(null, "Music");
        Category cat2 = new Category(null, "Sports");
        Category cat3 = new Category(null, "Eletronics");

        Product prod1 = new Product(null, "chuteira", "chuteira nike", 249.99, null);
        Product prod2 = new Product(null, "fone", "fone philips", 300.00, null);
        Product prod3 = new Product(null, "notebook", "notebooke dell", 3499.99, null);

        OrderItem orderItem1 = new OrderItem(o1, prod1, 2, prod1.getPrice());
        OrderItem orderItem2 = new OrderItem(o1, prod3, 6, prod3.getPrice());
        OrderItem orderItem3 = new OrderItem(o2, prod2, 1, prod2.getPrice());

        prod1.getCategories().add(cat2);
        prod2.getCategories().add(cat1);
        prod3.getCategories().add(cat3);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
        orderItemRepository.saveAll(Arrays.asList(orderItem1, orderItem2, orderItem3));
    }
}
