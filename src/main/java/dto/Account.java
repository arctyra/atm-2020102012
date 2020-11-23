package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
public class Account {
    private @Getter final int accountNumber;
    private @Getter @Setter BigDecimal amount;
    private @Getter final String currency;
    private @Getter @Setter Card card;

}
