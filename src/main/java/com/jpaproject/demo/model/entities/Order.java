package com.jpaproject.demo.model.entities;

import com.jpaproject.demo.model.entities.User;
import com.jpaproject.demo.model.enums.OrderStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date moment;

    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Order(Integer id, Date moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    public Order() {
    }

    @JoinColumn(name = "order_status")
    public OrderStatus getOrderStatus() throws Exception {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus.getCode();
    }

    public Integer getId() {
        return id;
    }

    public Date getMoment() {
        return moment;
    }

    public User getClient() {
        return client;
    }
}
