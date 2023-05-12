package com.example.Note.Controller.newProduct;

import com.example.Note.Model.Price;
import com.example.Note.Model.Product;
import com.example.Note.Service.PriceService;
import com.example.Note.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product  product){
        return productService.addProduct(product);
    }
}
