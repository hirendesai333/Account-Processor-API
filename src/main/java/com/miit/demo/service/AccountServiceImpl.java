package com.miit.demo.service;


import com.miit.demo.exception.ResourceNotFoundException;
import com.miit.demo.model.Account;
import com.miit.demo.model.Address;
import com.miit.demo.repository.AccountRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class AccountServiceImpl {
    private final AccountRepository accountRepository;
    private Address address;

    public AccountServiceImpl(AccountRepository accountRepository, Address address) {
        this.accountRepository = accountRepository;
        this.address = address;
    }

    public Account save(Account account) {
        address = Address.builder()
                .city(account.getAddress().getCity())
                .country(account.getAddress().getCountry())
                .street(account.getAddress().getStreet())
                .provinceState(account.getAddress().getProvinceState())
                .postalCode(account.getAddress().getPostalCode())
                .build();
        account.setAddress(address);
        return accountRepository.save(account);
    }

    public Account updateAccount(Long accountId, Account updatedAccount) throws ResourceNotFoundException {
        Account update = accountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("Account not found with id: " + accountId));

        update.setFirstName(updatedAccount.getFirstName());
        update.setLastName(updatedAccount.getLastName());
        update.setEmailAddress(updatedAccount.getEmailAddress());
        update.setPassword(updatedAccount.getPassword());
        update.setAddress(updatedAccount.getAddress());
        return accountRepository.save(update);
    }

    public Account findById(Long id) {
        List<Account> accounts = accountRepository.findAll();
        Account account = null;

        for (Account acc : accounts) {
            if (acc.getId().equals(id)) account = acc;
        }
        return account;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public void delete(Account account) {
        accountRepository.delete(account);
    }

    public Optional<Account> findByEmailAddress(String emailAddress) {
        return accountRepository.findByEmailAddress(emailAddress);
    }

}
