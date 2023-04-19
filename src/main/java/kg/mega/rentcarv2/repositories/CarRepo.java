package kg.mega.rentcarv2.repositories;

import kg.mega.rentcarv2.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends JpaRepository<Car,Long> {

}
