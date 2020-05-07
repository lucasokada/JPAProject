package com.jpaproject.demo.model.enums;

public enum OrderStatus {

    WAITNG_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private Integer code;

    private OrderStatus(int code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public static OrderStatus valueOf(int givenCode) throws Exception {
        for(OrderStatus obj : OrderStatus.values()) {
            if(obj.getCode() == givenCode) {
                return obj;
            }
        }

        throw new Exception("Invalid OrderStatus Code");
    }
}

