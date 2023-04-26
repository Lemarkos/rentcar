package kg.mega.rentcarv2.util;

import kg.mega.rentcarv2.model.Car;
import kg.mega.rentcarv2.model.Order;
import kg.mega.rentcarv2.repositories.CarRepo;
import kg.mega.rentcarv2.repositories.OrderRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class CarStatusChecker {
    private final OrderRepo orderRepo;
    private final CarRepo carRepo;

    public CarStatusChecker(OrderRepo orderRepo, CarRepo carRepo) {
        this.orderRepo = orderRepo;
        this.carRepo = carRepo;
    }

    @Scheduled(fixedDelay = 60000)
    @Transactional
    public void statusUpdater() {
        log.info("Checking status...");
        List<Order> orders = orderRepo.findAllByDateToLessThanEqual(LocalDateTime.now());
        for (Order order : orders) {
            Car car = order.getCar();
            car.setIsAvailable(true);
            carRepo.save(car);
        }
    }
}