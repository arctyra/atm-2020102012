package dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class Account {
    @Setter(AccessLevel.NONE)
    private final int id;
    @Setter(AccessLevel.NONE)
    private final String account;
    private @Getter BigDecimal amount;
    @Setter(AccessLevel.NONE)
    private final String currency;
    private Card card;

}
