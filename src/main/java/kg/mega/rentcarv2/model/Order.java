package kg.mega.rentcarv2.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Table(name = "tb_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
//    @JsonBackReference
    Car car;
    Boolean babySeat;
    Boolean withDriver;
    String clientName;
    String clientEmail;
    @ManyToOne
    @JoinColumn(name = "get_Address_id")
    Address getAddress;
    @ManyToOne
    @JoinColumn(name = "return_Address_id")
    Address returnAddress;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    LocalDateTime dateFrom;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    LocalDateTime dateTo;
    Integer daysCount;
    Double priceBeforeDiscount;
    Double priceWithDiscount;
}
