package br.com.fiap.rwsonlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.rwsonlineshopping.entity.Ordered;
import br.com.fiap.rwsonlineshopping.service.CustomerService;
import br.com.fiap.rwsonlineshopping.service.OrderedService;
import br.com.fiap.rwsonlineshopping.service.ProductService;

@RestController
public class OrderedController {

	@Autowired
	OrderedService orderedService;

	@Autowired
	ProductService productService;

	@Autowired
	CustomerService customerService;

	@PostMapping(path = "/ordered", produces = { "application/json" })
	public void create(@RequestBody Ordered ordered, Integer idProduct, Integer idCustomer) {
		orderedService.create(ordered, idProduct, idCustomer);
	}
}
