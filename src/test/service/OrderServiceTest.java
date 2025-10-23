package service;

import com.github.viihcerq.study_apir.dto.item.ItemDTO;
import com.github.viihcerq.study_apir.dto.order.OrderDTO;
import com.github.viihcerq.study_apir.model.Order;
import com.github.viihcerq.study_apir.model.Product;
import com.github.viihcerq.study_apir.repository.OrderRepository;
import com.github.viihcerq.study_apir.repository.ProductRepository;
import com.github.viihcerq.study_apir.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class OrderServiceTest {
    @Mock
    private OrderRepository pedidoRepository;

    @Mock
    private ProductRepository produtoRepository;

    @InjectMocks
    private OrderService pedidoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void givenPedidoRequestWhenCreateThenPedidoIsSaved() {
        // Given
        OrderDTO pedidoRequestCreate = new OrderDTO();
        pedidoRequestCreate.setDateOrder(LocalDate.now());
        pedidoRequestCreate.setDateDelivery(LocalDate.now());

        Order pedidoMock = new Order();
        pedidoMock.setId(1L);

        // Mocking Produto
        Product produtoMock = new Product();
        produtoMock.setId(1L);
        produtoMock.setName("Produto A");

        // Mocking Item
        List<ItemDTO> items = new ArrayList<>();
        ItemDTO item = new ItemDTO();
        item.setProduct_id(1L);
        item.setQta(new BigDecimal(2));
        item.setValor(new BigDecimal(10));
        items.add(item);

        pedidoRequestCreate.setItems(items);

        // When
        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produtoMock));
        when(pedidoRepository.save(any(Order.class))).thenReturn(pedidoMock);

        Order resultado = pedidoService.create(pedidoRequestCreate);

        // Then
        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        verify(pedidoRepository, times(1)).save(any(Order.class));
    }
}
