package dto;

import lombok.*;

import java.math.BigDecimal;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class DebitAccount implements Account{
    private final int id;
    private final String number;
    private final String currency;

    private @Getter @Setter BigDecimal amount;
    private @Setter Card card;

}
