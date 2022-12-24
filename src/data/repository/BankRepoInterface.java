package data.repository;

import data.model.User;

public interface BankRepoInterface {

    String creatAccountUser(User user);

    User findByAccountName(String accontName);
    int countAccountInBank();
    String deleteAccountByAccountName(String accountName);

   User changeAccountAge(int age, String accountName);
}
