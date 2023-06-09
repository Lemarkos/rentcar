package kg.mega.rentcarv2.controller;

import kg.mega.rentcarv2.dto.CarDTO;
import kg.mega.rentcarv2.mapper.CarMapper;
import kg.mega.rentcarv2.model.Car;
import kg.mega.rentcarv2.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    private final CarMapper carMapper;


    @PostMapping("/save")
    public Car save(@RequestBody Car car){
        return carService.save(car);
    }

    @GetMapping("/findById")
    public CarDTO findById(@RequestParam Long id){
        return carMapper.toDTO(carService.findById(id));
    }

    @GetMapping("/findAll")
    public List<CarDTO> findAll(){
        return carMapper.toDTOList(carService.findAll());
    }

    @GetMapping("/findActive")
    public List<CarDTO> findActive(boolean avb){
        return carMapper.toDTOList(carService.findByIsUnAvailable(avb));
    }

    @GetMapping("/findAvailable")
    public List<CarDTO> findAvailable(boolean isAvb){
        return carMapper.toDTOList(carService.findByIsAvailable(isAvb));
    }
}
