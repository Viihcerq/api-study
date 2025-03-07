package com.github.viihcerq.study_apir.controller;

import com.github.viihcerq.study_apir.model.Product;
import com.github.viihcerq.study_apir.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("product")
public class ControllerProduct {
    @Autowired
    private ProductService service;
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product){
        Product productCreate = service.createProduct(product);
        return ResponseEntity.status(201).body(productCreate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Product>> update(@PathVariable Long id, @RequestBody Product product){
        Optional<Product> productUpdate = service.updateProduct(id, product);
        return ResponseEntity.status(200).body(productUpdate);
    }

    @GetMapping
    public ResponseEntity<String> find(){
        service.getProductId(null);
        return ResponseEntity.status(200).body("Melancia");
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(){
        service.deleteProduct(null);
        return ResponseEntity.status(204).build();
    }
}
