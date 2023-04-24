package kg.mega.rentcarv2.service.impl;

import kg.mega.rentcarv2.dto.OrderDTO;
import kg.mega.rentcarv2.mapper.OrderMapper;
import kg.mega.rentcarv2.model.*;
import kg.mega.rentcarv2.repositories.OrderRepo;
import kg.mega.rentcarv2.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final CarService carService;
    private final DiscountService discountService;
    private final AddressService addressService;
    private final OrderMapper orderMapper;
    private final FeignClient feignClient;

    @Override
    public OrderDTO save(Order order) {
        log.info("SAVING ORDER");
        Car car = carService.findById(order.getCar().getId());
        Address getAddress = addressService.findById(order.getGetAddress().getId());
        Address returnAddress = addressService.findById(order.getReturnAddress().getId());
        order.setCar(car);
        order.setGetAddress(getAddress);
        order.setReturnAddress(returnAddress);
        order.setDaysCount(betweenDays(order));
        order.setPriceBeforeDiscount(order.getDaysCount() * car.getPrice().getPrice());
        order.setPriceWithDiscount(getPriceWithDiscount(order,car));
//        feignClient.sendMail(order.getClientEmail(), "Your order", orderMapper.toDTO(order).toString());
        car.setIsAvailable(false);
        orderRepo.save(order);
            return orderMapper.toDTO(order);
    }

    @Override
    public Order update(Order order) {
        Order updated = orderRepo.findById(order.getId()).get();
        updated.setDateFrom(order.getDateFrom() == null ? updated.getDateFrom():order.getDateFrom());
        updated.setDateTo(order.getDateTo() == null ? updated.getDateTo():order.getDateTo());
//        updated.setClientEmail(order.getClientEmail() == null ? updated.getClientEmail(): order.getClientEmail());
        return orderRepo.save(updated);
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
    private int betweenDays(Order order) {
        Duration duration = Duration.between(order.getDateFrom(), order.getDateTo());
        return (int) duration.toDays();
    }

    //Find discount we need
    public double getDiscountById(Long carId, int daysCount) {
        List<Discount> discountList = discountService.findAllByCarIdOrderByDaysCount(carId, daysCount);
        if (discountList != null) {
            Discount discount = discountList.get(0);
            return discount.getDiscount();
        } else {
            return 0;
        }
    }

    //Price with discount

    private double getPriceWithDiscount(Order order, Car car){
        double discount = getDiscountById(car.getId(), order.getDaysCount());
        double priceBeforeDiscount = order.getPriceBeforeDiscount();
        double discountAmount = priceBeforeDiscount * (discount / 100);
        return priceBeforeDiscount - discountAmount;
    }
//    private List<LocalDateTime> getRange(LocalDateTime start, LocalDateTime end){
//        List<LocalDateTime> dateTimes = new ArrayList<>();
//        LocalDateTime date = start;
//        while (!date.isAfter(end)){
//            dateTimes.add(date);
//            date = date.plus(1, ChronoUnit.DAYS);
//        }
//        return dateTimes;
//    }
}
