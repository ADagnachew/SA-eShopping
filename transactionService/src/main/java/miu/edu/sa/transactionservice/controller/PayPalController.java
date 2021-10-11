package miu.edu.sa.transactionservice.controller;

import miu.edu.sa.transactionservice.Model.PayPal;
import miu.edu.sa.transactionservice.service.PayPalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayPalController {
    @Autowired
    private PayPalService payPalService;

    public PayPalController(PayPalService payPalService) {
        this.payPalService = payPalService;
    }

    @PostMapping("/paypal/pay")
    public PayPal payPalPayment(){
        return payPalService.paymentProcess();
    }
}
