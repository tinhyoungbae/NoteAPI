package com.example.Note.Service;

import com.example.Note.Model.Price;

import java.util.List;

public interface IPriceService {
    public List<Price> getAllPrice();
    public Price addPrice(int productID, Price price);
}
