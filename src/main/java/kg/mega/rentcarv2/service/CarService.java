package kg.mega.rentcarv2.service;

import kg.mega.rentcarv2.model.Car;

import java.util.List;

public interface CarService {
    Car save(Car car);
    Car findById(Long id);
    List<Car> findAll();
    List<Car> findByIsUnAvailable(Boolean unAvb);
    List<Car> findByIsAvailable(Boolean avb);
}
