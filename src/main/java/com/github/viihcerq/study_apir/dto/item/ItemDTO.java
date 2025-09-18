package com.github.viihcerq.study_apir.dto.item;

import java.math.BigDecimal;

public class ItemDTO {
    private Long product_id;
    private Long order_id;
    private BigDecimal qta;
    private BigDecimal valor;

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public BigDecimal getQta() {
        return qta;
    }

    public void setQta(BigDecimal qta) {
        this.qta = qta;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
