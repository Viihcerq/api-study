package com.github.viihcerq.study_apir.dto.order;

import com.github.viihcerq.study_apir.model.Orders;

public class OrderUpdateDTO {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Orders toModel(){
        Orders orders = new Orders();
        orders.setStatus(this.status);
        return orders;
    }
}
