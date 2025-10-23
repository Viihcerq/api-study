package com.github.viihcerq.study_apir.dto.product;

import com.github.viihcerq.study_apir.model.Product;

import java.math.BigDecimal;

public class ProductDTO {
    private String name;

    public Product toModel(){
        BigDecimal VALOR_PADRAO = new BigDecimal(2000);

        Product product = new Product();
        product.setValor(VALOR_PADRAO);
        product.setName(this.name);
        return product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
