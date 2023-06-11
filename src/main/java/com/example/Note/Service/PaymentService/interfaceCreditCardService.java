package com.example.Note.Service.PaymentService;

import com.example.Note.Model.PaymentModel.creditCard;
import com.example.Note.Model.ResponseModel.Response;
import org.springframework.http.ResponseEntity;

public interface interfaceCreditCardService{
    public ResponseEntity<Response> getCreditCardList();
    public ResponseEntity<Response> getCreditCardByID(int creditCardID);
    public ResponseEntity<Response> addCreditCard(int userID, creditCard creditCard);
    public ResponseEntity<Response> updateCreditCard(creditCard creditCard);
    public ResponseEntity<Response> deleteCreditCard(int creditCardID);
}
