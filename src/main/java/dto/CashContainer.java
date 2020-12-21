package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CashContainer {
    private final int id;
    private final String currency;
    private final int denomination;
    private final int maxCapacity;
    private int itemsCount;

    public boolean getCash(int count) {
        if (itemsCount >= count) {
            itemsCount -= count;
            return true;
        } else {
            return false;
        }
    }
}
