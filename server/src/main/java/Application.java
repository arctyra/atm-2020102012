import configuration.MyApplicationContextConfiguration;
import dto.Atm;
import dto.Client;
import dto.DebitAccount;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static enums.Cash.*;

@Log4j2
public class Application {

    public static void main(String[] args) {

        log.info("Application has started, time = {}", LocalDateTime::now);

        String inputCardNumber = "1234567812345678";
        String inputPIN = "123";

        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyApplicationContextConfiguration.class);

        Atm atm = ctx.getBean(Atm.class);
        Client<DebitAccount> client = ctx.getBean(Client.class);

        client.setInputCardNumber(inputCardNumber);
        atm.setAuthMethod(client.getAuthMethod());

        if (atm.isAuthenticated(inputPIN)) {
            log.info("Пин-код введён корректно.");

            if (atm.getCash(RUB_1000, 2)) {

                log.info("Баланс до снятия: {}", client.getBalance());

                if (client.receiveMoney(BigDecimal.valueOf(2000))) {
                    log.info("Получены 2000 рублей");
                    log.info("Баланс после снятия: {}", client.getBalance());
                } else {
                    log.info("На счёте недостаточно средств!");
                }
            } else {
               log.info("В банкомате не хватает запрашиваемой суммы денег!");
            }
        } else {
            log.warn("Пин-код введён некорректно!");
        }

        log.info("Application has ended, time = {}", LocalDateTime::now);
    }
}
