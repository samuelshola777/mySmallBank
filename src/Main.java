import controller.BankController;
import data.model.Account;
import mySmallBankException.AccountException;
import mySmallBankException.BankServiceExpetionImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws AccountException, BankServiceExpetionImpl {
  displayMenu();

    }

 static BankController bank = new BankController();
    public static void print(int num){
        System.out.println(num);
    }
    static String name = " ";
    static int age = 0;
    public static int input (){
        Scanner numbe = new Scanner(System.in);
        int num = numbe.nextInt();
        return num;
    }
    public static String inputS(){
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        return word;
    }
    public static void print(String word){
        System.out.println(word);
    }
// the main method string display

    public static void displayMenu() throws BankServiceExpetionImpl, AccountException {
        while (true) {
            String display = """
                                    
                    <<<<<<<<<< WELCOME TO YOUR BANK >>>>>>>>>>>>>>
                                    
                    press 1 To Create An Account >>>>>> \n
                    press 2 to login An Existing Account >>>>>\n
                    press 3 to view the number of account logged in \n
                    press 4 to view all logged in account \n
                    press 5 to exist the Bank App >>>>>>>>>\n
                                    
                    """;
            print(display);
            int responce = input();
            switch (responce) {
                case 1 -> createAccount();
                case 2 -> login();
                case 3 -> countAccount();
                case 4 -> viewAllAccount();

            }
if (responce == 5 ) break;
        }
    }
    public static void viewAllAccount(){
        print(bank.viewAllAccount().toString());
    }
    public static void countAccount(){
        print(bank.countNumberOfAccount());
    }
    public static void login() throws AccountException, BankServiceExpetionImpl {

            print("enter your account Name ");
            String name = inputS();
            if (bank.findAccountByName(name) == null ) {
                print("<<<<<<<<<<<<   account does not exist  >>>>>>>>>>>>> \n\n");
                displayMenu();
            }
                Account account = bank.findAccountByName(name);
            displayAccount(account);

    }
public static void createAccount() throws BankServiceExpetionImpl, AccountException {
   print("**** WELCOME ********\n" +
           "please enter the name you want to use as account name ");
  name = inputS();
  while (true) {
      print("please enter your age, age less than 18 is not valid ");
      age = input();
      if (age < 18 ) continue;
      break;
  }
   bank.registerForAccount(name, age);
    Account account = bank.findAccountByName(name);
    while (true){
    print("Account create your account number is  "+ account.getAccountNumber()+"\n" +
            "<<< press 1 to deposit >>>\n" +
            "<<< press 2 to withdraw >>> \n" +
            "<<< press 3 to view balance >>>\n" +
            "<<< press 4 to view account number >>>\n "+
            "<<< press  400 to go back to the main menu >>> " +
            "");
    int response = input();
    switch (response) {
        case 1:
            print("enter amount to deposit ");
            int deposit = input();
            account.deposit(deposit);
            break;
        case 2:
            print("enter amount to withdraw ");
            int withdraw = input();
            account.withdraw(withdraw);
            break;
        case 3:
            print(account.viewBalance());
            break;
        case 4:
            print(account.getAccountNumber());
            break;
    }
    if (response == 400 ) break;
    }

}
public static void displayAccount(Account account) throws AccountException {
    while (true){
        print(" Welcome to your account  \n" +
                "<<< press 1 to deposit >>>\n" +
                "<<< press 2 to withdraw >>> \n" +
                "<<< press 3 to view balance >>>\n" +
                "<<< press 4 to view account number >>>\n "+
                "<<< press  400 to go back to the main menu >>> " +
                "");
        int response = input();
        switch (response) {
            case 1:
                print("enter amount to deposit ");
                int deposit = input();
                account.deposit(deposit);
                break;
            case 2:
                print("enter amount to withdraw ");
                int withdraw = input();
                account.withdraw(withdraw);
                break;
            case 3:
                print(account.viewBalance());
                break;
            case 4:
                print(account.getAccountNumber());
                break;
        }
        if (response == 400 ) break;
    }

}
}




