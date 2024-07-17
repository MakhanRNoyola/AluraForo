package com.api.foro.controllers;

import com.api.foro.models.UserModel;
import com.api.foro.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList <UserModel> getUsers(){
        return  this.userService.getUsers();
    }

    @PostMapping
    public UserModel saverUser(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }

    @GetMapping(path = "/(id")
    public Optional<UserModel> getUserById(@PathVariable Long id){
         return this.userService.getById(id);
            }
     @PutMapping(path = "/(id")
    public UserModel updateUserById(@RequestBody UserModel request,@PathVariable("/id") Long Id){
        return this.userService.updateById(request, Id);
     }
    @DeleteMapping(path = "/{i}")
    public String deleteById(@PathVariable ("id") Long Id){
        Boolean ok = this.userService.deleteUser(Id);

        if (ok){
            return "User with id"+ Id +"deleted";
        }else{
            return "Error we have a problem and  can´t delete user with id" + Id;
        }

    }
}
