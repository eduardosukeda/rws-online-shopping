package br.com.fiap.rwsonlineshopping.service.impl;

import br.com.fiap.rwsonlineshopping.dto.ProductDTO;
import br.com.fiap.rwsonlineshopping.entity.Product;
import br.com.fiap.rwsonlineshopping.repository.ProductRepository;
import br.com.fiap.rwsonlineshopping.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO getOne(Integer id) {
        return convertToDto(productRepository.getOne(id));
    }

    @Override
    public ProductDTO create(ProductDTO productDTO) {
        return convertToDto(productRepository.save(convertToEntity(productDTO)));
    }

    private ProductDTO convertToDto(Product product) {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setQuantity(product.getQuantity());

        return productDTO;
    }

    private Product convertToEntity(ProductDTO productDTO) {

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());

        return product;
    }
}