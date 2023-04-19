package kg.mega.rentcarv2.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import kg.mega.rentcarv2.enums.Category;
import kg.mega.rentcarv2.enums.Color;
import kg.mega.rentcarv2.enums.EngineType;
import kg.mega.rentcarv2.enums.Transmission;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
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
    @JsonIgnore
    Price price;
    @OneToMany(mappedBy = "car",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @JsonManagedReference
    @JsonIgnore
    List<Order> order;
    @OneToMany(mappedBy = "car",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Discount>discounts;
}
