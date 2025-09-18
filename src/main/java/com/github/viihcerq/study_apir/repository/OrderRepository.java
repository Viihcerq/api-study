package com.github.viihcerq.study_apir.repository;

import com.github.viihcerq.study_apir.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    public List<Orders> findByStatus(String status);
}
