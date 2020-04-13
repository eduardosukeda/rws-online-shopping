package br.com.fiap.rwsonlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.rwsonlineshopping.entity.Ordered;

public interface OrderedRepository extends JpaRepository<Ordered, Integer> {

}
