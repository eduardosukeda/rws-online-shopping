package br.com.fiap.rwsonlineshopping.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.rwsonlineshopping.entity.Customer;
import br.com.fiap.rwsonlineshopping.entity.Ordered;
import br.com.fiap.rwsonlineshopping.entity.Product;
import br.com.fiap.rwsonlineshopping.repository.OrderedRepository;

@Service
public class OrderedService {

	@Autowired
	OrderedRepository orderedRepository;

	@Autowired
	ProductService productService;

	@Autowired
	CustomerService customerService;

	public Ordered getOne(Integer id) {
		return orderedRepository.getOne(id);
	}

	public Ordered create(Ordered ordered, Integer idProduct, Integer idCustomer) {

		Product product = productService.getOne(idProduct);
		Customer customer = customerService.getOne(idCustomer);
		ordered.setProduct(product);
		ordered.setCustomer(customer);
		ordered.setPrice(product.getPrice().multiply(new BigDecimal(ordered.getQuantity())));
		return orderedRepository.save(ordered);
	}
}