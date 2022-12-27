package data.model;


public class Bank {

    private Account account;
    private User user;
    public Bank() {
    }

    public Bank(Account account, User user) {
        this.account = account;
        this.user = user;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
