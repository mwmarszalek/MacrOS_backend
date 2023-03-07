package com.codeclan.MacrOS_backend.controllers;



import com.codeclan.MacrOS_backend.models.Day;
import com.codeclan.MacrOS_backend.models.User;
import com.codeclan.MacrOS_backend.repositories.DayRepository;
import com.codeclan.MacrOS_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DayController {

    @Autowired
    DayRepository dayRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/days")
    public ResponseEntity<List<Day>> getAllDays(){
        return new ResponseEntity<>(dayRepository.findAll() , HttpStatus.OK);
    }

    @PostMapping(value = "/days")
    public ResponseEntity<Day> postDay(@RequestBody Day day){
        dayRepository.save(day);
        return new ResponseEntity<>(dayRepository.findById(day.getId()).get(), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/days/{id}")
    public ResponseEntity deleteDayById (@PathVariable Long id){
        Optional<Day> dayToDelete = dayRepository.findById(id);
        dayRepository.delete(dayToDelete.get());
        return new ResponseEntity<>(dayToDelete.get(), HttpStatus.OK);

    }

    @PutMapping(value = "/days/{id}")
    public ResponseEntity updateDayById (@PathVariable Long id, @RequestBody Day updatedDay){
        Day dayToUpdate = dayRepository.findById(id).get();
        User origUser = updatedDay.getUser();
        User user = userRepository.findById(origUser.getId()).get();
        user.setCurrentWeight(origUser.getCurrentWeight());
        userRepository.save(user);

        dayToUpdate.setDate(updatedDay.getDate());
        dayToUpdate.setCompleted(updatedDay.isCompleted());
        dayToUpdate.setUser(updatedDay.getUser());
        dayToUpdate.setMeals(updatedDay.getMeals());
        dayToUpdate.setUserWeight(updatedDay.getUserWeight());
        dayRepository.save(dayToUpdate);
        return new ResponseEntity<>(dayToUpdate, HttpStatus.OK);

    }




}
