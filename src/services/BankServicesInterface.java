package services;

import mySmallBankException.BankServiceExpetionImpl;

public interface BankServicesInterface {
String registerAccount(String accountName, int age) throws BankServiceExpetionImpl;
    int countAccountUser();
}
