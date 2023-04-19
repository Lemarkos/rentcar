package kg.mega.rentcarv2.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import kg.mega.rentcarv2.enums.Category;
import kg.mega.rentcarv2.enums.Color;
import kg.mega.rentcarv2.enums.EngineType;
import kg.mega.rentcarv2.enums.Transmission;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_car")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String model;
    String photo;
    String description;
    Integer mnfYear;
    Double engineV;
    @Enumerated(value = EnumType.STRING)
    Color color;
    @Enumerated(value = EnumType.STRING)
    EngineType engineType;
    @Enumerated(value = EnumType.STRING)
    Transmission transmission;
    Double consumptionPer100;
    @Enumerated(value = EnumType.STRING)
    Category category;
    @Column(name = "is_available", columnDefinition = "boolean default true")
    Boolean isAvailable = true;
    @ManyToOne
    @JoinColumn(name = "price_id")
    Price price;
    @OneToMany(mappedBy = "car",cascade = CascadeType.ALL)
    List<Order> order;
    @OneToMany(mappedBy = "car",cascade = CascadeType.ALL, orphanRemoval = true)
    List<Discount>discounts;
}
