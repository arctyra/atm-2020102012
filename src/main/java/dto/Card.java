package dto;

import java.util.Date;

public class Card {
    private String cardNumber;
    private Date expireDate;
    private AuthMethod authMethod;

    public Card(String cardNumber, Date expireDate, AuthMethod authMethod) {
        this.cardNumber = cardNumber;
        this.expireDate = expireDate;
        this.authMethod = authMethod;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Card setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public Card setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
        return this;
    }

    public AuthMethod getAuthMethod() {
        return authMethod;
    }

    public Card setAuthMethod(AuthMethod authMethod) {
        this.authMethod = authMethod;
        return this;
    }
}
