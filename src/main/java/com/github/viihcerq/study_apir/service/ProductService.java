package com.github.viihcerq.study_apir.service;

import com.github.viihcerq.study_apir.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    private Long sequence = 1L;
    // o objeto é referenciado são os mesmos em memoria
    public Product createProduct(Product product){
        product.setId(sequence++);
        products.add(product);
        return product;
    }
    public Optional<Product> updateProduct(Long id, Product product){
        return products.stream().filter(product1 -> product1.getId().equals(id)).findFirst()
                .map(p -> {
                    p.setName(product.getName());
                    return p;
                });

    }
    public void getProductId(Long id){

    }
    public void deleteProduct(Long id){

    }

}
