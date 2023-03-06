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


        User user1 = new User("Brian", 29, "Male", 180, 80, 82, 84, ActivityLevel.ACTIVE, GoalType.GAIN_WEIGHT, 1000L, 3000, 170, 120, 400, 80);
        userRepository.save(user1);
        Day day1 = new Day(LocalDate.of(2023, 2, 27),user1);
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
        Meal meal4 = new Meal(MealType.SNACK, day1);
        mealRepository.save(meal1);
        mealRepository.save(meal2);
        mealRepository.save(meal3);
        mealRepository.save(meal4);

        FoodItem foodItem1 = new FoodItem("Bacon crisps", 100, 100,100,100,1000,"12345678");
        FoodItem foodItem2 = new FoodItem("Salt crisps", 100, 100,100,100,1000,"12345678");
        FoodItem foodItem3 = new FoodItem("Sausage crisps", 100, 100,100,100,1000,"12345678");
        FoodItem foodItem4 = new FoodItem("Pork crisps", 100, 100,100,100,1000,"12345678");
        FoodItem foodItem5 = new FoodItem("Cheese crisps", 100, 100,100,100,1000,"12345678");
        FoodItem foodItem6 = new FoodItem("Ham crisps", 100, 100,100,100,1000,"12345678");
        foodItemRepository.save(foodItem1);
        foodItemRepository.save(foodItem2);
        foodItemRepository.save(foodItem3);
        foodItemRepository.save(foodItem4);
        foodItemRepository.save(foodItem5);
        foodItemRepository.save(foodItem6);

        List<FoodItem> breakfastList = new ArrayList<>();
        breakfastList.add(foodItem1);

        meal1.setFoodItems(breakfastList);

        List<FoodItem> lunchList = new ArrayList<>();
        lunchList.add(foodItem2);

        List<FoodItem> dinnerList = new ArrayList<>();
        dinnerList.add(foodItem3);

        List<FoodItem> snackList = new ArrayList<>();
        snackList.add(foodItem4);

        meal1.setFoodItems(breakfastList);
        meal2.setFoodItems(lunchList);
        meal3.setFoodItems(dinnerList);
        meal4.setFoodItems(snackList);

        mealRepository.save(meal1);
        mealRepository.save(meal2);
        mealRepository.save(meal3);
        mealRepository.save(meal4);

        List<Meal> mealList = new ArrayList<>();

        mealList.add(meal1);
        mealList.add(meal2);

        day1.setMeals(mealList);

        dayRepository.save(day1);






    }
}


