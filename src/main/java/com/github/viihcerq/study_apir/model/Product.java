package com.github.viihcerq.study_apir.model;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private String name;
    private BigDecimal valor;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
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
