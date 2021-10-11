package miu.edu.sa.controller;


import miu.edu.sa.model.Payment;
import miu.edu.sa.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment/makePayment")
    public Payment makePayment(@RequestBody Payment payment){
        return paymentService.makePayment(payment);
    }
}
