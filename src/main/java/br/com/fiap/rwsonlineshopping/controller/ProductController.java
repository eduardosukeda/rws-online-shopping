package br.com.fiap.rwsonlineshopping.controller;

import br.com.fiap.rwsonlineshopping.dto.ProductDTO;
import br.com.fiap.rwsonlineshopping.entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.rwsonlineshopping.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDTO> get(@PathVariable Integer id) {
        ProductDTO response = productService.get(id);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO) {
        ProductDTO response = productService.create(new Product(), productDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO productDTO) {
        ProductDTO response = productService.update(productDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        productService.delete(id);
    }
}
