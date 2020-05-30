package br.com.fiap.rwsonlineshopping.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "TB_ORDERED")
public class Ordered implements Serializable {

    private static final long serialVersionUID = -8090023549605344410L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private Customer customer;
    @OneToMany(mappedBy = "ordered", cascade = CascadeType.ALL)
    private List<ShoppingCart> shoppingCart;
    private BigDecimal totalPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ShoppingCart> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(List<ShoppingCart> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
