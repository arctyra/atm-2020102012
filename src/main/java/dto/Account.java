package dto;

import java.math.BigDecimal;

public class Account {
    private int accountNumber;
    private BigDecimal amount;
    private String currency;
    private Card card;

    public Account(int accountNumber, BigDecimal amount, String currency, Card card) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.currency = currency;
        this.card = card;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public Account setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Account setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public Account setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public Card getCard() {
        return card;
    }

    public Account setCard(Card card) {
        this.card = card;
        return this;
    }
}
