package com.codeclan.MacrOS_backend.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "foodItems")
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "carbs")
    private double carbs;
    @Column(name = "sugars")
    private double sugars;
    @Column(name = "protein")
    private double protein;
    @Column(name = "fat")
    private double fat;
    @Column(name = "calories")
    private double calories;
    @Column(name = "barcode")
    private String barcode;






    public FoodItem(String name, double carbs, double sugars, double protein, double fat, double calories, String barcode) {
        this.name = name;
        this.carbs = carbs;
        this.sugars = sugars;
        this.protein = protein;
        this.fat = fat;
        this.calories = calories;
        this.barcode = barcode;
    }


    public FoodItem() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getSugars() {
        return sugars;
    }

    public void setSugars(double sugars) {
        this.sugars = sugars;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}
