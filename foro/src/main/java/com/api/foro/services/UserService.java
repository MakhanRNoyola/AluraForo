package com.api.foro.services;

import com.api.foro.models.UserModel;
import com.api.foro.repositories.IUserRepository;
import jakarta.persistence.Id;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    public ArrayList <UserModel> getUsers(){
        return(ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser (UserModel user){
        return userRepository.save(user);
    }

    public Optional<UserModel> getById(Long id){
        return userRepository.findById(id);
    }
    public UserModel updateById(UserModel request, long Id){
        UserModel user = userRepository.findById(Id).get();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        return user;
    }
    public  Boolean deleteUser(Long Id){
        try{
            userRepository.deleteById(Id);
            return true;

        }catch (Exception e){
            return  false;
        }
    }

    }


