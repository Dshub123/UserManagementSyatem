package com.loginapplication.LoginAppBackend.Service;

import com.loginapplication.LoginAppBackend.Models.User;

import java.util.List;

public interface UserService {
    User addNewUser(User user);

    User validateCredentials(String uname, String password);

    User getByUsername(String username);

    User updateUser(User user, String uname);

    List<User> allUsers();
}
