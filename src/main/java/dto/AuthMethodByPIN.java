package dto;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
public class AuthMethodByPIN implements AuthMethod{

    private @Setter String valuePIN;

    @Override
    public boolean authenticate(String checkValue) {
        return valuePIN.equals(checkValue);
    }


}
