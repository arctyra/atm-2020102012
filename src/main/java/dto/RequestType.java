package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RequestType {
    GET_BALANCE(1),
    WITHDRAW_CASH(2);

    private final int id;

}
