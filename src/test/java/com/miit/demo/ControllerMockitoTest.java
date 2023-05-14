package com.miit.demo;

import com.miit.demo.controller.AccountController;
import com.miit.demo.model.Account;
import com.miit.demo.model.Address;
import com.miit.demo.service.AccountServiceImpl;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@SpringBootTest(classes = ControllerMockitoTest.class)
public class ControllerMockitoTest {
    @Mock
    AccountServiceImpl accountService;

    @InjectMocks
    AccountController accountController;

    List<Account> accountList;
    private Account account;

    @Test
    @Order(1)
    public void test_getAllAccounts() {
        accountList = new ArrayList<>();
        accountList.add(new Account(1L, "Hiren", "Desai", "hp.21@gmail.com", "testPass", new Address()));

        when(accountService.getAllAccounts()).thenReturn(accountList);//Mocking
        ResponseEntity<List<Account>> response = accountController.getAllAccount();

        assertEquals(HttpStatus.FOUND, response.getStatusCode());
        assertEquals(1, response.getBody().size());
    }

    @Test
    @Order(2)
    public void test_getAccountById(){
        account = new Account(1L, "Hiren", "Desai", "hp.21@gmail.com", "testPass", new Address());
        Long accountId = 1L;

        when(accountService.findById(accountId)).thenReturn(account);//Mocking
        ResponseEntity<Account> response = accountController.getAccountData(accountId);

        assertEquals(HttpStatus.FOUND, response.getStatusCode());
        assertEquals(1L, account.getId());
    }

    @Test
    @Order(2)
    public void test_deleteAccountById(){
//        account = new Account(1L, "Hiren", "Desai", "hp.21@gmail.com", "testPass", new Address());
        Long accountId = 2L;

        when(accountService.findById(accountId)).thenReturn(account);//Mocking
        ResponseEntity<Account> response = accountController.deleteAccountData(accountId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}
