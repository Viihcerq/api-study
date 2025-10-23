package com.github.viihcerq.study_apir.dto.order;

import com.github.viihcerq.study_apir.model.Order;
import com.github.viihcerq.study_apir.model.OrderStatus;
import com.github.viihcerq.study_apir.model.Product;

import java.math.BigDecimal;

public class OrderUpdateDTO {
    private BigDecimal valor;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Product toModel(Product product){
        product.setValor(this.valor);
        return product;
    }
}
