package com.github.viihcerq.study_apir.model;

import org.hibernate.annotations.Cascade;

import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.CascadeType;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @Cascade(value = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @Cascade(value = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

    private BigDecimal qta;
    private BigDecimal valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
