package com.ssultan.movieapp.service.account;

import com.ssultan.movieapp.entity.Account;
import com.ssultan.movieapp.reposatiry.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImp implements AccountService {

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
    public Account getAccount(Long accountId) {
        return accountRepo.findById(accountId).get();
    }
}
