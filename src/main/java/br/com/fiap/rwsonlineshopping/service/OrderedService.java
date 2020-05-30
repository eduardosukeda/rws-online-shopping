package br.com.fiap.rwsonlineshopping.service;

import br.com.fiap.rwsonlineshopping.dto.OrderedDTO;
import br.com.fiap.rwsonlineshopping.dto.ProductDTO;
import br.com.fiap.rwsonlineshopping.entity.Ordered;

import java.util.List;

public interface OrderedService {

    public OrderedDTO get(Integer id);

    public OrderedDTO create(Ordered ordered, Integer customerId, List<ProductDTO> productDTOList);

    public void delete(Integer id);
}