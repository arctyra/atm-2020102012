package dto;

public class CashContainer {
    private int containerID;
    private String currency;
    private int denomination;
    private int maxCapacity;
    private int itemsCount;

    public CashContainer(int containerID, String currency, int denomination, int maxCapacity, int itemsCount) {
        this.containerID = containerID;
        this.currency = currency;
        this.denomination = denomination;
        this.maxCapacity = maxCapacity;
        this.itemsCount = itemsCount;
    }

    public boolean getCash(int count) {
        if (itemsCount >= count) {
            itemsCount -= count;
            return true;
        } else {
            return false;
        }
    }
}
