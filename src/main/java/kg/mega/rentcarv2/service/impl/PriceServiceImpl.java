package kg.mega.rentcarv2.service.impl;

import kg.mega.rentcarv2.model.Price;
import kg.mega.rentcarv2.repositories.PriceRepo;
import kg.mega.rentcarv2.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {
    private final PriceRepo priceRepo;
    @Override
    public void save(Price price) {
        price.setStartDate(LocalDateTime.now());
        price.setEndDate(LocalDateTime.now().plusYears(100));
        priceRepo.save(price);
    }

    @Override
    public Price findById(Long id) {
        return priceRepo.findById(id).get();
    }
}
