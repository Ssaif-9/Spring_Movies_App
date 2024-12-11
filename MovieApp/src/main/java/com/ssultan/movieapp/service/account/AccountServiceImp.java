package com.ssultan.movieapp.service.account;

import com.ssultan.movieapp.entity.Account;
import com.ssultan.movieapp.exception.InvalidAccountDataException;
import com.ssultan.movieapp.model.requests.LoginRequest;
import com.ssultan.movieapp.model.response.LoginResponse;
import com.ssultan.movieapp.reposatiry.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AccountServiceImp implements AccountService  {

    private final AccountRepo accountRepo;

    @Autowired
    public AccountServiceImp(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;

    }

    @Override
    public void addAccount(Account account) {
        accountRepo.save(account);
    }


    @Override
    public Account getAccountById(Long accountId){
        Optional<Account> account = accountRepo.findById(accountId);
        if (account.isEmpty()) {
            throw new InvalidAccountDataException("Not Fount Account With id :"+accountId,"404");
        }
        return accountRepo.findById(accountId).get();
    }


    //Direct Use in Controller
    @Override
    public  Map<String, String> login(LoginRequest loginRequest) {
        Account account =accountRepo.findByUsernameAndPassword(loginRequest.getUsername(),loginRequest.getPassword());
        if (account == null) {
            throw new InvalidAccountDataException("Not Fount Account With id :"+loginRequest.getUsername(),"404");
        }else{
            Map<String, String> response = new HashMap<>();
            response.put("username", account.getUsername());
            response.put("role", account.getRole());
            return  response;
        }
    }


}
