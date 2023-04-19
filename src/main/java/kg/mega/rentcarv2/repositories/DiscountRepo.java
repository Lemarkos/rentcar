package kg.mega.rentcarv2.repositories;

import kg.mega.rentcarv2.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountRepo extends JpaRepository<Discount,Long> {
    List<Discount>findAllByCarIdAndDaysCountLessThanEqualOrderByDaysCountDesc(Long id, Integer count);
}
