package com.example.Note.Controller.PaymentController;

import com.example.Note.Model.PaymentModel.creditCard;
import com.example.Note.Model.ResponseModel.Response;
import com.example.Note.Service.PaymentService.creditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class creditCardController {
    @Autowired
    creditCardService creditCardService;


    // return list User account
    @GetMapping("/creditCard")
    public ResponseEntity<Response> getCreditCardList(){
        return creditCardService.getCreditCardList();
    }

    // add an user
    @PutMapping("/creditCard/{userID}")
    public ResponseEntity<Response> addCreditCard(@PathVariable int userID, @RequestBody creditCard creditCard){
        return creditCardService.addCreditCard(userID, creditCard);
    }

    // find an user
    @GetMapping("/creditCard/{creditCardID}")
    public ResponseEntity<Response> getCreditCardByNumber(@PathVariable int creditCardID){
        return creditCardService.getCreditCardByID(creditCardID);
    }

    // update an user
    @PutMapping("/creditCard")
    public ResponseEntity<Response> updateCreditCard(@RequestBody creditCard creditCard){
        return creditCardService.updateCreditCard(creditCard);
    }

    // delete an user
    @DeleteMapping("/creditCard/{creditCardNumber}")
    public ResponseEntity<Response> deleteCreditCard(@PathVariable int creditCardID) {
        return creditCardService.deleteCreditCard(creditCardID);
    }
}
