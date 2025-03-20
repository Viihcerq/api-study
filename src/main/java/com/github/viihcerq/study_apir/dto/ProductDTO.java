package com.github.viihcerq.study_apir.dto;

import java.math.BigDecimal;

public class ProductDTO {
    private String name;
    private BigDecimal valor;

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
