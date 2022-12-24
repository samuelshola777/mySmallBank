package data.repository;

import dtos.request.AccountRequest;
import dtos.responce.AccountResponce;

public interface AccountRepoInterface {

    AccountResponce deposit(AccountRequest accountRequest);


}
