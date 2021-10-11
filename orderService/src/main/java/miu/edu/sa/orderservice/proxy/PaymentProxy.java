package miu.edu.sa.orderservice.proxy;

import miu.edu.sa.orderservice.dto.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-service")
public interface PaymentProxy {

    @PostMapping("payment/makePayment")
    Payment makePayment(@RequestBody Payment payment);

}
