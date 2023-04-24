package kg.mega.rentcarv2.repositories;

import kg.mega.rentcarv2.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepo extends JpaRepository<Car,Long> {
    @Query(value = "select * from tb_car where is_available=false",nativeQuery = true)
    List<Car> findByIsAvailableIsFalse(Boolean isAv);

    @Query(value = "select * from tb_car where is_available=true",nativeQuery = true)
    List<Car>findByIsAvailableIsTrue(Boolean isAv);
}
