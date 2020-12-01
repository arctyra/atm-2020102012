package dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
public class Atm {
    private final int id;
    private final AtmStorage atmStorage;
    @Setter
    private AuthMethod authMethod;

    public boolean authentication(String checkValue) {
        return authMethod.authenticate(checkValue);
    }

}
