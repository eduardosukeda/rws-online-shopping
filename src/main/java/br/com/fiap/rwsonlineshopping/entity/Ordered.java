package br.com.fiap.rwsonlineshopping.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "TB_ORDERED")
public class Ordered {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private Customer customer;
    @OneToMany(mappedBy = "ordered", cascade = CascadeType.ALL)
    private Set<ShoppingCart> shoppingCart = new HashSet<>();
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

    public Set<ShoppingCart> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(Set<ShoppingCart> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
