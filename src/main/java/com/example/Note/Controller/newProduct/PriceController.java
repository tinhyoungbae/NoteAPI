package com.example.Note.Controller.newProduct;

import com.example.Note.Model.Price;
import com.example.Note.Service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PriceController {
    @Autowired
    PriceService priceService;

    @GetMapping("/price")
    public List<Price> getAllPrice(){
        return priceService.getAllPrice();
    }

    @PutMapping("/price/{productID}")
    public Price addPrice(@PathVariable int productID, @RequestBody Price price){
        return priceService.addPrice(productID, price);
    }
}
