package br.com.fiap.rwsonlineshopping.service;

import br.com.fiap.rwsonlineshopping.dto.OrderedDTO;

public interface OrderedService {

    public OrderedDTO getOne(Integer id);

    public OrderedDTO create(Integer quantity, Integer productId, Integer customerId);
}