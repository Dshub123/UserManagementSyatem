package com.loginapplication.LoginAppBackend.Dao;

import com.loginapplication.LoginAppBackend.Models.Admin;
import com.loginapplication.LoginAppBackend.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDao extends JpaRepository<Admin,String> {

    Admin findByUsernameAndPassword(String uname, String password);
}
