package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RequestType {
    AUTHENTICATE(1),
    GET_BALANCE(2),
    WITHDRAW_CASH(3);

    private final int id;

}
