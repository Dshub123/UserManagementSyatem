package com.loginapplication.LoginAppBackend.Dao;

import com.loginapplication.LoginAppBackend.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, String> {

    //get user by loginid and password
    User findByUsernameAndPassword(String uname, String password);

//    @Query("SELECT FROM User u WHERE u.username=:uname")
//    User getByUsername(@Param("uname") String username);

    User findByUsername(String username);

}
