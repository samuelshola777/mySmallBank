package data.model;

import dtos.request.AccountRequest;
import mySmallBankException.AccountException;

public class Account  extends User {
    private String accountName;
    private String accountNumber;
    private int balance ;

    private int age;

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    private  User user;

    public Account(User user) {
        this.user = user;
    }
public Account(){}
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

public String deposit(int amountDeposit) throws AccountException {
//    if (accountName == null) throw new
//            AccountException ("please you do not an account ");
//    if (accountNumber == null) throw
//            new AccountException ("please you do not an account ");
    if (accountName == null || accountNumber == null ){
        throw new AccountException("you have to " +
                "" +
                "create an account to perform such transaction");
    }
    if (amountDeposit < 0 )throw new AccountException("you have entered an invalid amount ");
        else {
            balance += amountDeposit;
        }
        return "deposit successfully";
}

    public int withdraw(int withdrawalAmount) throws  AccountException {
//        if (accountName == null) throw new AccountException
//        ("please you do not an account ");
//        if (accountNumber == null) throw new
//        AccountException ("please you do not an account ");
        if (accountName == null || accountNumber == null ){
            throw new AccountException("you have to " +
                    "" +
                    "create an account to perform such transaction");
        }
        if (withdrawalAmount > balance){
            throw new AccountException("insufficient fund ");
        }
        return  balance -= withdrawalAmount ;
    }

//    public String createAccount(AccountRequest accountRequest) {
//        setAccountName(accountRequest.getAccountName());
//        setAccountNumber(accountRequest.getAccountNumber());
//        return "registration successful";
//    }
    public String createAccount(String accountName, String accountNumber) {
        setAccountName(accountName);
        setAccountNumber(accountNumber);
        return "registration successful";
    }

    public int viewBalance() throws AccountException {
        if (accountName == null || accountNumber == null ){
            throw new AccountException("you have to " +
                    "" +
                    "create an account to perform such transaction");
        }
        return getBalance();
    }
    public String toString(){
        return String.format("""
                Account Name : %s \n
                Account Number : %s \n
                Account Balance : %s \n
                Account User Age : %d \n
                """, getName(), getAccountNumber()
        ,getBalance(),getAge());
    }

}
