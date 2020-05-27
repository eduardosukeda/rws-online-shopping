package br.com.fiap.rwsonlineshopping.controller;

import br.com.fiap.rwsonlineshopping.dto.OrderedDTO;
import br.com.fiap.rwsonlineshopping.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.rwsonlineshopping.service.CustomerService;
import br.com.fiap.rwsonlineshopping.service.OrderedService;
import br.com.fiap.rwsonlineshopping.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("ordered")
public class OrderedController {

    private final OrderedService orderedService;

    private final ProductService productService;

    private final CustomerService customerService;

    public OrderedController(OrderedService orderedService, ProductService productService, CustomerService customerService) {
        this.orderedService = orderedService;
        this.productService = productService;
        this.customerService = customerService;
    }

    @PostMapping(produces = {"application/json"})
    public ResponseEntity<OrderedDTO> create(@RequestParam Integer customerId, @RequestBody List<ProductDTO> productDTOList) {
        OrderedDTO response = orderedService.create(customerId, productDTOList);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
