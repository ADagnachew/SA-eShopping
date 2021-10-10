package miu.edu.sa.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private int id;
    private String paymentStatus;
    private String transactionId;
    private String paymentMethod;
    private double amount;
}