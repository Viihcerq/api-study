package com.github.viihcerq.study_apir.dto.order;

import com.github.viihcerq.study_apir.dto.item.ItemResponse;
import com.github.viihcerq.study_apir.model.Item;
import com.github.viihcerq.study_apir.model.Order;

import java.util.List;
import java.util.stream.Collectors;

public class OrderResponse {

    private Long id;
    private String status;

    private List<ItemResponse> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ItemResponse> getItems() {
        return items;
    }

    public void setItems(List<ItemResponse> items) {
        this.items = items;
    }

    public OrderResponse toDto(Order order) {
        this.setId(order.getId());
        this.setStatus(order.getStatus());

        List<ItemResponse> items = order.getItems()
                .stream()
                .map(item -> new ItemResponse().toDto(item))
                .collect(Collectors.toList());

        this.setItems(items);
        return this;
    }
}
