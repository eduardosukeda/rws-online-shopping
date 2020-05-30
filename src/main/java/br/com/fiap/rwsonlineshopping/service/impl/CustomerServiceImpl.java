package br.com.fiap.rwsonlineshopping.service.impl;

import br.com.fiap.rwsonlineshopping.dto.CustomerDTO;
import br.com.fiap.rwsonlineshopping.entity.Customer;
import br.com.fiap.rwsonlineshopping.repository.CustomerRepository;
import br.com.fiap.rwsonlineshopping.service.CustomerService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Cacheable(value = "customerCache", key = "#id")
    public CustomerDTO get(Integer id) {
        return convertToDTO(customerRepository.getOne(id));
    }

    @Override
    @Caching(
            put = {@CachePut(value = "customerCache", key = "#customer.getId()")},
            evict = {@CacheEvict(value = "allCustomerCache", allEntries = true)}
    )
    public CustomerDTO create(Customer customer, CustomerDTO customerDTO) {
        Customer saveCustomer = convertToEntity(customer, customerDTO);
        return convertToDTO(customerRepository.save(saveCustomer));
    }

    @Override
    @Caching(
            put = {@CachePut(value = "customerCache", key = "#customerDTO.getId()")},
            evict = {@CacheEvict(value = "allCustomerCache", allEntries = true)}
    )
    public CustomerDTO update(CustomerDTO customerDTO) {

        Customer customer = customerRepository.getOne(customerDTO.getId());
        customer.setName(customerDTO.getName());
        customerRepository.save(customer);

        return convertToDTO(customer);
    }

    @Override
    @Caching(
            evict = {
                    @CacheEvict(value = "customerCache", key = "#id"),
                    @CacheEvict(value = "allCustomerCache", allEntries = true)
            }
    )
    public void delete(Integer id) {
        Customer customer = customerRepository.getOne(id);
        customerRepository.delete(customer);
    }

    private CustomerDTO convertToDTO(Customer customer) {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setDelivery_address(customer.getDelivery_address());
        customerDTO.setCpf(customer.getCpf());

        return customerDTO;
    }

    private Customer convertToEntity(Customer customer, CustomerDTO customerDTO) {

        customer.setName(customerDTO.getName());
        customer.setDelivery_address(customerDTO.getDelivery_address());
        customer.setCpf(customerDTO.getCpf());

        return customer;
    }
}