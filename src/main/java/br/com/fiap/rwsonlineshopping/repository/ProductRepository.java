package br.com.fiap.rwsonlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.rwsonlineshopping.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
