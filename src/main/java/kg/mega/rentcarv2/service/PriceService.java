package kg.mega.rentcarv2.service;


import kg.mega.rentcarv2.model.Price;

public interface PriceService {
    void save(Price price);
    Price findById(Long id);

}
