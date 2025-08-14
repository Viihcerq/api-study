package com.github.viihcerq.study_apir.dto.product;

import com.github.viihcerq.study_apir.model.Product;

import java.math.BigDecimal;

public class ProductUpdateDTO {
    private BigDecimal valor;

    public Product toModel(Product product){
        product.setValor(this.valor);
        return product;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
