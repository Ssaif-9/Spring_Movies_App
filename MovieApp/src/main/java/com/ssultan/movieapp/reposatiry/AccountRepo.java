package com.ssultan.movieapp.reposatiry;

import com.ssultan.movieapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

    Account findByUsername(String username);
    Account findByUsernameAndPassword(String username, String password);

}
