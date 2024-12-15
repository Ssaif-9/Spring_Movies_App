package com.ssultan.movieapp.service.account;

import com.ssultan.movieapp.entity.Account;
import com.ssultan.movieapp.model.requests.LoginRequest;
import com.ssultan.movieapp.model.requests.SigninRequest;
import com.ssultan.movieapp.model.response.LoginResponse;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface AccountService  {

    void addAccount(SigninRequest signinRequest );
    Account getAccountById(Long accountId);

    Map<String, String> login(LoginRequest loginRequest);

}
