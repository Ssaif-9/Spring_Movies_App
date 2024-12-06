package com.ssultan.movieapp.service.account;

import com.ssultan.movieapp.entity.Account;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface AccountService extends UserDetailsService {

    void addAccount(Account account);
    Account getAccountById(Long accountId);
    Account getAccountByEmail(String accountEmail);
    Account getAccountByUsername(String accountUsername);
}
