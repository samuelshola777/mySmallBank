package data.repository;

import data.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BankRepositoryTest {

    User user = new User();
    BankRepositoryImpl bankRepository;
    @BeforeEach
    @Test
    void setUp(){
        bankRepository = new BankRepositoryImpl();
    }
    @Test
    void testThatUserCanCreateAccount(){
        bankRepository.creatAccountUser(user);
        assertEquals(1, bankRepository.countAccountInBank());
    }
    @Test
    void accountCanBeFoundByAccountName(){
        User user1 = new User();
        user1.setName("daniel");
        User user2 = new User();
        user2.setName("shola");
        User user3 = new User();
        user3.setName("samuel");
        bankRepository.creatAccountUser(user1);
        bankRepository.creatAccountUser(user2);
        bankRepository.creatAccountUser(user3);
        assertEquals(user2, bankRepository.findByAccountName("shola"));
    }
    @Test
    void testThatAccountCanBeDeleted(){
        User user1 = new User();
        user1.setName("daniel");
        User user2 = new User();
        user2.setName("shola");
        User user3 = new User();
        user3.setName("samuel");
        bankRepository.creatAccountUser(user1);
        bankRepository.creatAccountUser(user2);
        bankRepository.creatAccountUser(user3);
        bankRepository.deleteAccountByAccountName("daniel");
        assertEquals(2,bankRepository.countAccountInBank() );
//
    }
    @Test
    void testThatWeCanChangeAccountName(){
        User user1 = new User();
        user1.setName("daniel");
        User user2 = new User();
        user2.setName("shola");
        User user3 = new User();
        user3.setName("samuel");

bankRepository.changeAccountAge(16, "daniel");
assertEquals(16, user1.getAge());
    }




}