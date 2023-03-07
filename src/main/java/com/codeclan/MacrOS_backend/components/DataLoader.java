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


        User user1 = new User("Brian", 29, "Male", 180, 80, 82, 75, ActivityLevel.ACTIVE, GoalType.GAIN_WEIGHT, 1000L, 3000, 170, 120, 400, 80);
        userRepository.save(user1);
        Day day1 = new Day(LocalDate.of(2023, 3, 6), user1);
        Day day2 = new Day(LocalDate.of(2023, 3, 5), user1);
        Day day3 = new Day(LocalDate.of(2023, 3, 4), user1);
        Day day4 = new Day(LocalDate.of(2023, 3, 3), user1);
        Day day5 = new Day(LocalDate.of(2023, 3, 2), user1);
        dayRepository.save(day1);
        dayRepository.save(day2);
        dayRepository.save(day3);
        dayRepository.save(day4);
        dayRepository.save(day5);

        Meal day1Meal1 = new Meal(MealType.BREAKFAST, day1);
        Meal day1Meal2 = new Meal(MealType.LUNCH, day1);
        Meal day1Meal3 = new Meal(MealType.DINNER, day1);
        Meal day1Meal4 = new Meal(MealType.SNACK, day1);
        mealRepository.save(day1Meal1);
        mealRepository.save(day1Meal2);
        mealRepository.save(day1Meal3);
        mealRepository.save(day1Meal4);

        Meal day2Meal1 = new Meal(MealType.BREAKFAST, day2);
        Meal day2Meal2 = new Meal(MealType.LUNCH, day2);
        Meal day2Meal3 = new Meal(MealType.DINNER, day2);
        Meal day2Meal4 = new Meal(MealType.SNACK, day2);
        mealRepository.save(day2Meal1);
        mealRepository.save(day2Meal2);
        mealRepository.save(day2Meal3);
        mealRepository.save(day2Meal4);

        Meal day3Meal1 = new Meal(MealType.BREAKFAST, day3);
        Meal day3Meal2 = new Meal(MealType.LUNCH, day3);
        Meal day3Meal3 = new Meal(MealType.DINNER, day3);
        Meal day3Meal4 = new Meal(MealType.SNACK, day3);
        mealRepository.save(day3Meal1);
        mealRepository.save(day3Meal2);
        mealRepository.save(day3Meal3);
        mealRepository.save(day3Meal4);

        Meal day4Meal1 = new Meal(MealType.BREAKFAST, day4);
        Meal day4Meal2 = new Meal(MealType.LUNCH, day4);
        Meal day4Meal3 = new Meal(MealType.DINNER, day4);
        Meal day4Meal4 = new Meal(MealType.SNACK, day4);
        mealRepository.save(day4Meal1);
        mealRepository.save(day4Meal2);
        mealRepository.save(day4Meal3);
        mealRepository.save(day4Meal4);

        Meal day5Meal1 = new Meal(MealType.BREAKFAST, day5);
        Meal day5Meal2 = new Meal(MealType.LUNCH, day5);
        Meal day5Meal3 = new Meal(MealType.DINNER, day5);
        Meal day5Meal4 = new Meal(MealType.SNACK, day5);
        mealRepository.save(day5Meal1);
        mealRepository.save(day5Meal2);
        mealRepository.save(day5Meal3);
        mealRepository.save(day5Meal4);


        FoodItem foodItem1 = new FoodItem("Bacon crisps", 123, 45,23,34,1000,"12345678");
        FoodItem foodItem2 = new FoodItem("Salt crisps", 95, 23,14,43,1230,"12345678");
        FoodItem foodItem3 = new FoodItem("Sausage crisps", 23, 54,56,45,987,"12345678");
        FoodItem foodItem4 = new FoodItem("Pork crisps", 32, 16,75,87,1500,"12345678");
        FoodItem foodItem5 = new FoodItem("Cheese crisps", 45, 76,98,45,678,"12345678");
        FoodItem foodItem6 = new FoodItem("Ham crisps", 34, 34,54,65,1020,"12345678");
        foodItemRepository.save(foodItem1);
        foodItemRepository.save(foodItem2);
        foodItemRepository.save(foodItem3);
        foodItemRepository.save(foodItem4);
        foodItemRepository.save(foodItem5);
        foodItemRepository.save(foodItem6);

        List<FoodItem> breakfastList = new ArrayList<>();
        breakfastList.add(foodItem1);

        List<FoodItem> lunchList = new ArrayList<>();
        lunchList.add(foodItem2);

        List<FoodItem> dinnerList = new ArrayList<>();
        dinnerList.add(foodItem3);

        List<FoodItem> snackList = new ArrayList<>();
        snackList.add(foodItem4);

        day1Meal1.setFoodItems(breakfastList);
        day1Meal2.setFoodItems(lunchList);
        day1Meal3.setFoodItems(dinnerList);
        day1Meal4.setFoodItems(snackList);

        day2Meal1.setFoodItems(breakfastList);
        day2Meal2.setFoodItems(lunchList);
        day2Meal3.setFoodItems(dinnerList);
        day2Meal4.setFoodItems(snackList);

        day3Meal1.setFoodItems(breakfastList);
        day3Meal2.setFoodItems(lunchList);
        day3Meal3.setFoodItems(dinnerList);
        day3Meal4.setFoodItems(snackList);

        day4Meal1.setFoodItems(breakfastList);
        day4Meal2.setFoodItems(lunchList);
        day4Meal3.setFoodItems(dinnerList);
        day4Meal4.setFoodItems(snackList);

        day5Meal1.setFoodItems(breakfastList);
        day5Meal2.setFoodItems(lunchList);
        day5Meal3.setFoodItems(dinnerList);
        day5Meal4.setFoodItems(snackList);

        mealRepository.save(day1Meal1);
        mealRepository.save(day1Meal2);
        mealRepository.save(day1Meal3);
        mealRepository.save(day1Meal4);

        mealRepository.save(day2Meal1);
        mealRepository.save(day2Meal2);
        mealRepository.save(day2Meal3);
        mealRepository.save(day2Meal4);

        mealRepository.save(day3Meal1);
        mealRepository.save(day3Meal2);
        mealRepository.save(day3Meal3);
        mealRepository.save(day3Meal4);

        mealRepository.save(day4Meal1);
        mealRepository.save(day4Meal2);
        mealRepository.save(day4Meal3);
        mealRepository.save(day4Meal4);

        mealRepository.save(day5Meal1);
        mealRepository.save(day5Meal2);
        mealRepository.save(day5Meal3);
        mealRepository.save(day5Meal4);

        List<Meal> mealList1 = new ArrayList<>();
        mealList1.add(day1Meal1);
        mealList1.add(day1Meal2);
        mealList1.add(day1Meal3);
        mealList1.add(day1Meal4);

        List<Meal> mealList2 = new ArrayList<>();
        mealList2.add(day2Meal1);
        mealList2.add(day2Meal2);
        mealList2.add(day2Meal3);
        mealList2.add(day2Meal4);

        List<Meal> mealList3 = new ArrayList<>();
        mealList3.add(day3Meal1);
        mealList3.add(day3Meal2);
        mealList3.add(day3Meal3);
        mealList3.add(day3Meal4);

        List<Meal> mealList4 = new ArrayList<>();
        mealList4.add(day4Meal1);
        mealList4.add(day4Meal2);
        mealList4.add(day4Meal3);
        mealList4.add(day4Meal4);

        List<Meal> mealList5 = new ArrayList<>();
        mealList5.add(day5Meal1);
        mealList5.add(day5Meal2);
        mealList5.add(day5Meal3);
        mealList5.add(day5Meal4);


        day1.setMeals(mealList1);
        day2.setMeals(mealList2);
        day3.setMeals(mealList3);
        day4.setMeals(mealList4);
        day5.setMeals(mealList5);

        dayRepository.save(day1);
        dayRepository.save(day2);
        dayRepository.save(day3);
        dayRepository.save(day4);
        dayRepository.save(day5);






    }
}


