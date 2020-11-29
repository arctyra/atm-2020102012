import dto.*;

import java.math.BigDecimal;
import java.sql.Date;

public class Application {
    public static void main(String[] args) {

        AuthMethod authMethodByPIN = new AuthMethodByPIN("123");
        Card card = new Card("1234 5678 1234 5678", Date.valueOf("2020-12-31"), authMethodByPIN);
        Account account = new Account(1, new BigDecimal("10000"), "RUB", card);
        Client client = new Client(1, "Иван", "Иванов", account);


        CashContainer cashContainer = new CashContainer(1, "RUB", 1000, 500, 500);
        AtmStorage atmStorage = new AtmStorage(cashContainer);
        Atm atm = new Atm(1, atmStorage);

        if (atm.authentication(client.getAccount().getCard().getAuthMethod(), "123")) {
            System.out.println("Пин-код введён корректно.");

            if (atm.getAtmStorage().getCashContainer().getCash(2)) {

                System.out.println("Баланс до снятия: " + client.getAccount().getAmount());

                BigDecimal newAmount = client.getAccount().getAmount().subtract(BigDecimal.valueOf(2000));

                client.getAccount().setAmount(newAmount);

                System.out.println("Получены 2000 рублей");

                System.out.println("Баланс после снятия: " + client.getAccount().getAmount());
            } else {
                System.out.println("В банкомате не хватает запрашиваемой суммы денег!");
            }

        } else {
            System.out.println("Пин-код введён некорректно!");
        }


    }
}
