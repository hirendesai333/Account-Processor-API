package com.miit.demo;

import com.miit.demo.controller.AccountController;
import com.miit.demo.model.Account;
import com.miit.demo.model.Address;
import com.miit.demo.service.AccountServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ComponentScan(basePackages = "com.miit.demo")
@SpringBootTest(classes = {ControllerMockMvcTests.class})
@SpringBootConfiguration
@RunWith(SpringRunner.class)
public class ControllerMockMvcTests {
//
//    public MockMvc mockMvc;
//
//    @Mock
//    AccountServiceImpl accountService;
//
//    @InjectMocks
//    AccountController accountController;
//
//    List<Account> accountList;
//
//    @BeforeEach
//    public void setUp() {
////        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
//    }
//
//    @Test
//    @Order(1)
//    public void test_getAllAccounts() throws Exception {
////        accountList = new ArrayList<>();
////        accountList.add(new Account(1L, "Hiren", "Desai", "hp.21@gmail.com", "testPass", new Address()));
////
////        when(accountService.getAllAccounts()).thenReturn(accountList);//Mocking
////
////        this.mockMvc.perform(get("/getAll")).andExpect(status().isFound()).andDo(print());
//
//    }

}
