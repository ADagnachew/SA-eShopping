package miu.edu.sa.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String transactionId;
    private String paymentStatus;
    private String paymentMethod;
    private double amount;
}
