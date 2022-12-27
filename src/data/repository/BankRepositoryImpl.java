package data.repository;

import data.model.Account;

import java.util.HashMap;

public class BankRepositoryImpl implements  BankRepoInterface{
private HashMap<String, Account> accountUserList = new HashMap<>();
    @Override
    public String creatAccountUser(Account account) {
    accountUserList.put(account.getAccountName(), account);
        return " Account created successfully ";
    }

    @Override
    public Account findByAccountName(String accountName) {
        return accountUserList.get(accountName);
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
        Account account =  findByAccountName(accountName);
        account.setAge(age);
        creatAccountUser(account);

        return "age change  successful";
    }

    @Override
    public HashMap<String, Account> viewAllAccount() {
        for (int i = 0; i < accountUserList.size(); i++) {
            if (accountUserList.size() > 0){
                return accountUserList;
        }
        }
        return null;
    }

}
