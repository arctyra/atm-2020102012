package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class CashContainer {
    private @Getter final int containerID;
    private @Getter final String currency;
    private @Getter final int denomination;
    private @Getter final int maxCapacity;
    private @Getter int itemsCount;

    public boolean getCash(int count) {
        if (itemsCount >= count) {
            itemsCount -= count;
            return true;
        } else {
            return false;
        }
    }
}
