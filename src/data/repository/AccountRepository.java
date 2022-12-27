package data.repository;

import data.model.Account;
import dtos.request.AccountRequest;
import dtos.responce.AccountResponce;

import java.lang.reflect.Array;

public class AccountRepository implements  AccountRepoInterface{
    Account account = new Account();
    @Override
    public AccountResponce deposit(AccountRequest accountRequest) {
        return new  AccountResponce  ("deposit successfully ");

    }
}
