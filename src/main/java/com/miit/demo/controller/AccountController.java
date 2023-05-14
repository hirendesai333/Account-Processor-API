package com.miit.demo.controller;

import com.miit.demo.exception.ResourceNotFoundException;
import com.miit.demo.model.Account;
import com.miit.demo.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Validated
public class AccountController {

    private final AccountServiceImpl accountService;

    @Autowired
    public AccountController(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/add")
    public ResponseEntity<Account> addAccountData(@Valid @RequestBody Account account) {
        try {
            Account save = accountService.save(account);
            return new ResponseEntity<>(save, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Account> updateAccountData(@PathVariable Long id, @RequestBody Account account) throws ResourceNotFoundException {
        try {
            Account accountPost = accountService.updateAccount(id, account);
            return new ResponseEntity<>(accountPost, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Account> getAccountData(@PathVariable("id") Long id) {
        try {
            Account account = accountService.findById(id);
            return new ResponseEntity<>(account, HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<Account> getAccountByEmail(@PathVariable("email") String email) {
        Optional<Account> optionalAccount = accountService.findByEmailAddress(email);
        return optionalAccount.map(account -> new ResponseEntity<>(account, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getAll")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<List<Account>> getAllAccount() {
        try {
            List<Account> accounts = accountService.getAllAccounts();
            return new ResponseEntity<>(accounts, HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Account> deleteAccountData(@PathVariable("id") Long id) {
        Account account;
        try {
            account = accountService.findById(id);
            accountService.delete(account);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
