package dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.math.BigDecimal;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class DebitAccount implements Account{
    private final int id;

    private final String number;
    private final Currency currency;

    @Setter
    @PositiveOrZero(message = "must be greater than or equal to 0")
    private  BigDecimal amount;

    @Setter
    private Card card;

    @Override
    public Card getCard(@NotNull String cardNumber) {
        return card;
    }

    @Override
    public boolean withdrawAmount(@Positive BigDecimal amount) {
        if (amount.compareTo(this.amount) > 0) {
            return false;
        }
        this.amount = this.amount.subtract(amount);
        return true;
    }


}
