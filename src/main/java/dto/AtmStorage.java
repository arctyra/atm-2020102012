package dto;

public class AtmStorage {
    private CashContainer cashContainer;

    public AtmStorage(CashContainer cashContainer) {
        this.cashContainer = cashContainer;
    }

    public CashContainer getCashContainer() {
        return cashContainer;
    }

    public AtmStorage setCashContainer(CashContainer cashContainer) {
        this.cashContainer = cashContainer;
        return this;
    }
}
