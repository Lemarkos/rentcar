package kg.mega.rentcarv2.service;

import kg.mega.rentcarv2.dto.OrderDTO;
import kg.mega.rentcarv2.model.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    OrderDTO save(Order order);
    Order update(Order order);
    void delete(Long id);
    Order findById(Long id);
    List<Order> findAll();
}
