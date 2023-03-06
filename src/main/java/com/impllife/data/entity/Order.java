package com.impllife.data.entity;

import com.impllife.data.convert.OrderStatusConverter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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

    @OneToMany(mappedBy = "order", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Set<OrderItem> items = new java.util.LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    //region get set

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateLastUpdateStatus() {
        return dateLastUpdateStatus;
    }

    public void setDateLastUpdateStatus(Date dateLastUpdateStatus) {
        this.dateLastUpdateStatus = dateLastUpdateStatus;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public void setItems(Set<OrderItem> items) {
        this.items = items;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    //endregion
}
