package com.example.Note.Service;

import com.example.Note.Model.Price;

import java.util.List;
import java.util.Optional;

public interface IPriceService {
    public List<Price> getAllPrice();
    public Price addPrice(Price price);
}
