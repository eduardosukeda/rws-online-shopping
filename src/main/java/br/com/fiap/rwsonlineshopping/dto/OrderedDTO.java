package br.com.fiap.rwsonlineshopping.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class OrderedDTO implements Serializable {

    private static final long serialVersionUID = 8810166465027706467L;

    private Integer id;
    private Integer customerId;
    @JsonProperty("products")
    private List<ProductDTO> productDTOList;
    private BigDecimal totalPrice;

    public OrderedDTO() {
    }

    public OrderedDTO(Integer id, Integer customerId, List<ProductDTO> productDTOList, BigDecimal totalPrice) {
        this.id = id;
        this.customerId = customerId;
        this.productDTOList = productDTOList;
        this.totalPrice = totalPrice;
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

    public List<ProductDTO> getProductDTOList() {
        return productDTOList;
    }

    public void setProductDTOList(List<ProductDTO> productDTOList) {
        this.productDTOList = productDTOList;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
