package br.com.fiap.rwsonlineshopping.service.impl;

import br.com.fiap.rwsonlineshopping.dto.ProductDTO;
import br.com.fiap.rwsonlineshopping.entity.Product;
import br.com.fiap.rwsonlineshopping.repository.ProductRepository;
import br.com.fiap.rwsonlineshopping.service.ProductService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Cacheable(value = "productCache", key = "#id")
    public ProductDTO get(Integer id) {
        return convertToDto(productRepository.getOne(id));
    }

    @Override
    @Caching(
            put = {@CachePut(value = "productCache", key = "#product.getId()")},
            evict = {@CacheEvict(value = "allProductCache", allEntries = true)}
    )
    public ProductDTO create(Product product, ProductDTO productDTO) {
        Product saveProduct = convertToEntity(product, productDTO);
        return convertToDto(productRepository.save(saveProduct));
    }

    @Override
    @Caching(
            put = {@CachePut(value = "productCache", key = "#productDTO.getId()")},
            evict = {@CacheEvict(value = "allProductCache", allEntries = true)}
    )
    public ProductDTO update(ProductDTO productDTO) {

        Product product = productRepository.getOne(productDTO.getId());
        product.setQuantity(productDTO.getQuantity());
        product.setPrice(productDTO.getPrice());
        product.setName(productDTO.getName());
        productRepository.save(product);

        return convertToDto(product);
    }

    @Override
    @Caching(
            evict = {
                    @CacheEvict(value = "productCache", key = "#id"),
                    @CacheEvict(value = "allProductCache", allEntries = true)
            }
    )
    public void delete(Integer id) {
        Product product = productRepository.getOne(id);
        productRepository.delete(product);
    }

    private ProductDTO convertToDto(Product product) {

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setQuantity(product.getQuantity());

        return productDTO;
    }

    private Product convertToEntity(Product product, ProductDTO productDTO) {

        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());

        return product;
    }
}