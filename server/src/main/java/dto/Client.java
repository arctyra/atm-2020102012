package dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.function.Predicate;

@RequiredArgsConstructor
@Getter
@Setter
public class Client <T extends Account> {
    @Setter(AccessLevel.NONE)
    private final int id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private T account;

    private String inputCardNumber;

    public Predicate<String> getAuthMethod() {
        return account.getCard(inputCardNumber).getAuthMethod();
    }

    public BigDecimal getBalance() {
        return account.getAmount();
    }

    public boolean receiveMoney(BigDecimal amount) {
        return account.withdrawAmount(amount);
    }
}
