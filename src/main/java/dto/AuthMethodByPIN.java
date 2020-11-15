package dto;

public class AuthMethodByPIN implements AuthMethod{

    private String valuePIN;

    @Override
    public boolean authenticate(String checkValue) {
        return valuePIN.equals(checkValue);
    }

    public AuthMethodByPIN(String valuePIN) {
        this.valuePIN = valuePIN;
    }

}
