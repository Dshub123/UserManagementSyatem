package com.loginapplication.LoginAppBackend.Controller;

import com.loginapplication.LoginAppBackend.Models.Admin;
import com.loginapplication.LoginAppBackend.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/loginAppAdmin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/validate")
    public ResponseEntity<Admin> validateAdmin(@RequestBody Admin admin)
    {
        String uname = admin.getUsername();
        String password = admin.getPassword();
        String securityCode = admin.getSecurityCode();
        Admin a = adminService.validate(uname,password,securityCode);

        if(a != null){
            return ResponseEntity.ok(admin);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/updateStatus/{uname}")
    public boolean updateStatus (@PathVariable String uname)
    {
        boolean flag = adminService.changeStatus(uname);
        return flag;
    }
}
