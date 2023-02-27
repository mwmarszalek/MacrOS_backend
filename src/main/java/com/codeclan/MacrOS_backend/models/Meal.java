package com.codeclan.MacrOS_backend.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "meals")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="mealType")
    private MealType mealType;



//    @JsonBackReference
//    @OneToMany(mappedBy = "meal",fetch = FetchType.LAZY)
    @Column(name = "foodItems")
    private List<FoodItem> foodItems;

    @JsonIgnoreProperties({"meals"})
    @ManyToOne
    @JoinColumn(name = "day_id", nullable = false)
    private Day day;

    public Meal(MealType mealType, Day day) {
        this.mealType = mealType;
        this.foodItems = new ArrayList<>();
        this.day = day;
    }

    public Meal() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }
}
