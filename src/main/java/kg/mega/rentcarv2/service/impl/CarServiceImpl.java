package kg.mega.rentcarv2.service.impl;

import kg.mega.rentcarv2.model.Car;
import kg.mega.rentcarv2.repositories.CarRepo;
import kg.mega.rentcarv2.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepo carRepo;
    @Override
    public Car findById(Long id) {
        return carRepo.findById(id).get();
    }
}
