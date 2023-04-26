package kg.mega.rentcarv2.controller;

import kg.mega.rentcarv2.dto.OrderDTO;
import kg.mega.rentcarv2.mapper.OrderMapper;
import kg.mega.rentcarv2.model.Order;
import kg.mega.rentcarv2.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @PostMapping("/make")
    public OrderDTO makeOrder(@RequestBody OrderDTO orderDTO){
        return orderService.save(orderMapper.toEntity(orderDTO));
    }

    @PutMapping("/update")
    public Order updateOrder(@RequestBody Order order){
        return orderService.update(order);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable("id") Long id){
        orderService.delete(id);
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable Long id){
        return orderService.findById(id);
    }

    @GetMapping("/findAll")
    public List<Order> findAll(){
        return orderService.findAll();
    }
}
