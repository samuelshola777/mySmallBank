package data.repository;

import data.model.Account;
import data.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BankRepositoryTest {

    Account account = new Account();
    BankRepositoryImpl bankRepository;
    @BeforeEach
    @Test
    void setUp(){
        bankRepository = new BankRepositoryImpl();
    }
    @Test
    void testThatUserCanCreateAccount(){
        bankRepository.creatAccountUser(account);
        assertEquals(1, bankRepository.countAccountInBank());
    }
    @Test
    void accountCanBeFoundByAccountName(){
      Account account1 = new Account();
      account1.setAccountName("daniel");
      Account account2 = new Account();
      account2.setAccountName("shola");
      Account account3 = new Account();
      account3.setAccountName("samuel");
        bankRepository.creatAccountUser(account1);
        bankRepository.creatAccountUser(account2);
        bankRepository.creatAccountUser(account3);
        assertEquals(account2, bankRepository.findByAccountName("shola"));
        assertEquals(3, bankRepository.countAccountInBank());
    }
    @Test
    void testThatAccountCanBeDeleted(){
        Account account1 = new Account();
        account1.setAccountName("daniel");
        Account account2 = new Account();
        account2.setAccountName("shola");
        Account account3 = new Account();
        account3.setAccountName("samuel");
        bankRepository.creatAccountUser(account1);
        bankRepository.creatAccountUser(account2);
        bankRepository.creatAccountUser(account3);
        bankRepository.deleteAccountByAccountName("daniel");
        assertEquals(2,bankRepository.countAccountInBank() );
//
    }
    @Test
    void testThatWeCanChangeAccountName(){
        Account account1 = new Account();
        account1.setAccountName("daniel");
        Account account2 = new Account();
        account2.setAccountName("shola");
        Account account3 = new Account();
        account3.setAccountName("samuel");
        bankRepository.creatAccountUser(account1);
        bankRepository.creatAccountUser(account2);
        bankRepository.creatAccountUser(account3);
bankRepository.changeAccountAge(16, "daniel");
assertEquals(16, account1.getAge());
assertEquals(3, bankRepository.countAccountInBank());

    }




}