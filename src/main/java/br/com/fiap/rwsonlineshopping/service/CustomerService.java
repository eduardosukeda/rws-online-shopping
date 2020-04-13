package br.com.fiap.rwsonlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.rwsonlineshopping.entity.Customer;
import br.com.fiap.rwsonlineshopping.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public Customer getOne(Integer id) {
		return customerRepository.getOne(id);
	}

	public Customer create(Customer customer) {
		return customerRepository.save(customer);
	}
}