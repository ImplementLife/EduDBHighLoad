package com.impllife.data.convert;

import com.impllife.data.entity.OrderStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class OrderStatusConverter implements AttributeConverter<OrderStatus, Character> {
    private final EnumConverter<OrderStatus, Character> converter = new EnumConverter<>(OrderStatus.values());

    @Override
    public Character convertToDatabaseColumn(OrderStatus orderStatus) {
        return converter.convertToDatabaseColumn(orderStatus);
    }

    @Override
    public OrderStatus convertToEntityAttribute(Character character) {
        return converter.convertToEntityAttribute(character);
    }
}
