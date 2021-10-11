package miu.edu.sa.service;

import miu.edu.sa.dto.CreditCard;
import miu.edu.sa.dto.PaymentResponse;
import miu.edu.sa.model.Payment;
import miu.edu.sa.proxy.TransactionProxy;
import miu.edu.sa.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

    Logger logger= LoggerFactory.getLogger(PaymentService.class);

    private PaymentRepository paymentRepository;
    private TransactionProxy proxy;

    public PaymentService(PaymentRepository paymentRepository,TransactionProxy proxy) {
        this.paymentRepository = paymentRepository;
        this.proxy = proxy;
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
        String response = "";
        if (creditCard.equals(paymentMethod)){
            response = proxy.creditCardPayment().toString();
            logger.info("payment processed with Credit card : "+ response);
        }

        else if (payPal.equals(paymentMethod)){
            response = proxy.payPalPayment().toString();
            logger.info("payment processed with Paypal: "+ response);
        }

        else{
            response =  "Payment unsuccessful unsupported payment type";
            logger.info("payment process failed");
        }


        return response;
    }
}
