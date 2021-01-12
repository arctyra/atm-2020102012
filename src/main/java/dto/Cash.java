package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static dto.Currency.*;

@AllArgsConstructor
@Getter

public enum Cash {
    RUB_50(1, RUB, 50),
    RUB_100(1, RUB, 50),
    RUB_200(2, RUB, 200),
    RUB_500(3, RUB, 500),
    RUB_1000(4, RUB, 1000),
    RUB_2000(5, RUB, 2000),
    RUB_5000(6, RUB, 5000);

    private final int id;
    private final Currency currency;
    private final int denomination;
}
