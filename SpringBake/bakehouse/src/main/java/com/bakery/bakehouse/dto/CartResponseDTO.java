package com.bakery.bakehouse.dto;

public class CartResponseDTO {
    private String productName;
    private Integer cartQuantity;
    private Double cartPrice;
    private Double cartTotal;

    // Constructor
    public CartResponseDTO(String productName, Integer cartQuantity, Double cartPrice, Double cartTotal) {
        this.productName = productName;
        this.cartQuantity = cartQuantity;
        this.cartPrice = cartPrice;
        this.cartTotal = cartTotal;
    }

    // Getters and Setters
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
}
