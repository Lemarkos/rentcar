package kg.mega.rentcarv2.repositories;

import kg.mega.rentcarv2.model.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {
    List<Order> findAllByDateToLessThanEqual(LocalDateTime endDate);
}
