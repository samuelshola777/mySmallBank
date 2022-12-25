package services;

import data.model.Account;
import data.model.User;
import data.repository.BankRepoInterface;
import data.repository.BankRepositoryImpl;
import mySmallBankException.BankServiceExpetionImpl;

import java.security.SecureRandom;

public class BankServicesImpl implements  BankServicesInterface{
    SecureRandom accountNumberGenerator = new SecureRandom();
    BankRepoInterface bankRepository = new BankRepositoryImpl();

    @Override
    public String registerAccount(String accountName, int age) throws BankServiceExpetionImpl {
        Account account = new Account();
       if (age < 18 ){
            throw new BankServiceExpetionImpl("age is not valid");
        }
        if (bankRepository.findByAccountName(accountName) != null ){
            throw new BankServiceExpetionImpl("account already exist ");
        }
        else {

            account.setAge(age);
            account.setName(accountName);
            account.setName(account.getAccountName());
            account.setAge(account.getAge());
         String  accountNumber = String.valueOf(accountNumberGenerator.nextInt(10000,99000));
         account.setAccountNumber(accountNumber);

         bankRepository.creatAccountUser(account);

        }
        return String.format("""
                Account Name : %s \n
                Account Number : %s \n
                
                """, account.getAccountName(),account.getAccountNumber());
    }

    @Override
    public int countAccountUser() {
        return bankRepository.countAccountInBank();
    }
}
