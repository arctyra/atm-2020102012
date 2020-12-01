import dto.*;
import exceptions.DuplicateRequestException;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {

        AuthMethod authMethodByPIN = new AuthMethodByPIN("123");
        Card card = new Card(1,"1234567812345678", LocalDate.of(2020,12,31), authMethodByPIN);
        Account account = new Account(1, "123456789", new BigDecimal("10000"), "RUB", card);
        Client client = new Client(1, "Иван", "Иванов", account);


        CashContainer cashContainer = new CashContainer(1, "RUB", 1000, 500, 500);
        AtmStorage atmStorage = new AtmStorage(1, cashContainer);
        Atm atm = new Atm(1, atmStorage);
        atm.setAuthMethod(client.getAccount().getCard().getAuthMethod());

        Host host = new Host();

        Request r1 = new Request(RequestType.GET_BALANCE);
        Request r2 = new Request(RequestType.GET_BALANCE);


        if (atm.authentication("123")) {
            System.out.println("Пин-код введён корректно.");

            System.out.println("Отправка запроса: " + r1);
            try {
                host.addRequest(r1);
            } catch (DuplicateRequestException e) {
                System.out.println("Дублирующийся запрос отклонен: " + r1);
            }

            System.out.println("Отправка запроса: " + r2);
            try {
                host.addRequest(r2);
            } catch (DuplicateRequestException e) {
                System.out.println("Дублирующийся запрос отклонен: " + r2);
            }



//            if (atm.getAtmStorage().getCashContainer().getCash(2)) {
//
//                System.out.println("Баланс до снятия: " + client.getAccount().getAmount());
//
//                BigDecimal newAmount = client.getAccount().getAmount().subtract(BigDecimal.valueOf(2000));
//
//                client.getAccount().setAmount(newAmount);
//
//                System.out.println("Получены 2000 рублей");
//
//                System.out.println("Баланс после снятия: " + client.getAccount().getAmount());
//            } else {
//                System.out.println("В банкомате не хватает запрашиваемой суммы денег!");
//            }

        } else {
            System.out.println("Пин-код введён некорректно!");
        }


    }
}
