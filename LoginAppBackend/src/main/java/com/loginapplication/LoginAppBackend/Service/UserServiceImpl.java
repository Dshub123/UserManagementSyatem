package com.loginapplication.LoginAppBackend.Service;

import com.loginapplication.LoginAppBackend.Dao.UserDao;
import com.loginapplication.LoginAppBackend.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao logindao;

    @Override
    public User addNewUser(User user) {
        return logindao.save(user);
    }

    @Override
    public User validateCredentials(String uname, String password) {
        return logindao.findByUsernameAndPassword(uname,password);
    }

    @Override
    public User getByUsername(String uname) {
        return logindao.findByUsername(uname);
    }

    @Override
    public User updateUser(User user, String uname) {
        if(logindao.findByUsername(uname) != null){
            logindao.save(user);
            return user;
        }

        return null;
    }

    @Override
    public List<User> allUsers() {
        return logindao.findAll();
    }


}
