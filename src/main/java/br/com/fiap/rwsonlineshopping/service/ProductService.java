package br.com.fiap.rwsonlineshopping.service;

import br.com.fiap.rwsonlineshopping.dto.ProductDTO;

public interface ProductService {

    public ProductDTO getOne(Integer id);

    public ProductDTO create(ProductDTO productDTO);
}