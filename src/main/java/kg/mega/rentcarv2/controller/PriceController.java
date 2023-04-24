package kg.mega.rentcarv2.controller;

import kg.mega.rentcarv2.model.Price;
import kg.mega.rentcarv2.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/price")
public class PriceController {
    private final PriceService priceService;

    @PostMapping("/save")
    public ResponseEntity<HttpStatus> save(@RequestBody Price price){
        priceService.save(price);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/findById")
    public Price findById(@RequestParam Long id) {
        return priceService.findById(id);
    }
}