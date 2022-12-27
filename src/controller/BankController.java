package controller;

import data.model.Account;
import mySmallBankException.BankServiceExpetionImpl;
import services.BankServicesImpl;
import services.BankServicesInterface;

import java.util.HashMap;

public class BankController {
    BankServicesInterface bankServicesInterface = new BankServicesImpl();

    public String registerForAccount(String accountName, int age) throws BankServiceExpetionImpl {
        return bankServicesInterface.registerAccount(accountName, age);
    }
    public Account findAccountByName(String name){
        return bankServicesInterface.findAccountWithName(name);
    }
    public String deleteAccontByAccountName(String accountName) throws BankServiceExpetionImpl {
        return bankServicesInterface.deleteAccountByName(accountName);
    }
    public String changeAccountAgeByAccountName(String accountName, int age) throws BankServiceExpetionImpl {
        return bankServicesInterface.updateAccountUserAge(accountName, age);
    }
    public int countNumberOfAccount(){
        return bankServicesInterface.countAccountUser();
    }

   public HashMap<String, Account> viewAllAccount(){
        return bankServicesInterface.viewAllAccount();
    }
}
