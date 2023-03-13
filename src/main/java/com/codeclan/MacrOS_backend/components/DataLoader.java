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
        Day day1 = new Day(LocalDate.of(2023, 3, 8), user1);
        Day day2 = new Day(LocalDate.of(2023, 3, 7), user1);
        Day day3 = new Day(LocalDate.of(2023, 3, 6), user1);
        Day day4 = new Day(LocalDate.of(2023, 3, 5), user1);
        Day day5 = new Day(LocalDate.of(2023, 3, 4), user1);
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

//      Create FoodItem List1

        List<FoodItem> breakfastList1 = new ArrayList<>();
        breakfastList1.add(foodItem1);

        List<FoodItem> lunchList1 = new ArrayList<>();
        lunchList1.add(foodItem2);

        List<FoodItem> dinnerList1 = new ArrayList<>();
        dinnerList1.add(foodItem3);

        List<FoodItem> snackList1 = new ArrayList<>();
        snackList1.add(foodItem4);

//        Create FoodItem List2

        List<FoodItem> breakfastList2 = new ArrayList<>();
        breakfastList2.add(foodItem5);

        List<FoodItem> lunchList2 = new ArrayList<>();
        lunchList2.add(foodItem6);

        List<FoodItem> dinnerList2 = new ArrayList<>();
        dinnerList2.add(foodItem1);

        List<FoodItem> snackList2 = new ArrayList<>();
        snackList2.add(foodItem2);

        //        Create FoodItem List3

        List<FoodItem> breakfastList3 = new ArrayList<>();
        breakfastList3.add(foodItem3);

        List<FoodItem> lunchList3 = new ArrayList<>();
        lunchList3.add(foodItem4);

        List<FoodItem> dinnerList3 = new ArrayList<>();
        dinnerList3.add(foodItem5);

        List<FoodItem> snackList3 = new ArrayList<>();
        snackList3.add(foodItem6);

        //        Create FoodItem List4

        List<FoodItem> breakfastList4 = new ArrayList<>();
        breakfastList4.add(foodItem1);

        List<FoodItem> lunchList4 = new ArrayList<>();
        lunchList4.add(foodItem2);

        List<FoodItem> dinnerList4 = new ArrayList<>();
        dinnerList4.add(foodItem3);

        List<FoodItem> snackList4 = new ArrayList<>();
        snackList4.add(foodItem4);

        //        Create FoodItem List5

        List<FoodItem> breakfastList5 = new ArrayList<>();
        breakfastList5.add(foodItem5);

        List<FoodItem> lunchList5 = new ArrayList<>();
        lunchList5.add(foodItem6);

        List<FoodItem> dinnerList5 = new ArrayList<>();
        dinnerList5.add(foodItem1);

        List<FoodItem> snackList5 = new ArrayList<>();
        snackList5.add(foodItem2);

        day1Meal1.setFoodItems(breakfastList1);
        day1Meal2.setFoodItems(lunchList1);
        day1Meal3.setFoodItems(dinnerList1);
        day1Meal4.setFoodItems(snackList1);

        day2Meal1.setFoodItems(breakfastList2);
        day2Meal2.setFoodItems(lunchList2);
        day2Meal3.setFoodItems(dinnerList2);
        day2Meal4.setFoodItems(snackList2);

        day3Meal1.setFoodItems(breakfastList3);
        day3Meal2.setFoodItems(lunchList3);
        day3Meal3.setFoodItems(dinnerList3);
        day3Meal4.setFoodItems(snackList3);

        day4Meal1.setFoodItems(breakfastList4);
        day4Meal2.setFoodItems(lunchList4);
        day4Meal3.setFoodItems(dinnerList4);
        day4Meal4.setFoodItems(snackList4);

        day5Meal1.setFoodItems(breakfastList5);
        day5Meal2.setFoodItems(lunchList5);
        day5Meal3.setFoodItems(dinnerList5);
        day5Meal4.setFoodItems(snackList5);

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


