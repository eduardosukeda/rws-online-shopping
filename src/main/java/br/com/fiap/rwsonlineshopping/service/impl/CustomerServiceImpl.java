package br.com.fiap.rwsonlineshopping.service.impl;

import br.com.fiap.rwsonlineshopping.dto.CustomerDTO;
import br.com.fiap.rwsonlineshopping.entity.Customer;
import br.com.fiap.rwsonlineshopping.repository.CustomerRepository;
import br.com.fiap.rwsonlineshopping.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDTO getOne(Integer id) {
        return convertToDTO(customerRepository.getOne(id));
    }

    @Override
    public CustomerDTO create(CustomerDTO customerDTO) {
        return convertToDTO(customerRepository.save(convertToEntity(customerDTO)));
    }

    private CustomerDTO convertToDTO(Customer customer) {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());

        return customerDTO;
    }

    private Customer convertToEntity(CustomerDTO customerDTO) {

        Customer customer = new Customer();
        customer.setName(customerDTO.getName());

        return customer;
    }
}