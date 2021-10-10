package miu.edu.sa.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.sa.orderservice.model.Order;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    private Order order;
    private Payment payment;
}


