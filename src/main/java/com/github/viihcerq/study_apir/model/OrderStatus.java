package com.github.viihcerq.study_apir.model;

public enum OrderStatus {
    ABERTO("Pedido Aberto"),
    CANCELADO("Pedido Cancelado"),
    ENTREGUE("Pedido Entregue");

    OrderStatus(String mensagem) {
        this.mensagem = mensagem;
    }

    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }

}

