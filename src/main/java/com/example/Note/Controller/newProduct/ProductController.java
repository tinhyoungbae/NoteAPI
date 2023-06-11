package com.example.Note.Controller.newProduct;

import com.example.Note.Model.Product;
import com.example.Note.Model.ResponseModel.Response;
import com.example.Note.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/aproduct")
    public ResponseEntity<Response> saveProduct(Product product, @RequestParam(value = "file") MultipartFile file,
                                                @RequestParam("productName") String productName)
    {
        return productService.saveProductToDB(product, file, productName);
    }
}
