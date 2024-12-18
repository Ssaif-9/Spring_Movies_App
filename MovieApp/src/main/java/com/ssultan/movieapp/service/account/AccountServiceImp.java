package com.ssultan.movieapp.service.account;

import com.ssultan.movieapp.entity.Account;
import com.ssultan.movieapp.exception.InvalidAccountDataException;
import com.ssultan.movieapp.model.requests.LoginRequest;
import com.ssultan.movieapp.model.requests.SigninRequest;
import com.ssultan.movieapp.reposatiry.AccountRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AccountServiceImp implements AccountService  {

    private final AccountRepo accountRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public AccountServiceImp(AccountRepo accountRepo, ModelMapper modelMapper) {
        this.accountRepo = accountRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addAccount(SigninRequest signinRequest) {
        Account account = modelMapper.map(signinRequest, Account.class);
        accountRepo.save(account);
    }


    @Override
    public Account getAccountById(Long accountId){
        Optional<Account> account = accountRepo.findById(accountId);
        if (account.isEmpty()) {
            throw new InvalidAccountDataException("Not Fount Account With id :"+accountId);
        }
        return accountRepo.findById(accountId).get();
    }


    //Direct Use in Controller
    @Override
    public  Map<String, String> login(LoginRequest loginRequest) {
        Account account =accountRepo.findByUsernameAndPassword(loginRequest.getUsername(),loginRequest.getPassword());
        if (account == null) {
            throw new InvalidAccountDataException("Not Fount Account With id :"+loginRequest.getUsername());
        }else{
            Map<String, String> response = new HashMap<>();
            response.put("username", account.getUsername());
            response.put("role", account.getRole());
            return  response;
        }
    }


}
