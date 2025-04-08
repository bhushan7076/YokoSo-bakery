package com.bakery.bakehouse.dto;

public class CartRequestDTO {
    private Integer custId;
    private Integer productId;
    private int quantity;

    public CartRequestDTO() {
    }

    public CartRequestDTO(Integer custId, Integer productId, int quantity) {
        this.custId = custId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
