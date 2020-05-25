package br.com.fiap.rwsonlineshopping.controller;

import br.com.fiap.rwsonlineshopping.dto.OrderedDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.rwsonlineshopping.service.CustomerService;
import br.com.fiap.rwsonlineshopping.service.OrderedService;
import br.com.fiap.rwsonlineshopping.service.ProductService;

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
    public OrderedDTO create(@RequestParam Integer quantity, @RequestParam Integer productId, @RequestParam Integer customerId) {
        return orderedService.create(quantity, productId, customerId);
    }
}
