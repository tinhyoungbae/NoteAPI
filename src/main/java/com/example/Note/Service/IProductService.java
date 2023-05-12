package com.example.Note.Service;

import com.example.Note.Model.Price;
import com.example.Note.Model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    public List<Product> getAllProduct();
    public Product addProduct(Product product);
}
