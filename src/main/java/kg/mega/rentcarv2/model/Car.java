package kg.mega.rentcarv2.model;

import com.fasterxml.jackson.annotation.*;
import kg.mega.rentcarv2.enums.Category;
import kg.mega.rentcarv2.enums.Color;
import kg.mega.rentcarv2.enums.EngineType;
import kg.mega.rentcarv2.enums.Transmission;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_car")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
    @OneToMany(mappedBy = "car",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @JsonManagedReference
    List<Order> order;
    @OneToMany(mappedBy = "car",cascade = CascadeType.ALL)
    List<Discount>discounts;
//    @ManyToMany
//    @JoinTable(name = "tb_car_tb_reserved",
//            joinColumns = @JoinColumn(name = "car_id"),
//            inverseJoinColumns = @JoinColumn(name = "reserved_id"))
//    List<Reserved> reservedList;
}
