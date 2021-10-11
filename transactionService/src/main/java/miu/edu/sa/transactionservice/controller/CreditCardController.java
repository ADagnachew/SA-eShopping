package miu.edu.sa.transactionservice.controller;

import miu.edu.sa.transactionservice.Model.CreditCard;
import miu.edu.sa.transactionservice.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditCardController {
    @Autowired
    private CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @PostMapping("/cc/pay")
    public CreditCard creditCardPayment(){
        return creditCardService.paymentProcess();
    }
}
