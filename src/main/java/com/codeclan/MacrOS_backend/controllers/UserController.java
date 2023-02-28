package com.codeclan.MacrOS_backend.controllers;

import com.codeclan.MacrOS_backend.models.FoodItem;
import com.codeclan.MacrOS_backend.models.User;
import com.codeclan.MacrOS_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    // GET the user
    @GetMapping(value = "/user")
    public ResponseEntity getUser(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }
    // GET user by ID
    @GetMapping(value = "/user/{id}")
    public ResponseEntity getUserById(@PathVariable Long id){
        return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
    }
    // CREATE the user
    @PostMapping(value = "/user")
    public ResponseEntity<User> postUserInfo(@RequestBody User user){
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    // PUT

    @PutMapping(value = "/user/{id}")
    public ResponseEntity<User> updateUserInfo(@PathVariable Long id, @RequestBody User updatedUser){
        User userToUpdate = userRepository.findById(id).get();
        userToUpdate.setAge(updatedUser.getAge());
        userToUpdate.setSex(updatedUser.getSex());
        userToUpdate.setHeight(updatedUser.getHeight());
        userToUpdate.setCurrentWeight(updatedUser.getCurrentWeight());
        userToUpdate.setStartingWeight(updatedUser.getStartingWeight());
        userToUpdate.setGoalWeight(updatedUser.getGoalWeight());
        userToUpdate.setActivityLevel(updatedUser.getActivityLevel());
        userToUpdate.setExperiencePoints(updatedUser.getExperiencePoints());
        userToUpdate.setCaloriesGoal(updatedUser.getCaloriesGoal());
        userToUpdate.setProteinGoal(updatedUser.getProteinGoal());
        userToUpdate.setFatGoal(updatedUser.getFatGoal());
        userToUpdate.setCarbsGoal(updatedUser.getCarbsGoal());
        userToUpdate.setSugarsGoal(updatedUser.getSugarsGoal());

        userRepository.save(userToUpdate);

        return new ResponseEntity<>(userToUpdate, HttpStatus.OK);
    }

}
