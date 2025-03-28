package com.github.viihcerq.study_apir.service;

import com.github.viihcerq.study_apir.dto.ProductDTO;
import com.github.viihcerq.study_apir.dto.ProductUpdateDTO;
import com.github.viihcerq.study_apir.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    private static  final BigDecimal VALOR_PADRAO = new BigDecimal(2000);

    private Long sequence = 1L;
    // o objeto é referenciado são os mesmos em memoria
    public Product createProduct(ProductDTO dto){
        Product product = new Product();
        product.setId(sequence++);
        product.setName(dto.getName());
        product.setValor(VALOR_PADRAO);
        products.add(product);
        return product;
    }
    public Optional<Product> updateProduct(Long id, ProductUpdateDTO dto){
        return products.stream().filter(product1 -> product1.getId().equals(id)).findFirst()
                .map(p -> {
                    p.setValor(dto.getValor());
                    return p;
                });

    }
    public Optional<Product> getProductId(Long id){
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }
    public List<Product> getAll(){
        return products;
    }
    public boolean deleteProduct(Long id){
        return products.removeIf(p -> p.getId().equals(id));
    }

}
