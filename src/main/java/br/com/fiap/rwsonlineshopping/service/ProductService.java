package br.com.fiap.rwsonlineshopping.service;

import br.com.fiap.rwsonlineshopping.dto.ProductDTO;
import br.com.fiap.rwsonlineshopping.entity.Product;

public interface ProductService {

    public ProductDTO get(Integer id);

    public ProductDTO create(Product product, ProductDTO productDTO);

    public ProductDTO update(ProductDTO productDTO);

    public void delete(Integer id);
}