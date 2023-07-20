package com.loginapplication.LoginAppBackend.UserServiceTest;


import com.loginapplication.LoginAppBackend.Dao.UserDao;
import com.loginapplication.LoginAppBackend.Models.User;
import com.loginapplication.LoginAppBackend.Service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserDao userDao;

    @BeforeEach
    void setup(){
        User user = new User(1,"sd","shubham@123","Shubham","DIddi","dob","mobile","add",334,"status");
        Mockito.when(userDao.findByUsername("sd")).thenReturn(user);
    }

    @Test
    public void testGetUserByUsername(){
        String first_name = "Shubham";
        User user = userService.getByUsername("sd");
        Assertions.assertEquals(first_name, user.getFirstName());
    }
}
