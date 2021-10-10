package miu.edu.sa.service;

import miu.edu.sa.model.Payment;
import miu.edu.sa.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

    Logger logger= LoggerFactory.getLogger(PaymentService.class);

    private PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment makePayment(Payment payment) {

        System.out.println(payment.getPaymentMethod());

        String status = paymentProcess(payment.getPaymentMethod());
        payment.setPaymentMethod(payment.getPaymentMethod());
        payment.setAmount(payment.getAmount());
        payment.setPaymentStatus(status);
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRepository.save(payment);
    }

    public String paymentProcess(String paymentMethod) {

        String creditCard = "credit-card";
        String payPal = "payPal";
        if (creditCard.equals(paymentMethod))
            return "Payment successful using credit card";
        else if (payPal.equals(paymentMethod))
            return "Payment successful using paypal";
        else
            return "Payment unsuccessful unsupported payment type";
    }
}
