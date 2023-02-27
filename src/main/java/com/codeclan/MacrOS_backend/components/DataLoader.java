package com.codeclan.MacrOS_backend.components;

import com.codeclan.MacrOS_backend.models.FoodItem;
import com.codeclan.MacrOS_backend.repositories.DayRepository;
import com.codeclan.MacrOS_backend.repositories.FoodItemRepository;
import com.codeclan.MacrOS_backend.repositories.MealRepository;
import com.codeclan.MacrOS_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Profile("!test")
@Component
public class DataLoader implements ApplicationRunner {


    @Autowired
    UserRepository userRepository;

    @Autowired
    DayRepository dayRepository;

    @Autowired
    MealRepository mealRepository;

    @Autowired
    FoodItemRepository foodItemRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {
    FoodItem foodItem1 = new FoodItem("Chocolate",24,213,321,312,432,3254253L);
    foodItemRepository.save(foodItem1);
    FoodItem foodItem2 = new FoodItem("Chocolate",24,213,321,312,432,3254253L);
    foodItemRepository.save(foodItem2);
    FoodItem foodItem3 = new FoodItem("Chocolate",24,213,321,312,432,3254253L);
    foodItemRepository.save(foodItem3);

    }


}
