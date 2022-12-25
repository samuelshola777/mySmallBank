package data.repository;

import data.model.Account;
import data.model.User;

import java.util.HashMap;

public class BankRepositoryImpl implements  BankRepoInterface{
private HashMap<String, Account> accountUserList = new HashMap<>();
    @Override
    public String creatAccountUser(Account account) {
    accountUserList.put(account.getAccountName(), account);
        return " Account created successfully ";
    }

    @Override
    public User findByAccountName(String accontName) {
        return accountUserList.get(accontName);
    }


    public int countAccountInBank() {
        return accountUserList.size();
    }

    @Override
    public String deleteAccountByAccountName(String accountName) {
        accountUserList.remove(accountName);
        return "delete successful";
    }

    @Override
    public String changeAccountAge(int age, String accountName) {
        Account account = (Account) findByAccountName(accountName);
        account.setAge(age);
        creatAccountUser(account);

        return "age change  successful";
    }

}
