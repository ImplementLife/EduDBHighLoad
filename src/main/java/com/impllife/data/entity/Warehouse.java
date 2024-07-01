package com.impllife.data.entity;

import jakarta.persistence.*;

import static jakarta.persistence.FetchType.LAZY;

@Entity(name = "il_warehouse")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "address_id")
    private Address address;
}
