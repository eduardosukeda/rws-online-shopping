package br.com.fiap.rwsonlineshopping.repository;

import br.com.fiap.rwsonlineshopping.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

}
