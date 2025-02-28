package com.github.viihcerq.study_apir.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produto")
public class ControllerProduto {
    @PostMapping
    public ResponseEntity<String> create(){
        return ResponseEntity.status(201).body("Produto criado");
    }
    @PutMapping
    public ResponseEntity<String> update(){
        return ResponseEntity.status(200).body("produto atualizado");
    }

    @GetMapping
    public ResponseEntity<String> find(){
        return ResponseEntity.status(200).body("Melancia");
    }
    @DeleteMapping
    public ResponseEntity<Void> delete(){
        return ResponseEntity.status(204).build();
    }
}
