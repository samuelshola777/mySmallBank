package services;

import mySmallBankException.BankServiceExpetionImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BankServicesImplTest {
BankServicesInterface bankServicesInterface;
    @BeforeEach
    @Test
    void setUp() {
        bankServicesInterface = new BankServicesImpl();
    }

    @Test
    void testThatAccountCanBeCreated() throws BankServiceExpetionImpl {
        bankServicesInterface.registerAccount("samuel", 18);
        bankServicesInterface.registerAccount("samBone",30);

        assertEquals(2, bankServicesInterface.countAccountUser());
    }
    @Test
    void testThatWeCanFindAccountWithAccountName() throws BankServiceExpetionImpl {
        bankServicesInterface.registerAccount("boneshaker",20);
        bankServicesInterface.registerAccount("boneshake",20);
        bankServicesInterface.registerAccount("samBone",30);
        bankServicesInterface.registerAccount("daniel", 27);
        assertEquals(4, bankServicesInterface.countAccountUser());
        assertEquals("boneshaker", bankServicesInterface.
                findAccountWithName("boneshaker").getAccountName());
        assertEquals(4, bankServicesInterface.countAccountUser());

    }
    @Test
    void testThatweCanDeleteAccountByAccountName() throws BankServiceExpetionImpl {
        bankServicesInterface.registerAccount("boneshaker",20);
        bankServicesInterface.registerAccount("boneshake",20);
        bankServicesInterface.registerAccount("samBone",30);
        bankServicesInterface.registerAccount("daniel", 27);
        assertEquals(4, bankServicesInterface.countAccountUser());
        bankServicesInterface.deleteAccountByName("boneshake");
        assertEquals(3, bankServicesInterface.countAccountUser());
    }
    @Test
    void testThatWeCanChangeAccountAgeByAccountName() throws BankServiceExpetionImpl {
        bankServicesInterface.registerAccount("boneshaker",20);
        bankServicesInterface.registerAccount("boneshake",20);
        bankServicesInterface.registerAccount("samBone",30);
        bankServicesInterface.registerAccount("daniel", 27);
        assertEquals(4, bankServicesInterface.countAccountUser());
        bankServicesInterface.updateAccountUserAge("samBone", 34);
        assertEquals(34, bankServicesInterface.findAccountWithName("samBone").getAge());
    }
}