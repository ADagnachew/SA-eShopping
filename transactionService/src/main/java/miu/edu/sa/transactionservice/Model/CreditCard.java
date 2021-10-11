package miu.edu.sa.transactionservice.Model;

import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard {

//    @Id
//    @GeneratedValue
//    private Long Id;
    private Long cardNumber;
    private Long cvs;
}
