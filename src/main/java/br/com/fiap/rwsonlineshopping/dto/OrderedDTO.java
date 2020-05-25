package br.com.fiap.rwsonlineshopping.dto;

import java.math.BigDecimal;

public class OrderedDTO {

    private Integer id;
    private Integer customerId;
    private Integer productId;
    private Integer quantity;
    private BigDecimal price;

    public OrderedDTO() {
    }

    public OrderedDTO(Integer id, Integer customerId, Integer productId, Integer quantity, BigDecimal price) {
        this.id = id;
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
