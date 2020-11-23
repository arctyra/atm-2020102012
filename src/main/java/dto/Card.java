package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
public class Card {
    private  @Getter final String cardNumber;
    private  @Getter final Date expireDate;
    private  @Getter @Setter AuthMethod authMethod;
}
