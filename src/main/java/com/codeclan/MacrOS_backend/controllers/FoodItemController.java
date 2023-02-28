package com.codeclan.MacrOS_backend.controllers;


import com.codeclan.MacrOS_backend.models.FoodItem;
import com.codeclan.MacrOS_backend.repositories.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodItemController {

    @Autowired
    FoodItemRepository foodItemRepository;

    @GetMapping(value = "/fooditems")
    public ResponseEntity<List<FoodItem>> getAllFoodItems(){
        return new ResponseEntity<>(foodItemRepository.findAll(), HttpStatus.OK);
    }










}
