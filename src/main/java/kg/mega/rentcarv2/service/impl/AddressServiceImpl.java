package kg.mega.rentcarv2.service.impl;

import kg.mega.rentcarv2.model.Address;
import kg.mega.rentcarv2.repositories.AddressRepo;
import kg.mega.rentcarv2.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepo addressRepo;
    @Override
    public Address findById(Long id) {
        return addressRepo.findById(id).get();
    }
}
