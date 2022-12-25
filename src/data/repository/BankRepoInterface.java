package data.repository;

import data.model.Account;
import data.model.User;

public interface BankRepoInterface {

    String creatAccountUser(Account account);

    User findByAccountName(String accontName);
    int countAccountInBank();
    String deleteAccountByAccountName(String accountName);

  String changeAccountAge(int age, String accountName);
}
