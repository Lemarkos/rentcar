package kg.mega.rentcarv2.service;

import kg.mega.rentcarv2.model.Address;

public interface AddressService {
    Address findById(Long id);
    Address save(Address address);
}
