package com.cts.user_mgmt_service.resource;

import com.cts.user_mgmt_service.Entity.UserPolicy;
import com.cts.user_mgmt_service.Entity.Users;
import com.cts.user_mgmt_service.service.UserMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    UserMgmtService userService;

    @GetMapping(value = "/all")
    @ResponseBody
    public Iterable<Users> getAllUsers(){
        return userService.getAllUsers();
    }

    /*@GetMapping(value = "/user/{userId}")
    public Users getUserById(@PathVariable ("userId") Integer userID){
        return userService.getUserById(userID);
    }*/

    @CrossOrigin
    @GetMapping(value = "/userPolicy/{userId}")
    public Iterable<UserPolicy> getPolicyByUserId(@PathVariable ("userId") Integer userID){
        return userService.getPolicyByUserId(userID);
    }

    @CrossOrigin
    @PutMapping("/register")
    public Users register(@RequestBody Users user){

        return userService.addUsers(user);
    }

    @CrossOrigin
    @GetMapping("/login")
    public Users validateUser(@RequestParam String username, @RequestParam String password){
        System.out.println("username is :: " + username);
        return userService.validateUser(username, password);
    }


    /*@GetMapping(value = "/validateUser")
    public boolean validateUser(@PathVariable String username, @PathVariable String password){
        return userService.validateUser(username, password);
    }*/

    @GetMapping("/createAdmin")
    public void createAdmin(){
        userService.createAdmin();
    }

}
