package com.codeclan.MacrOS_backend.components;

import com.codeclan.MacrOS_backend.models.FoodItem;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Profile("!test")
@Component
public class DataLoader implements ApplicationRunner {


    @Autowired
    FoodItemRepository foodItemRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    public DataLoader() throws IOException {

    }


    public void run(ApplicationArguments args) throws IOException {

        List<FoodItem> foodItem = objectMapper.readValue(new File("src/main/resources/all-products.json"), new TypeReference<List<FoodItem>>() {
        });
        foodItemRepository.saveAll(foodItem);


    }

}
