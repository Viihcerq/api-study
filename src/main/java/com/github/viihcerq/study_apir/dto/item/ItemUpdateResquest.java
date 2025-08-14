package com.github.viihcerq.study_apir.dto.item;

import com.github.viihcerq.study_apir.model.Item;
import com.github.viihcerq.study_apir.model.Order;
import com.github.viihcerq.study_apir.model.Product;

import java.math.BigDecimal;

public class ItemUpdateResquest {
    private BigDecimal valor;

    public Item toModel(Order order, Product product){
        Item item = new Item();
        item.setValor(this.valor);
        item.setProduct(product);
        item.setOrder(order);
        return item;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
