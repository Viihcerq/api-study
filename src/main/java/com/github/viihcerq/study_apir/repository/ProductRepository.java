package com.github.viihcerq.study_apir.repository;

import com.github.viihcerq.study_apir.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
