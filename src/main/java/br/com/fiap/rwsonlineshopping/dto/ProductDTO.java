package br.com.fiap.rwsonlineshopping.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductDTO implements Serializable {

    private static final long serialVersionUID = 1410424084237858562L;

    private Integer id;
    private String name;
    private Integer quantity;
    private BigDecimal price;

    public ProductDTO() {
    }

    public ProductDTO(Integer id, String name, Integer quantity, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
