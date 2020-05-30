package br.com.fiap.rwsonlineshopping.dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable {

    private static final long serialVersionUID = 1046148523675274195L;

    private Integer id;
    private String name;
    private String delivery_address;
    private String cpf;

    public CustomerDTO() {
    }

    public CustomerDTO(Integer id, String name, String delivery_address, String cpf) {
        this.id = id;
        this.name = name;
        this.delivery_address = delivery_address;
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDelivery_address() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
