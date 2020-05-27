package br.com.fiap.rwsonlineshopping.service.impl;

import br.com.fiap.rwsonlineshopping.dto.OrderedDTO;
import br.com.fiap.rwsonlineshopping.dto.ProductDTO;
import br.com.fiap.rwsonlineshopping.entity.Customer;
import br.com.fiap.rwsonlineshopping.entity.Ordered;
import br.com.fiap.rwsonlineshopping.entity.Product;
import br.com.fiap.rwsonlineshopping.entity.ShoppingCart;
import br.com.fiap.rwsonlineshopping.repository.CustomerRepository;
import br.com.fiap.rwsonlineshopping.repository.OrderedRepository;
import br.com.fiap.rwsonlineshopping.repository.ProductRepository;
import br.com.fiap.rwsonlineshopping.repository.ShoppingCartRepository;
import br.com.fiap.rwsonlineshopping.service.OrderedService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class OrderedServiceImpl implements OrderedService {


    private OrderedRepository orderedRepository;

    private ProductRepository productRepository;

    private CustomerRepository customerRepository;

    private ShoppingCartRepository shoppingCartRepository;

    public OrderedServiceImpl(OrderedRepository orderedRepository, ProductRepository productRepository, CustomerRepository customerRepository, ShoppingCartRepository shoppingCartRepository) {
        this.orderedRepository = orderedRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public OrderedDTO getOne(Integer id) {
        return convertToDtoOrdered(orderedRepository.getOne(id));
    }

    @Override
    public OrderedDTO create(Integer customerId, List<ProductDTO> productDTOList) {

        Ordered ordered = new Ordered();
        Set<ShoppingCart> shoppingCartHashSet = new HashSet<>();
        BigDecimal totality = new BigDecimal(0);

        for (int i = 0; i < productDTOList.size(); i++) {
            Product product = productRepository.getOne(productDTOList.get(i).getId());
            totality = totality.add(product.getPrice().multiply(new BigDecimal(productDTOList.get(i).getQuantity())));
            product.setQuantity(product.getQuantity() - productDTOList.get(i).getQuantity());
            productRepository.save(product);
            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.setProduct(product);
            shoppingCart.setOrdered(ordered);
            shoppingCart.setQuantity(productDTOList.get(i).getQuantity());
            shoppingCartHashSet.add(shoppingCart);
        }

        Customer customer = customerRepository.getOne(customerId);

        ordered.setCustomer(customer);
        ordered.setTotalPrice(totality);
        ordered.setShoppingCart(shoppingCartHashSet);
        ordered = orderedRepository.save(ordered);

        return convertToDto(ordered, shoppingCartHashSet, customer);
    }

    private OrderedDTO convertToDto(Ordered ordered, Set<ShoppingCart> shoppingCartHashSet, Customer customer) {

        OrderedDTO orderedDTO = new OrderedDTO();
        List<ProductDTO> productDTOList = new ArrayList<>();

        for (ShoppingCart s : shoppingCartHashSet) {
            productDTOList.add(new ProductDTO(s.getProduct().getId(),
                    s.getProduct().getName(),
                    s.getQuantity(),
                    new BigDecimal(String.valueOf(s.getProduct().getPrice().multiply(new BigDecimal(s.getQuantity()))))));
        }

        orderedDTO.setId(ordered.getId());
        orderedDTO.setProductDTOList(productDTOList);
        orderedDTO.setCustomerId(customer.getId());
        orderedDTO.setTotalPrice(ordered.getTotalPrice());

        return orderedDTO;
    }

    private OrderedDTO convertToDtoOrdered(Ordered ordered) {

        OrderedDTO orderedDTO = new OrderedDTO();
        orderedDTO.setId(ordered.getId());
        orderedDTO.setTotalPrice(ordered.getTotalPrice());

        return orderedDTO;
    }
}