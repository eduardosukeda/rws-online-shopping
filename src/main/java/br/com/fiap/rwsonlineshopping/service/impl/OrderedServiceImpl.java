package br.com.fiap.rwsonlineshopping.service.impl;

import br.com.fiap.rwsonlineshopping.dto.OrderedDTO;
import br.com.fiap.rwsonlineshopping.entity.Customer;
import br.com.fiap.rwsonlineshopping.entity.Ordered;
import br.com.fiap.rwsonlineshopping.entity.Product;
import br.com.fiap.rwsonlineshopping.repository.CustomerRepository;
import br.com.fiap.rwsonlineshopping.repository.OrderedRepository;
import br.com.fiap.rwsonlineshopping.repository.ProductRepository;
import br.com.fiap.rwsonlineshopping.service.OrderedService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderedServiceImpl implements OrderedService {


    private OrderedRepository orderedRepository;

    private ProductRepository productRepository;

    private CustomerRepository customerRepository;

    public OrderedServiceImpl(OrderedRepository orderedRepository, ProductRepository productRepository, CustomerRepository customerRepository) {
        this.orderedRepository = orderedRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public OrderedDTO getOne(Integer id) {
        return convertToDtoOrdered(orderedRepository.getOne(id));
    }

    @Override
    public OrderedDTO create(Integer quantity, Integer productId, Integer customerId) {

        Ordered ordered = new Ordered();
        Product product = productRepository.getOne(productId);
        Customer customer = customerRepository.getOne(customerId);
        ordered.setProduct(product);
        ordered.setCustomer(customer);
        ordered.setQuantity(quantity);
        ordered.setPrice(product.getPrice().multiply(new BigDecimal(quantity)));
        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
        return convertToDto(orderedRepository.save(ordered), product, customer);
    }

    private OrderedDTO convertToDto(Ordered ordered, Product product, Customer customer) {

        OrderedDTO orderedDTO = new OrderedDTO();
        orderedDTO.setId(ordered.getId());
        orderedDTO.setProductId(product.getId());
        orderedDTO.setCustomerId(customer.getId());
        orderedDTO.setPrice(ordered.getPrice());
        orderedDTO.setQuantity(ordered.getQuantity());

        return orderedDTO;
    }

    private OrderedDTO convertToDtoOrdered(Ordered ordered) {

        OrderedDTO orderedDTO = new OrderedDTO();
        orderedDTO.setId(ordered.getId());
        orderedDTO.setPrice(ordered.getPrice());
        orderedDTO.setQuantity(ordered.getQuantity());

        return orderedDTO;
    }
}