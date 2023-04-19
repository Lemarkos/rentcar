package kg.mega.rentcarv2.dto;

import kg.mega.rentcarv2.enums.Category;
import kg.mega.rentcarv2.enums.Color;
import kg.mega.rentcarv2.enums.EngineType;
import kg.mega.rentcarv2.enums.Transmission;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@Data
public class CarDTO {
    Long id;
    String model;
    String photo;
    String description;
    Integer mnfYear;
    Double engineV;
    Color color;
    EngineType engineType;
    Transmission transmission;
    Double consumptionPer100;
    Category category;
}
