package com.miit.demo.repository;

import com.miit.demo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    /*<S extends Account> S save(S account);

    Optional<Account> findById(Long id);*/

    Optional<Account> findByEmailAddress(String emailAddress);

}