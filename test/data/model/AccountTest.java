package data.model;

import mySmallBankException.AccountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    Account account;
    @BeforeEach
    @Test
    void setUp(){
        account = new Account();
    }
    @Test
    void testThatAccountCanBeCreated(){
        account.createAccount("samuel shola","12345");
        assertEquals("samuel shola", account.getAccountName());
        assertEquals("12345", account.getAccountNumber());
    }
    @Test
    void testThatWeCanDepositIntoAccountBalance() throws AccountException {
       account.createAccount("samuel shola","12345");
        account.deposit(2000);
        assertEquals(2000, account.getBalance());
    }
    @Test
    void testThatOurAccountCanWithdraw() throws AccountException {

        account.createAccount("samuel ", "1234");
        account.deposit(2000);
        account.withdraw(500);
        assertEquals(1500, account.getBalance());
    }
    @Test
    void testThatWeCanViewBalance() throws AccountException {
        account.createAccount("samuel shola","12345");
        account.deposit(200);
        assertEquals(200,account.viewBalance());

    }



}