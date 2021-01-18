package configuration;

import dto.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;

import static enums.Cash.*;
import static enums.Currency.RUB;

@Configuration
public class MyApplicationContextConfiguration {

    @Bean
    public Atm getAtm() {
        Host host = new Host();

        CashContainer cashContainer = new CashContainer(
                1,
                RUB_1000,
                500,
                500
        );

        AtmStorage atmStorage = new AtmStorage(1, cashContainer);

        return new Atm(1, atmStorage, host);
    }

    @Bean(name = "DebitAccountClient")
    public Client<DebitAccount> getDebitAccountClient() {
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
