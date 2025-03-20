package com.github.viihcerq.study_apir.controller;

import com.github.viihcerq.study_apir.dto.ProductDTO;
import com.github.viihcerq.study_apir.dto.ProductUpdateDTO;
import com.github.viihcerq.study_apir.model.Product;
import com.github.viihcerq.study_apir.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ControllerProduct {
    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO product){
        Product productCreate = service.createProduct(product);
        return ResponseEntity.status(201).body(productCreate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody ProductUpdateDTO product){

        return service.updateProduct(id, product)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
//        Optional<Product> productUpdate = service.updateProduct(id, product);
//        if (productUpdate.isPresent()) {
//            return ResponseEntity.ok(productUpdate.get());
//        }
//        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        return service.getProductId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
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
