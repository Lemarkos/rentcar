package kg.mega.rentcarv2.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
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
    LocalDateTime dateTimeFrom;
    LocalDateTime dateTimeTo;
    Double priceBeforeDiscount;
    Double priceWithDiscount;
}
