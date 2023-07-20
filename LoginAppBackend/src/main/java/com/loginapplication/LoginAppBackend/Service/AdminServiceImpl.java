package com.loginapplication.LoginAppBackend.Service;

import com.loginapplication.LoginAppBackend.Dao.AdminDao;
import com.loginapplication.LoginAppBackend.Dao.UserDao;
import com.loginapplication.LoginAppBackend.Models.Admin;
import com.loginapplication.LoginAppBackend.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private UserDao userDao;

    @Override
    public Admin validate(String uname, String password, String securityCode) {
        Admin admin = adminDao.findByUsernameAndPassword(uname,password);

        if(admin.getSecurityCode().equals(securityCode))
        {
            return admin;
        }

        return null;
    }

    @Override
    public boolean changeStatus(String uname) {
        User u = userDao.findByUsername(uname);

        if(u != null){
            u.setStatus("Valid");
            userDao.save(u);
            return true;
        }

        return false;
    }
}
