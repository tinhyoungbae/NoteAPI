package com.example.Note.Service;

import com.example.Note.Model.Price;
import com.example.Note.Model.Product;
import com.example.Note.Model.ResponseModel.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    public List<Product> getAllProduct();
    public Product addProduct(Product product);
    public ResponseEntity<Response> saveProductToDB(Product product, MultipartFile file, String productName);
}
