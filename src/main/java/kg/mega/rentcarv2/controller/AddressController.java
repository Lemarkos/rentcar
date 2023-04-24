package kg.mega.rentcarv2.controller;

import kg.mega.rentcarv2.model.Address;
import kg.mega.rentcarv2.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @PostMapping("/save")
    public ResponseEntity<HttpStatus> save(@RequestBody Address address){
        addressService.save(address);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/findById")
    public Address findById(@RequestParam Long id){
        return addressService.findById(id);
    }
}
