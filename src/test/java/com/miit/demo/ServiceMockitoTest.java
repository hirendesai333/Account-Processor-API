package com.miit.demo;

import com.miit.demo.model.Account;
import com.miit.demo.model.Address;
import com.miit.demo.repository.AccountRepository;
import com.miit.demo.service.AccountServiceImpl;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@SpringBootTest(classes = {ServiceMockitoTest.class})
public class ServiceMockitoTest {
    @Mock
    AccountRepository accountRepository;
    @InjectMocks
    AccountServiceImpl accountService;

    public Account account;

    @BeforeEach
    public void setup(){

        account = Account.builder()
                .password("TestPass")
                .address(new Address())
                .id(1L)
                .lastName("Desai")
                .firstName("Hiren")
                .emailAddress("hd.2@gmail.com")
                .build();
    }



    @Test
    @Order(1)
    void test_getAllAccounts() {
        when(accountRepository.findAll()).thenReturn(List.of(account));//Mocking
        assertEquals(1, accountService.getAllAccounts().size());
    }

    @Test
    @Order(2)
    public void test_getAccountById() {
        Long accountId = 1L;

        when(accountRepository.findAll()).thenReturn(List.of(account));
        assertEquals(1L, accountService.findById(accountId).getId());
    }

    @Test
    public void test_findByEmailAddress(){
        when(accountRepository.findByEmailAddress(account.getEmailAddress())).thenReturn(Optional.of(account));
        assertEquals("hd.2@gmail.com", accountService.findByEmailAddress("hd.2@gmail.com").get().getEmailAddress());
    }
}
