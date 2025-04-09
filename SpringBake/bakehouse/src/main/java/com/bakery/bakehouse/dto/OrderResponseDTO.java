package com.bakery.bakehouse.dto;

import com.bakery.bakehouse.Entity.Order;

import java.sql.Timestamp;

public class OrderResponseDTO {

    private Integer orderId;
    private Integer custId;
    private Integer productId;
    private String productName;
    private String category;
    private Integer quantity;
    private Double price;
    private Double total;
    private Timestamp orderDate;

    public OrderResponseDTO(Order order) {
        this.orderId = order.getOrderId();
        this.custId = order.getCustomer().getCustId();
        this.productId = order.getProduct().getPId();
        this.productName = order.getProduct().getPName();
        this.category = order.getProduct().getPCategory();
        this.quantity = order.getQuantity();
        this.price = order.getPrice();
        this.total = order.getTotal();
        this.orderDate = order.getOrderDate();
    }

    // Getters & Setters
    public Integer getOrderId() {
        return orderId;
    }

    public Integer getCustId() {
        return custId;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
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

    public Timestamp getOrderDate() {
        return orderDate;
    }
}
