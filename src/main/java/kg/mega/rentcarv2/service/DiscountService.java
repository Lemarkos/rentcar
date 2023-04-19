package kg.mega.rentcarv2.service;

import kg.mega.rentcarv2.model.Discount;

import java.util.List;

public interface DiscountService {
    List<Discount>findAllByCarIdOrderByDaysCount(Long id, Integer count);
}
