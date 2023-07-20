package com.loginapplication.LoginAppBackend.Controller;

import com.loginapplication.LoginAppBackend.Models.User;
import com.loginapplication.LoginAppBackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/loginapp")
public class UserController {

    @Autowired
    private UserService loginservice;


    @PostMapping("/newuser")
    public ResponseEntity<User> addNewUser(@RequestBody User user){

            User u =  loginservice.addNewUser(user);
            return ResponseEntity.ok(u);

    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> userList = loginservice.allUsers();
        if(userList != null)
        {
            return ResponseEntity.ok(userList);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/validate")
    public ResponseEntity<User> validateUser(@RequestBody User user){
        String uname = user.getUsername();
        String password = user.getPassword();

       User u =  loginservice.validateCredentials(uname,password);
       if(u != null){
           return ResponseEntity.ok(u);
       }

       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getUser/{uname}")
    public ResponseEntity<User> getUserById(@PathVariable String uname)
    {
        User user = loginservice.getByUsername(uname);
        if(user != null){
            return ResponseEntity.ok(user);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/editUser/{uname}")
    public ResponseEntity<User> editUser(@RequestBody User user, @PathVariable String uname)
    {
        User u = loginservice.updateUser(user,uname);
        if(u != null){
            return ResponseEntity.ok(u);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
