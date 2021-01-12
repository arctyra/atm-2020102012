package services;

import dto.Card;
import dto.Client;
import dto.DebitAccount;

import java.math.BigDecimal;
import java.time.LocalDate;

import static dto.Currency.*;

public class ClientFactoryService {
    public static Client<DebitAccount> createDebitAccountClient() {
        Card card = new Card(
                1,
                "1234567812345678",
                LocalDate.of(2020,12,31),
                valuePIN -> valuePIN.equals("123")
        );

        DebitAccount debitAccount = new DebitAccount(
                1,
                "123456789",
                RUB,
                new BigDecimal(10000), card
        );

        return new Client<>(
                1,
                "Иван",
                "Иванов",
                debitAccount
        );

    }
}
