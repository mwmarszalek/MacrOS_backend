package com.codeclan.MacrOS_backend.components;

import com.codeclan.MacrOS_backend.models.*;
import com.codeclan.MacrOS_backend.repositories.DayRepository;
import com.codeclan.MacrOS_backend.repositories.FoodItemRepository;
import com.codeclan.MacrOS_backend.repositories.MealRepository;
import com.codeclan.MacrOS_backend.repositories.UserRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.time.temporal.TemporalQueries.localDate;


@Profile("!test")
@Component
public class DataLoader implements ApplicationRunner {


    @Autowired
    FoodItemRepository foodItemRepository;
    @Autowired
    DayRepository dayRepository;
    @Autowired
    MealRepository mealRepository;
    @Autowired
    UserRepository userRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    public DataLoader() throws IOException {

    }


    public void run(ApplicationArguments args) throws IOException {

        List<FoodItem> foodItem = objectMapper.readValue(new File("src/main/resources/all-products.json"), new TypeReference<List<FoodItem>>() {
        });
        foodItemRepository.saveAll(foodItem);

//        Add dummy data in order to test day and meal controllers

        User user1 = new User("Brian", 29, "Male", 180, 80, 82, 84, ActivityLevel.ACTIVE, 1000L, 3000, 170, 120, 400, 80);
        userRepository.save(user1);

        Day day1 = new Day(LocalDate.of(2023, 3, 1),user1);
        Day day2 = new Day(LocalDate.of(2023, 2, 26), user1);
        Day day3 = new Day(LocalDate.of(2023, 2, 25), user1);
        Day day4 = new Day(LocalDate.of(2023, 2, 24), user1);
        Day day5 = new Day(LocalDate.of(2023, 2, 23), user1);
        dayRepository.save(day1);
        dayRepository.save(day2);
        dayRepository.save(day3);
        dayRepository.save(day4);
        dayRepository.save(day5);

        Meal meal1 = new Meal(MealType.BREAKFAST, day1);
        Meal meal2 = new Meal(MealType.LUNCH, day1);
        Meal meal3 = new Meal(MealType.DINNER, day1);
        Meal meal4  = new Meal(MealType.SNACK, day1);
        mealRepository.save(meal1);
        mealRepository.save(meal2);
        mealRepository.save(meal3);
        mealRepository.save(meal4);

        FoodItem foodItem1 = new FoodItem("Chips", 50, 100, 50, 100, 1000, "123456789");
        FoodItem foodItem2 = new FoodItem("Cheese", 30, 100, 70, 200, 1000, "123456789");
        FoodItem foodItem3 = new FoodItem("Curry Sauce", 100, 90, 60, 150, 1000, "123456789");
        FoodItem foodItem4 = new FoodItem("Curry Sauce", 100, 90, 60, 150, 1000, "123456789");
        foodItemRepository.save(foodItem1);
        foodItemRepository.save(foodItem2);
        foodItemRepository.save(foodItem3);
        foodItemRepository.save(foodItem4);

        List<FoodItem> breakfastFoodItemList = new ArrayList<>();
        List<FoodItem> lunchFoodItemList = new ArrayList<>();
        List<FoodItem> dinnerFoodItemList = new ArrayList<>();
        List<FoodItem> snackFoodItemList = new ArrayList<>();
        breakfastFoodItemList.add(foodItem1);
        lunchFoodItemList.add(foodItem2);
        dinnerFoodItemList.add(foodItem3);
        snackFoodItemList.add(foodItem4);


        meal1.setFoodItems(breakfastFoodItemList);
        meal2.setFoodItems(lunchFoodItemList);
        meal3.setFoodItems(dinnerFoodItemList);
        meal4.setFoodItems(snackFoodItemList);

        List<Meal> day1Meals =  new ArrayList<>();
        day1Meals.add(meal1);
        day1Meals.add(meal2);
        day1Meals.add(meal3);
        day1Meals.add(meal4);

        day1.setMeals(day1Meals);
        day2.setMeals(day1Meals);
        day3.setMeals(day1Meals);


    }
}


