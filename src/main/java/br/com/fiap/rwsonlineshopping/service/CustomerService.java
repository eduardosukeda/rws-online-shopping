package br.com.fiap.rwsonlineshopping.service;

import br.com.fiap.rwsonlineshopping.dto.CustomerDTO;
import br.com.fiap.rwsonlineshopping.entity.Customer;

public interface CustomerService {

    public CustomerDTO get(Integer id);

    public CustomerDTO create(Customer customer, CustomerDTO customerDTO);

    public CustomerDTO update(CustomerDTO customerDTO);

    public void delete(Integer id);
}