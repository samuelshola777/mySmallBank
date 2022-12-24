package dtos.responce;

public class AccountResponce {
    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getAge() {
        return age;
    }

    public String getMessage() {
        return message;
    }

    private String name;
    private String accountNumber;
    private int age;
    private String message;

    public AccountResponce() {
    }
    public AccountResponce(String message) {
        this.message = message;
    }
}
