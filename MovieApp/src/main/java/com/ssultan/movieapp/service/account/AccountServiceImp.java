package com.ssultan.movieapp.service.account;

import com.ssultan.movieapp.entity.Account;
import com.ssultan.movieapp.exception.InvalidAccountDataException;
import com.ssultan.movieapp.model.UserPrincipal;
import com.ssultan.movieapp.reposatiry.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImp implements AccountService  {

    private final AccountRepo accountRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder(12);

    @Autowired
    public AccountServiceImp(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;

    }


    @Override
    public void addAccount(Account account) {
        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
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
            System.out.println("Invalid username or password.");
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new UserPrincipal(account);
    }

}
