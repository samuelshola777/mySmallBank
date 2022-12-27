package services;

import data.model.Account;
import mySmallBankException.BankServiceExpetionImpl;

import java.util.HashMap;

public interface BankServicesInterface {
String registerAccount(String accountName, int age) throws BankServiceExpetionImpl;
int countAccountUser();

    Account findAccountWithName(String samBone);

    String deleteAccountByName(String accountName) throws BankServiceExpetionImpl;

    String updateAccountUserAge(String accountName, int age) throws BankServiceExpetionImpl;
    HashMap<String, Account> viewAllAccount();
}
