package kg.mega.rentcarv2.controller;

import kg.mega.rentcarv2.model.Discount;
import kg.mega.rentcarv2.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/discount")
@RequiredArgsConstructor
public class DiscountController {
    private final DiscountService discountService;
    @PostMapping("/save")
    public ResponseEntity<HttpStatus> save(@RequestBody Discount discount){
        discountService.save(discount);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/findById")
    public Discount findById(@RequestParam Long id){
        return discountService.findById(id);
    }
}
