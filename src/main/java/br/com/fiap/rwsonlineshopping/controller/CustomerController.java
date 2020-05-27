package br.com.fiap.rwsonlineshopping.controller;

import br.com.fiap.rwsonlineshopping.dto.CustomerDTO;
import br.com.fiap.rwsonlineshopping.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(produces = {"application/json"})
    public ResponseEntity<CustomerDTO> create(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO response = customerService.create(customerDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
