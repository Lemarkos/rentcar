package kg.mega.rentcarv2.service.impl;

import kg.mega.rentcarv2.model.Address;
import kg.mega.rentcarv2.model.Car;
import kg.mega.rentcarv2.model.Discount;
import kg.mega.rentcarv2.model.Order;
import kg.mega.rentcarv2.repositories.OrderRepo;
import kg.mega.rentcarv2.service.AddressService;
import kg.mega.rentcarv2.service.CarService;
import kg.mega.rentcarv2.service.DiscountService;
import kg.mega.rentcarv2.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final CarService carService;
    private final DiscountService discountService;
    private final AddressService addressService;

    @Override
    public Order save(Order order) {
        Car car = carService.findById(order.getCar().getId());
        Address getAddress = addressService.findById(order.getGetAddress().getId());
        Address returnAddress = addressService.findById(order.getReturnAddress().getId());
        order.setCar(car);
        order.setGetAddress(getAddress);
        order.setReturnAddress(returnAddress);
        order.setDaysCount(betweenDays(order));
        order.setPriceBeforeDiscount(order.getDaysCount() * car.getPrice().getPrice());
        order.setPriceWithDiscount(getPriceWithDiscount(order,car));
        car.setIsAvailable(false);
        return orderRepo.save(order);
    }

    @Override
    public Order update(Order order) {
        Order updated = orderRepo.findById(order.getId()).get();
        updated.setDateFrom(order.getDateFrom());
        updated.setDateTo(order.getDateTo());
        return orderRepo.save(order);
    }

    @Override
    public void delete(Long id) {
        orderRepo.deleteById(id);
    }

    @Override
    public Order findById(Long id) {
        return orderRepo.findById(id).get();
    }

    @Override
    public List<Order> findAll() {
        return orderRepo.findAll();
    }

    //days between two dates
    private Integer betweenDays(Order order) {
        Duration duration = Duration.between(order.getDateFrom(), order.getDateTo());
        return (int) duration.toDays();
    }

    public double getDiscountById(Long carId, int daysCount) {
        List<Discount> discountList = discountService.findAllByCarIdOrderByDaysCount(carId, daysCount);
        if (discountList != null && !discountList.isEmpty()) {
            Discount discount = discountList.get(0);
            return discount.getDiscount();
        } else {
            return 0;
        }
    }

    private double getPriceWithDiscount(Order order, Car car){
        double discount = getDiscountById(car.getId(), order.getDaysCount());
        double priceBeforeDiscount = order.getPriceBeforeDiscount();
        double discountAmount = priceBeforeDiscount * (discount / 100);
        return priceBeforeDiscount - discountAmount;
    }
}
