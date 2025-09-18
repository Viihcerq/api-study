package com.github.viihcerq.study_apir.service;

import com.github.viihcerq.study_apir.dto.order.OrderDTO;
import com.github.viihcerq.study_apir.dto.order.OrderUpdateDTO;
import com.github.viihcerq.study_apir.model.Item;
import com.github.viihcerq.study_apir.model.Orders;
import com.github.viihcerq.study_apir.model.Product;
import com.github.viihcerq.study_apir.repository.OrderRepository;
import com.github.viihcerq.study_apir.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;
    @Autowired
    private ProductRepository productRepository;

    public Orders create(OrderDTO dto) {
        Orders orders = new Orders();
        orders.setStatus("ABERTO");
        List<Item> items = dto.getItems().stream()
                .map(i -> {
                    Item item = new Item();
                    Product produto = productRepository
                            .findById(i.getId())
                            .orElseThrow(() ->
                                    new RuntimeException(
                                            "Produto inexistente: " + i.getId()));

                    item.setProduct(produto);
                    item.setValor(i.getValor());
                    item.setQta(i.getQta());
                    item.setOrder(orders);
                    return item;
                })
                .collect(Collectors.toList());

        orders.setItems(items);
        return repository.save(orders);
    }

    public Optional<Orders> updateOrder(Long id, OrderUpdateDTO dto){
        return repository.findById(id)
                .map(o -> repository.save(dto.toModel()));
    }

    public Optional<Orders> findById(Long id) {
        return repository.findById(id);
    }

    public List<Orders> findAll() {
        return repository.findAll();
    }

    public List<Orders> findByStatus(String status) {
        return repository.findByStatus(status);
    }

    // public boolean delete(Long id) {
    //     return false;
    // }
    // public Optional<Pedido> update(Long id, PedidoRequestUpdate dto) {
    //     return pedidoRepository.findById(id)
    //         .map(p -> pedidoRepository.save(p));

    // }
}
