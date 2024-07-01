package com.impllife.data.convert;

import com.impllife.data.entity.OrderStatus;

import jakarta.persistence.Converter;

@Converter
public class OrderStatusConverter extends EnumConverter<OrderStatus, Character> {
    public OrderStatusConverter() {
        super(OrderStatus.values());
    }
}
