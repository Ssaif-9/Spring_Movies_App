package com.ssultan.movieapp.controller;

import com.ssultan.movieapp.entity.Account;
import com.ssultan.movieapp.exception.ErrorException;
import com.ssultan.movieapp.exception.InvalidAccountDataException;
import com.ssultan.movieapp.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/login")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{accountId}")
    public Account getAccountById(@PathVariable Long accountId) {
        return accountService.getAccountById(accountId);
    }

    @PostMapping
    public void createAccount(@RequestBody Account account) {
        accountService.addAccount(account);
    }

    @ExceptionHandler(value = InvalidAccountDataException.class)
    ErrorException getInvalidAccountDataException(InvalidAccountDataException invalidAccountDataException) {
        return new ErrorException(invalidAccountDataException.getExceptionMessage(),invalidAccountDataException.getExceptionCode());
    }
}
