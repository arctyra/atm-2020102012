import dto.*;
import lombok.extern.log4j.Log4j2;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Log4j2
public class Application {

    public static void main(String[] args) {

        log.info("Application has started, time = {}", LocalDateTime::now);

        AuthMethod authMethodByPIN = valuePIN -> valuePIN.equals("123");
        Card card = new Card(1,"1234567812345678", LocalDate.of(2020,12,31), authMethodByPIN);
        DebitAccount debitAccount = new DebitAccount(1, "123456789", "RUB", new BigDecimal(10000), card);
        Client<DebitAccount> client = new Client<>(1, "Иван", "Иванов", debitAccount);

        Host host = new Host();

        CashContainer cashContainer = new CashContainer(1, "RUB", 1000, 500, 500);
        AtmStorage atmStorage = new AtmStorage(1, cashContainer);
        Atm atm = new Atm(1, atmStorage, host);
        atm.setAuthMethod(client.getAccount().getCard().getAuthMethod());

        if (atm.isAuthenticated("123")) {
            log.info("Пин-код введён корректно.");

            if (atm.getAtmStorage().getCashContainer().getCash(2)) {

                log.info("Баланс до снятия: {}", client.getAccount().getAmount());

                BigDecimal newAmount = client.getAccount().getAmount().subtract(BigDecimal.valueOf(2000));

                client.getAccount().setAmount(newAmount);

                log.info("Получены 2000 рублей");

                log.info("Баланс после снятия: {}", client.getAccount().getAmount());
            } else {
               log.info("В банкомате не хватает запрашиваемой суммы денег!");
            }

        } else {
            log.warn("Пин-код введён некорректно!");
        }

        log.info("Application has ended, time = {}", LocalDateTime::now);
    }
}
