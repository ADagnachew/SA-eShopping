package miu.edu.sa.orderservice.service;

import miu.edu.sa.orderservice.dto.OrderRequest;
import miu.edu.sa.orderservice.dto.OrderResponse;
import miu.edu.sa.orderservice.dto.Payment;
import miu.edu.sa.orderservice.model.Order;
import miu.edu.sa.orderservice.proxy.PaymentProxy;
import miu.edu.sa.orderservice.respository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    //private RestTemplate restTemplate;
    private PaymentProxy proxy;

    public OrderService(OrderRepository orderRepository,PaymentProxy proxy) {
        this.orderRepository = orderRepository;
        this.proxy=proxy;
    }


    public OrderResponse placeOrder(OrderRequest orderRequest){

        Order order = orderRequest.getOrder();
        Payment payment = orderRequest.getPayment();
        payment.setPaymentMethod(order.getPaymentMethod());
//        ResponseEntity<Payment> response = restTemplate.postForEntity("http://localhost:9100/payment/makePayment",payment,Payment.class);
//        Payment paymentResponse = response.getBody();

        Payment paymentResponse = proxy.makePayment(payment);

        orderRepository.save(order);

        return new OrderResponse(order,paymentResponse);
    }
}
