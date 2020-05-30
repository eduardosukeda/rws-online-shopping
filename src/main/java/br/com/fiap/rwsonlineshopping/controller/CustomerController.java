package br.com.fiap.rwsonlineshopping.controller;

import br.com.fiap.rwsonlineshopping.dto.CustomerDTO;
import br.com.fiap.rwsonlineshopping.entity.Customer;
import br.com.fiap.rwsonlineshopping.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerDTO> get(@PathVariable Integer id) {
        CustomerDTO response = customerService.get(id);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> create(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO response = customerService.create(new Customer(), customerDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CustomerDTO> update(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO response = customerService.update(customerDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        customerService.delete(id);
    }
}
