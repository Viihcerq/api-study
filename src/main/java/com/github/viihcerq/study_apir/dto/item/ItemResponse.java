package com.github.viihcerq.study_apir.dto.item;

import com.github.viihcerq.study_apir.model.Item;

import java.math.BigDecimal;

public class ItemResponse {
    private Long id;
    private String produto_name;
    private BigDecimal valor;
    private BigDecimal quantidade;

    public ItemResponse toDto(Item item) {
        this.setId(item.getId());
        this.setValor(item.getValor());
        this.setQuantidade(item.getQta());
        this.setProduto_name(item.getProduct().getName());
        return this;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduto_name() {
        return produto_name;
    }

    public void setProduto_name(String produto_name) {
        this.produto_name = produto_name;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }
}
