package com.bakery.bakehouse.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer cartId;

    @ManyToOne
    @JoinColumn(name = "cust_id", referencedColumnName = "custId", nullable = false)
    private Customer customer;  // Maps to Customer entity

    @ManyToOne
    @JoinColumn(name = "p_id", referencedColumnName = "pId", nullable = false)
    private Product product;  // Maps to Product entity

    @Column
    private Integer cartQuantity;

    @Column
    private Double cartPrice;

    @Column
    private Double cartTotal;

    // Default constructor
    public Cart() {}

    public Cart(Customer customer, Product product, Integer cartQuantity, Double cartPrice, Double cartTotal) {
        this.customer = customer;
        this.product = product;
        this.cartQuantity = cartQuantity;
        this.cartPrice = cartPrice;
        this.cartTotal = cartTotal;
    }

    // Getters and Setters
    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(Integer cartQuantity) {
        this.cartQuantity = cartQuantity;
    }

    public Double getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(Double cartPrice) {
        this.cartPrice = cartPrice;
    }

    public Double getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(Double cartTotal) {
        this.cartTotal = cartTotal;
    }

    // toString() method
    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", customer=" + customer.getCustId() +
                ", product=" + product.getPId() +
                ", cartQuantity=" + cartQuantity +
                ", cartPrice=" + cartPrice +
                ", cartTotal=" + cartTotal +
                '}';
    }
}
