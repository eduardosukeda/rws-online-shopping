package br.com.fiap.rwsonlineshopping.controller;

import br.com.fiap.rwsonlineshopping.dto.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.rwsonlineshopping.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(produces = {"application/json"})
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO) {
        ProductDTO response = productService.create(productDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
