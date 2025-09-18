package com.github.viihcerq.study_apir.model;

import jakarta.persistence.*;

import java.util.List;

@Entity

public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String status;

    @OneToMany(mappedBy = "orders",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Item> items;

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
