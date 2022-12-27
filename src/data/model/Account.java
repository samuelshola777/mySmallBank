package data.model;

import dtos.request.AccountRequest;
import mySmallBankException.AccountException;

public class Account   {
    private String accountName;
    private String accountNumber;
    private int balance ;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;


    public Account(String accountName, String accountNumber, int age) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
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
                \n
                Account Name : %s \n
                Account Number : %s \n
                Account Balance : %s \n
                Account User Age : %d \n
                """, getAccountName(), getAccountNumber()
        ,getBalance(),getAge());
    }



}
