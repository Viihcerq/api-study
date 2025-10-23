package com.github.viihcerq.study_apir.dto.order;

import com.github.viihcerq.study_apir.dto.item.ItemResponse;
import com.github.viihcerq.study_apir.model.Order;
import com.github.viihcerq.study_apir.model.OrderStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class OrderResponse {

    private Long id;
    private OrderStatus status;
    private LocalDate dateDelivery;
    private List<ItemResponse> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<ItemResponse> getItems() {
        return items;
    }

    public void setItems(List<ItemResponse> items) {
        this.items = items;
    }

    public LocalDate getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(LocalDate dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public OrderResponse toDto(Order order) {
        this.setId(order.getId());
        this.setStatus(order.getStatus());
        this.setDateDelivery(order.getDateDelivery());

        List<ItemResponse> items = order.getItems()
                .stream()
                .map(item -> new ItemResponse().toDto(item))
                .collect(Collectors.toList());

        this.setItems(items);
        return this;
    }
}
