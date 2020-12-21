package dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Client <T extends Account> {
    @Setter(AccessLevel.NONE)
    private final int id;
    private String firstName;
    private String lastName;
    private T account;

}
