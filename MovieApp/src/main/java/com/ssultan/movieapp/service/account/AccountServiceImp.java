package com.ssultan.movieapp.service.account;

import com.ssultan.movieapp.entity.Account;
import com.ssultan.movieapp.exception.InvalidAccountDataException;
import com.ssultan.movieapp.reposatiry.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImp implements AccountService {

    private final AccountRepo accountRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AccountServiceImp(AccountRepo accountRepo, PasswordEncoder passwordEncoder) {
        this.accountRepo = accountRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void addAccount(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
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

    @Override
    public Account getAccountByEmail(String accountEmail) {
        return accountRepo.findByEmail(accountEmail);
    }

    @Override
    public Account getAccountByUsername(String accountUsername) {
        return accountRepo.findByUsername(accountUsername);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepo.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(account.getRole()));

        return new org.springframework.security.core.userdetails.User(account.getUsername(), account.getPassword(),authorities);
    }

}
