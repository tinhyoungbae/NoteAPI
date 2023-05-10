package com.example.Note.Repository.PaymentRepository;

import com.example.Note.Model.PaymentModel.creditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("creditCard")
public interface interfaceCreditCardRepository extends JpaRepository<creditCard, Integer> {
}
