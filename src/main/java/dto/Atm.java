package dto;

public class Atm {
    private int atmID;
    private AtmStorage atmStorage;

    public Atm(int atmID, AtmStorage atmStorage) {
        this.atmID = atmID;
        this.atmStorage = atmStorage;
    }

    public boolean authentication(AuthMethod authMethod, String checkValue) {
        return authMethod.authenticate(checkValue);
    }

    public int getAtmID() {
        return atmID;
    }

    public Atm setAtmID(int atmID) {
        this.atmID = atmID;
        return this;
    }

    public AtmStorage getAtmStorage() {
        return atmStorage;
    }

    public Atm setAtmStorage(AtmStorage atmStorage) {
        this.atmStorage = atmStorage;
        return this;
    }
}
