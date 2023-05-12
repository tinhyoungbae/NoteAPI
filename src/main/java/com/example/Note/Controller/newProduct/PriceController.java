package com.example.Note.Controller.newProduct;

import com.example.Note.Model.Price;
import com.example.Note.Service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PriceController {
    @Autowired
    PriceService priceService;

    @GetMapping("/price")
    public List<Price> getAllPrice(){
        return priceService.getAllPrice();
    }
    @PostMapping("/price")
    public Price addPrice(@RequestBody Price price){
        return priceService.addPrice(price);
    }
}
