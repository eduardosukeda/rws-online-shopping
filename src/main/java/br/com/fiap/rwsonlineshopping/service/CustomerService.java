package br.com.fiap.rwsonlineshopping.service;

import br.com.fiap.rwsonlineshopping.dto.CustomerDTO;

public interface CustomerService {

    public CustomerDTO getOne(Integer id);

    public CustomerDTO create(CustomerDTO customerDTO);
}