package data.repository;

import data.model.Account;

import java.util.HashMap;

public interface BankRepoInterface {

    String creatAccountUser(Account account);

    Account findByAccountName(String accountName);
    int countAccountInBank();
    String deleteAccountByAccountName(String accountName);

  String changeAccountAge(int age, String accountName);
  HashMap<String, Account> viewAllAccount();
}
