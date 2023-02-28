package com.codeclan.MacrOS_backend.controllers;

//Delete By id
//Post by
//update By id

import com.codeclan.MacrOS_backend.models.Meal;
import com.codeclan.MacrOS_backend.models.MealType;
import com.codeclan.MacrOS_backend.repositories.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MealController {

    @Autowired
    MealRepository mealRepository;

//    Get data
    @GetMapping(value = "/meals")
    public ResponseEntity<List<Meal>> getAllMeals(){
        return new ResponseEntity<>(mealRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/meals")
    public ResponseEntity postMeal(@RequestBody Meal meal){
        mealRepository.save(meal);
        return new ResponseEntity<>(mealRepository.findById(meal.getId()).get(), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/meals/{id}")
    public ResponseEntity deleteMealById(@PathVariable Long id){
        Optional<Meal> mealToDelete = mealRepository.findById(id);
        mealRepository.delete(mealToDelete.get());
        return new ResponseEntity(mealToDelete.get(), HttpStatus.OK)
    }

    @PutMapping(value = "/meals/{id}")
    public ResponseEntity updateMealById(@PathVariable Long id, @RequestBody Meal updatedMeal ){
        Meal mealToUpdate = mealRepository.findById(id).get();
        mealToUpdate.setMealType(updatedMeal.getMealType());
        mealToUpdate.setDay(updatedMeal.getDay());
        mealToUpdate.setFoodItems(updatedMeal.getFoodItems());
        mealRepository.save(mealToUpdate);
        return new ResponseEntity(mealRepository.findById(id), HttpStatus.ACCEPTED);
    }
}
