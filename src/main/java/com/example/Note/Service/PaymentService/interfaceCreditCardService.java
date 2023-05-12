package com.example.Note.Service.PaymentService;

import com.example.Note.Model.PaymentModel.creditCard;
import com.example.Note.Model.ResponseModel.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

public interface interfaceCreditCardService{
    public ResponseEntity<Response> getCreditCardList();
    public ResponseEntity<Response> getCreditCardByID(int creditCardID);
    public ResponseEntity<Response> addCreditCard(creditCard creditCard);
    public ResponseEntity<Response> updateCreditCard(creditCard creditCard);
    public ResponseEntity<Response> deleteCreditCard(int creditCardID);
}
