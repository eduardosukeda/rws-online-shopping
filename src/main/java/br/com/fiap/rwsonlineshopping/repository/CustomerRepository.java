package br.com.fiap.rwsonlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.rwsonlineshopping.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
