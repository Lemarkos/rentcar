package kg.mega.rentcarv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableScheduling
@EnableFeignClients
public class RentCarV2Application {

    public static void main(String[] args) {
        SpringApplication.run(RentCarV2Application.class, args);
    }

}
