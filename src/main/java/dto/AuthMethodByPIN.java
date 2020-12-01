package dto;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
public class AuthMethodByPIN implements AuthMethod{

    private String valuePIN;

    @Override
    public boolean authenticate(String checkValue) {
        return valuePIN.equals(checkValue);
    }


}
