package com.example.Note.Service;

import com.example.Note.Model.Product;
import com.example.Note.Model.ResponseModel.Response;
import com.example.Note.Repository.ProductRepo;
import com.example.Note.Status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    ProductRepo productRepo;
    public ResponseEntity<Response> saveProductToDB(Product product, MultipartFile file, String productName)
    {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        product.setImage(file.getOriginalFilename());
        product.setProductName(productName);
        productRepo.save(product);
        return ResponseEntity.status(HttpStatus.OK).body(
                new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> add a product", product)
        );
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public Product getProduct(int productID) {
        Optional<Product> productOptional = productRepo.findById(productID);
        return productOptional.get();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }
}
