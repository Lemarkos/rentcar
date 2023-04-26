package kg.mega.rentcarv2.service.impl;

import kg.mega.rentcarv2.model.Car;
import kg.mega.rentcarv2.repositories.CarRepo;
import kg.mega.rentcarv2.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepo carRepo;

    @Override
    public Car save(Car car) {
        return carRepo.save(car);
    }

    @Override
    public Car findById(Long id) {
        return carRepo.findById(id).get();
    }
    @Override
    public List<Car> findAll() {
        return carRepo.findAll();
    }

    @Override
    public List<Car> findByIsUnAvailable(Boolean isAv) {
        return carRepo.findByIsAvailableIsFalse(isAv);
    }

    @Override
    public List<Car> findByIsAvailable(Boolean avb) {
        return carRepo.findByIsAvailableIsTrue(avb);
    }
}
