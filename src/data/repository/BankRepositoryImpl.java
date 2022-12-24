package data.repository;

import data.model.User;

import java.util.HashMap;

public class BankRepositoryImpl implements  BankRepoInterface{
    private HashMap<String, User> accountUserList = new HashMap<>();


    @Override
    public String creatAccountUser(User user) {
    accountUserList.put(user.getName(), user);
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
    public User changeAccountAge(int age, String accountName) {
        User userz = findByAccountName(accountName);
        userz.setAge(age);
        return userz;
    }
}
