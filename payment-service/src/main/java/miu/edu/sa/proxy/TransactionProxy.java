package miu.edu.sa.proxy;

import miu.edu.sa.dto.CreditCard;
import miu.edu.sa.dto.PayPal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "transaction-service")
public interface TransactionProxy {

    @PostMapping("/cc/pay")
    public CreditCard creditCardPayment();

    @PostMapping("/paypal/pay")
    public PayPal payPalPayment();
}
