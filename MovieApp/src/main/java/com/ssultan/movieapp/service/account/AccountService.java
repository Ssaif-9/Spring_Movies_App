package com.ssultan.movieapp.service.account;

import com.ssultan.movieapp.entity.Account;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    void addAccount(Account account);
    Account getAccount(Long accountId);
}
