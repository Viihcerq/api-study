package com.github.viihcerq.study_apir.controller;

import com.github.viihcerq.study_apir.dto.product.ProductDTO;
import com.github.viihcerq.study_apir.dto.product.ProductResponse;
import com.github.viihcerq.study_apir.dto.product.ProductUpdateDTO;
import com.github.viihcerq.study_apir.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("product")
public class ControllerProduct {
    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody ProductDTO product){
        return ResponseEntity.status(201).body(new ProductResponse().toDto(service.createProduct(product)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable Long id, @RequestBody ProductUpdateDTO product){

        return service.updateProduct(id, product)
                .map(p -> new ProductResponse().toDto(p))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id){
        return service.getProductById(id)
                .map(p -> new ProductResponse().toDto(p))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll(){
        List<ProductResponse> responses =
                service.getAll().stream()
                        .map(p -> new ProductResponse().toDto(p))
                .collect(Collectors.toList());

        return ResponseEntity.ok(responses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        boolean result = service.deleteProduct(id);
        if (result){
            return ResponseEntity.noContent().build();
        }else {
            return  ResponseEntity.notFound().build();
        }

    }
}
