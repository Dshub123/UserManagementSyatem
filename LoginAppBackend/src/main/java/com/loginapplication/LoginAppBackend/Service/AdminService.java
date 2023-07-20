package com.loginapplication.LoginAppBackend.Service;

import com.loginapplication.LoginAppBackend.Models.Admin;

public interface AdminService {
    Admin validate(String uname, String password, String securityCode);

    boolean changeStatus(String uname);
}
