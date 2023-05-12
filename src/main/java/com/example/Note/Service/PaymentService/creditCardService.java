package com.example.Note.Service.PaymentService;

import com.example.Note.Model.PaymentModel.creditCard;
import com.example.Note.Model.ResponseModel.Response;
import com.example.Note.Model.UserModel.User;
import com.example.Note.Repository.PaymentRepository.interfaceCreditCardRepository;
import com.example.Note.Status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class creditCardService implements interfaceCreditCardService{
    @Autowired
    interfaceCreditCardRepository interfaceCreditCardRepository;
    @Override
    public ResponseEntity<Response> getCreditCardList() {
        List<creditCard> creditCardList = interfaceCreditCardRepository.findAll();
        if(!creditCardList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> got all credit card", creditCardList)
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Response(Status.getStatusError(), Status.getMessageError(), "")
            );
        }
    }

    @Override
    public ResponseEntity<Response> getCreditCardByID(int creditCardID) {
        Optional<creditCard> creditCardOptional = interfaceCreditCardRepository.findById(creditCardID);
        if(creditCardOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> got all credit card", creditCardOptional.get())
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Response(Status.getStatusError(), "There isn't ID credit card = "+creditCardID +" in database. Please try again.", "")
            );
        }
    }

    @Override
    public ResponseEntity<Response> addCreditCard(creditCard creditCard) {
        if (creditCard != null) {
            interfaceCreditCardRepository.save(creditCard);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk(), creditCard)
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new Response(Status.getStatusError(), Status.getMessageError(), "")
        );
    }

    @Override
    public ResponseEntity<Response> updateCreditCard(creditCard creditCard) {
        List<creditCard> creditCardList = interfaceCreditCardRepository.findAll();
        if(!creditCardList.isEmpty()){
            interfaceCreditCardRepository.save(creditCard);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> Updated", creditCardList)
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Response(Status.getStatusError(), "Can not update Account. Please try again.", "")
            );
        }
    }

    @Override
    public ResponseEntity<Response> deleteCreditCard(int creditCardID) {
        Optional<creditCard> creditCardOptional = interfaceCreditCardRepository.findById(creditCardID);
        //getAccount();
        if(creditCardOptional.isPresent()){
            interfaceCreditCardRepository.delete(creditCardOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Response(Status.getStatusOk(), Status.getMessageOk()+" ---> Deleted", getCreditCardList().getBody().getData())
            );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Response(Status.getStatusError(), Status.getMessageError(), getCreditCardList().getBody().getData())
            );
        }
    }
}
