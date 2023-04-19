package kg.mega.rentcarv2.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_price")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double price;
    LocalDateTime startDate;
    LocalDateTime endDate;
}
