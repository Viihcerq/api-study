package com.github.viihcerq.study_apir.controller;

import com.github.viihcerq.study_apir.dto.order.OrderDTO;
import com.github.viihcerq.study_apir.dto.order.OrderResponse;
import com.github.viihcerq.study_apir.dto.order.OrderUpdateDTO;
import com.github.viihcerq.study_apir.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("order")
public class ControllerOrder {

    @Autowired
    private OrderService service;

    @PostMapping
    public ResponseEntity<OrderResponse> create(
            @RequestBody OrderDTO dto) {
        return ResponseEntity
                .status(201)
                .body(new OrderResponse().toDto(service.create(dto)));
    }

    @GetMapping("{id}")
    public ResponseEntity<OrderResponse> findById(@PathVariable Long id){
        return service.findById(id)
                .map(pedido -> ResponseEntity.ok(new OrderResponse().toDto(pedido)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping()
    public ResponseEntity<List<OrderResponse>> listAll(){
        return ResponseEntity.ok(service.findAll().stream()
                .map(pedido -> new OrderResponse().toDto(pedido))
                .collect(Collectors.toList()));
    }

    @GetMapping("status/{status}")
    public ResponseEntity<List<OrderResponse>> findByStatus(@PathVariable String status){
        return ResponseEntity.ok(service.findByStatus(status).stream()
                .map(pedido -> new OrderResponse().toDto(pedido))
                .collect(Collectors.toList()));
    }


}
