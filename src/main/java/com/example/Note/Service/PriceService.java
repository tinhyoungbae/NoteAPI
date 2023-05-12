package com.example.Note.Service;

import com.example.Note.Model.Price;
import com.example.Note.Repository.PriceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceService implements IPriceService{
    @Autowired
    PriceRepo priceRepo;
    @Override
    public List<Price> getAllPrice() {
        return priceRepo.findAll();
    }

    @Override
    public Price addPrice(Price price) {
        return priceRepo.save(price);
    }
}
