package miu.edu.sa.transactionservice.service;

import miu.edu.sa.transactionservice.Model.CreditCard;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CreditCardService {


    public CreditCard paymentProcess(){
        return new CreditCard(new Random().nextLong() * 999999999,new Random().nextLong()*999);
    }
}
