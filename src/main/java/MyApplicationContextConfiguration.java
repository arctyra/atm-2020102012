import dto.Atm;
import dto.AtmStorage;
import dto.CashContainer;
import dto.Host;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static dto.Cash.*;

@Configuration
public class MyApplicationContextConfiguration {

    @Bean
    public static Atm createAtm() {
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
}
