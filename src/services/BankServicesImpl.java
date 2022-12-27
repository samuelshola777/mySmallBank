package services;

import data.model.Account;
import data.model.User;
import data.repository.BankRepoInterface;
import data.repository.BankRepositoryImpl;
import mySmallBankException.BankServiceExpetionImpl;

import java.security.SecureRandom;
import java.util.HashMap;

public class BankServicesImpl implements  BankServicesInterface{
    SecureRandom accountNumberGenerator = new SecureRandom();
    BankRepoInterface bankRepository = new BankRepositoryImpl();

    @Override
    public String registerAccount(String accountName, int age)
            throws BankServiceExpetionImpl {
        String accountNumber = String.valueOf(accountNumberGenerator.nextInt(10000, 99000));
        if (age < 18) {
            throw new BankServiceExpetionImpl("age is not valid");
        }
       if (findAccountWithName(accountName) != null ){
            throw new BankServiceExpetionImpl("account already exist ");
        }
        else {
Account account1 = new Account(accountName, accountNumber, age);
            bankRepository.creatAccountUser(account1);
            return "successful";

        }
    }



    @Override
    public int countAccountUser() {
        return bankRepository.countAccountInBank();
    }

    @Override
    public Account findAccountWithName(String accountName) {
        return bankRepository.findByAccountName(accountName);
    }

    @Override
    public String deleteAccountByName(String accountName) throws BankServiceExpetionImpl {
        if (findAccountWithName(accountName) == null){
            throw new BankServiceExpetionImpl("account does not exist");
        }
        return bankRepository.deleteAccountByAccountName(accountName);
    }

    @Override
    public String updateAccountUserAge(String accountName, int age) throws BankServiceExpetionImpl {
        if (findAccountWithName(accountName) == null){
            throw new BankServiceExpetionImpl("account does not exist");
        }
        if (age < 18){
            throw new BankServiceExpetionImpl("you have entered an invalid age");
        }

        return bankRepository.changeAccountAge(age,accountName);
    }

    @Override
    public HashMap<String, Account> viewAllAccount() {
        return bankRepository.viewAllAccount();
    }

}
