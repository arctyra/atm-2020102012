package dto;

public class Client {
    private int clientID;
    private String firstName;
    private String lastName;
    private Account account;

    public Client(int clientID, String firstName, String lastName, Account account) {
        this.clientID = clientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
    }

    public int getClientID() {
        return clientID;
    }

    public Client setClientID(int clientID) {
        this.clientID = clientID;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Client setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Client setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Account getAccount() {
        return account;
    }

    public Client setAccount(Account account) {
        this.account = account;
        return this;
    }
}
