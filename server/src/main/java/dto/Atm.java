package dto;

import enums.Cash;
import enums.RequestType;
import exceptions.DuplicateRequestException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import java.util.function.Predicate;

@Log4j2
@RequiredArgsConstructor
@Getter
public class Atm {
    private final int id;
    private final AtmStorage atmStorage;
    private final Host host;
    @Setter
    private Predicate<String> authMethod;


    public boolean isAuthenticated(String checkValue) {

        Request r = new Request(RequestType.AUTHENTICATE);

        log.debug("Отправка запроса: {}", r);
        try {
            host.addRequest(r);
        } catch (DuplicateRequestException e) {
            log.warn("Дублирующийся запрос отклонен: {}", r);
            throw new RuntimeException(e);
        }

        return authMethod.test(checkValue);
    }

    public boolean getCash(Cash cash, int amount) {
        return atmStorage.getCashContainer(cash).getCash(amount);
    }
}
