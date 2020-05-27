package br.com.fiap.rwsonlineshopping.service;

import br.com.fiap.rwsonlineshopping.dto.OrderedDTO;
import br.com.fiap.rwsonlineshopping.dto.ProductDTO;

import java.util.List;

public interface OrderedService {

    public OrderedDTO getOne(Integer id);

    public OrderedDTO create(Integer customerId, List<ProductDTO> productDTOList);
}