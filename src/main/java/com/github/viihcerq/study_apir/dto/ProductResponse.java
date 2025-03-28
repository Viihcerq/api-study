package com.github.viihcerq.study_apir.dto;

import com.github.viihcerq.study_apir.model.Product;

import java.math.BigDecimal;

public class ProductResponse {
    private Long id;
    private String name;
    private BigDecimal valor;

    public ProductResponse toDto(Product product){
        this.setId(product.getId());
        this.setName(product.getName());
        this.setValor(product.getValor());
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
