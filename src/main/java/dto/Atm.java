package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Atm {
    private @Getter final int atmID;
    private @Getter final AtmStorage atmStorage;

    public boolean authentication(AuthMethod authMethod, String checkValue) {
        return authMethod.authenticate(checkValue);
    }

}
