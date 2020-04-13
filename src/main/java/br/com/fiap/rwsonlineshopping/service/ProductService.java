package br.com.fiap.rwsonlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.rwsonlineshopping.entity.Product;
import br.com.fiap.rwsonlineshopping.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;

	public Product getOne(Integer id) {
		return productRepository.getOne(id);
	}

	public Product create(Product product) {
		return productRepository.save(product);
	}
}