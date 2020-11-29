package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Client {
    private @Getter final int clientID;
    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;
    private @Getter @Setter Account account;

}
