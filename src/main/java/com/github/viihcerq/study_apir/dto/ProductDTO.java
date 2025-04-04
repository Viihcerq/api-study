package com.github.viihcerq.study_apir.dto;

import com.github.viihcerq.study_apir.model.Product;

import java.math.BigDecimal;

public class ProductDTO {
    private String name;
    private BigDecimal valor;

    public Product toModel(){
        Product product = new Product();
        product.setName(this.name);
        product.setValor(this.valor);
        return product;
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
