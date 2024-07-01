package com.impllife.data.entity;

import com.impllife.data.convert.OrderStatusConverter;
import lombok.Data;

import jakarta.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;

@Data
@Entity
@Table(name = "il_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateCreate;
    private Date dateLastUpdateStatus;
    private double price;
    @Convert(converter = OrderStatusConverter.class)
    private OrderStatus status;

    @OneToMany(mappedBy = "order", cascade = {ALL}, fetch = LAZY)
    private Set<OrderItem> items = new LinkedHashSet<>();

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "customer_id")
    private User customer;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "address_id")
    private Address address;
}
