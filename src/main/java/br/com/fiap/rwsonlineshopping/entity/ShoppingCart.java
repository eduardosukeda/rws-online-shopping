package br.com.fiap.rwsonlineshopping.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_SHOPPING_CART")
@IdClass(ShoppingCart.class)
public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = 548337594683494407L;

    @Id
    @ManyToOne
    @JoinColumn
    private Product product;

    @Id
    @ManyToOne
    @JoinColumn
    private Ordered ordered;

    private Integer quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Ordered getOrdered() {
        return ordered;
    }

    public void setOrdered(Ordered ordered) {
        this.ordered = ordered;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
