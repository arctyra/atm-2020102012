package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.time.LocalDate;
import java.util.function.Predicate;

@AllArgsConstructor
@Getter
public class Card {
    private final int id;
    @CreditCardNumber
    private final String cardNumber;
    private final LocalDate expireDate;
    @Setter
    private Predicate<String> authMethod;

}
