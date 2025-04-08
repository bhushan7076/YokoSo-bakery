package com.bakery.bakehouse.Entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer orderId; // Primary Key

    @ManyToOne
    @JoinColumn(name = "cust_id", referencedColumnName = "custId", nullable = false)
    private Customer customer; // Maps to Customer entity

    @ManyToOne
    @JoinColumn(name = "p_id", referencedColumnName = "pId", nullable = false)
    private Product product; // Maps to Product entity

    @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp orderDate; // Auto-set timestamp

    @Column(nullable = false)
    private Integer quantity; // Matches cart_quantity

    @Column(nullable = false)
    private Double price; // Matches cart_price

    @Column(nullable = false)
    private Double total; // Matches cart_total

    // Default constructor
    public Order() {
    }

    // Parameterized constructor
    public Order(Customer customer, Product product, Integer quantity, Double price, Double total) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
        this.orderDate = new Timestamp(System.currentTimeMillis()); // Set order date to current time
    }

    // Getters and Setters
    public Integer getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Product getProduct() {
        return product;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Double getTotal() {
        return total;
    }

    // toString() method for debugging
    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customer=" + customer.getCustId() +
                ", product=" + product.getPId() +
                ", orderDate=" + orderDate +
                ", quantity=" + quantity +
                ", price=" + price +
                ", total=" + total +
                '}';
    }
}
