package kg.mega.rentcarv2.mapper;


import kg.mega.rentcarv2.dto.OrderDTO;
import kg.mega.rentcarv2.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toEntity(OrderDTO orderDTO);
    OrderDTO toDTO(Order order);

    List<OrderDTO> toDTOList(List<Order> orderList);
}
