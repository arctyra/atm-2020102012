package dto;

import enums.Cash;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CashContainer {
    private final int id;
    private final Cash cash;
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
