package com.github.viihcerq.study_apir.dto.order;

import com.github.viihcerq.study_apir.model.Item;
import com.github.viihcerq.study_apir.model.Order;

import java.util.List;

public class OrderDTO {

    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
