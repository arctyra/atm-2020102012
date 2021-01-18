package dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public interface Account {
    Card getCard(@NotNull String cardNumber);
    BigDecimal getAmount();
    boolean withdrawAmount(@Positive BigDecimal amount);
}
