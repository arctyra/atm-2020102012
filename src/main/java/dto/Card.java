package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class Card {
    private final int id;
    private final String cardNumber;
    private final LocalDate expireDate;
    @Setter
    private AuthMethod authMethod;
}
