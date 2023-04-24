package kg.mega.rentcarv2.service.impl;

import kg.mega.rentcarv2.model.Discount;
import kg.mega.rentcarv2.repositories.DiscountRepo;
import kg.mega.rentcarv2.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {
    private final DiscountRepo discountRepo;


    @Override
    public List<Discount> findAllByCarIdOrderByDaysCount(Long id, Integer count) {
        return discountRepo.findAllByCarIdAndDaysCountLessThanEqualOrderByDaysCountDesc(id,count);
    }

    @Override
    public Discount save(Discount discount) {
        return save(discount);
    }

    @Override
    public Discount findById(Long id) {
        return discountRepo.findById(id).get();
    }
}
