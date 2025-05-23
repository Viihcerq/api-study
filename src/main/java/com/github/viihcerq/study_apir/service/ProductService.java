package com.github.viihcerq.study_apir.service;

import com.github.viihcerq.study_apir.dto.ProductDTO;
import com.github.viihcerq.study_apir.dto.ProductUpdateDTO;
import com.github.viihcerq.study_apir.model.Product;
import com.github.viihcerq.study_apir.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    private Long sequence = 1L;
    // o objeto é referenciado são os mesmos em memoria
    public Product createProduct(ProductDTO dto) {
        return repository.save(dto.toModel());
    }

    public Optional<Product> updateProduct(Long id, ProductUpdateDTO dto) {

        return repository.findById(id)
                .map(p -> repository.save(dto.toModel(p)));
    }

    public Optional<Product> getProductById(Long id) {
        return repository.findById(id);
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public boolean deleteProduct(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }

}
