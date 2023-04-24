package kg.mega.rentcarv2.mapper;

import kg.mega.rentcarv2.dto.CarDTO;
import kg.mega.rentcarv2.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface CarMapper{
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    Car toEntity (CarDTO carDTO);
    CarDTO toDTO(Car car);

    List<CarDTO> toDTOList(List<Car> cars);
    List<Car> toEntityList(List<CarDTO> carDetailsDTOS);
}
