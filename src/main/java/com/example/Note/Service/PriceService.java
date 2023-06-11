package com.example.Note.Service;

import com.example.Note.Model.Price;
import com.example.Note.Model.Product;
import com.example.Note.Repository.PriceRepo;
import com.example.Note.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService implements IPriceService{
    @Autowired
    PriceRepo priceRepo;
    @Autowired
    ProductRepo productRepo;
    @Override
    public List<Price> getAllPrice() {
        return priceRepo.findAll();
    }

    @Override
    public Price addPrice(int productID, Price price) {
        Product product = productRepo.findById(productID).get();
        price.setProduct(product);
        return priceRepo.save(price);
    }
}
