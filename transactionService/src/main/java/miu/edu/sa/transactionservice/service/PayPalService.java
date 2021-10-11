package miu.edu.sa.transactionservice.service;

import miu.edu.sa.transactionservice.Model.PayPal;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PayPalService {

    public PayPal paymentProcess(){
        int random = new Random().nextInt() * 99999999;
        String rnd = ""+random;
        return new PayPal(rnd);
    }
}
