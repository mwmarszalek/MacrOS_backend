package com.codeclan.MacrOS_backend.controllers;


import com.codeclan.MacrOS_backend.models.FoodItem;
import com.codeclan.MacrOS_backend.repositories.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FoodItemController {

    @Autowired
    FoodItemRepository foodItemRepository;

    // get all food items
    @GetMapping(value = "/fooditems")
    public ResponseEntity<List<FoodItem>> getAllFoodItems(@RequestParam Optional<String> letters){
        if(letters.isPresent()){
            return new ResponseEntity<>(foodItemRepository.findByNameStartingWithIgnoreCase(letters.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(foodItemRepository.findAll(), HttpStatus.OK);
    }
    // get food item by id
    @GetMapping(value = "/fooditems/{id}")
    public ResponseEntity getFood(@PathVariable Long id){
        return new ResponseEntity<>(foodItemRepository.findById(id), HttpStatus.OK);
    }
    // add food items to the db
    @PostMapping(value = "/fooditems")
    public ResponseEntity<FoodItem> postFoodItem(@RequestBody FoodItem foodItem){
        foodItemRepository.save(foodItem);
        return new ResponseEntity<>(foodItem, HttpStatus.CREATED);
    }










}
