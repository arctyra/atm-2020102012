package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Currency {
    RUB(1),
    USD(2),
    EUR(3);

    private final int id;
}
