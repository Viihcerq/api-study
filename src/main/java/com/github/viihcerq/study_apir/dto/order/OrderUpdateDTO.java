package com.github.viihcerq.study_apir.dto.order;

import com.github.viihcerq.study_apir.model.Order;

public class OrderUpdateDTO {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Order toModel(){
        Order order = new Order();
        order.setStatus(this.status);
        return order;
    }
}
