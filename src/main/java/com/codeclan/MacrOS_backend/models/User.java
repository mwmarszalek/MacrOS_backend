package com.codeclan.MacrOS_backend.models;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name = "age")
    private int age;
    @Column(name = "sex")
    private String sex;
    @Column(name = "height")
    private double height;
    @Column(name = "startingWeight")
    private double startingWeight;
    @Column(name = "currentWeight")
    private double currentWeight;
    @Column(name = "goalWeight")
    private double goalWeight;
    @Column(name = "activityLevel")
    private ActivityLevel activityLevel;
    @Column(name = "experiencePoints")
    private Long experiencePoints;
    @Column(name = "caloriesGoal")
    private double caloriesGoal;
    @Column(name = "proteinGoal")
    private double proteinGoal;
    @Column(name = "fatGoal")
    private double fatGoal;
    @Column(name = "carbsGoal")
    private double carbsGoal;
    @Column(name = "sugarsGoal")
    private double sugarsGoal;


    public User(int age, String sex, double height, double startingWeight, double currentWeight, double goalWeight, ActivityLevel activityLevel, Long experiencePoints, double caloriesGoal, double proteinGoal, double fatGoal, double carbsGoal, double sugarsGoal) {
        this.age = age;
        this.sex = sex;
        this.height = height;
        this.startingWeight = startingWeight;
        this.currentWeight = currentWeight;
        this.goalWeight = goalWeight;
        this.activityLevel = activityLevel;
        this.experiencePoints = experiencePoints;
        this.caloriesGoal = caloriesGoal;
        this.proteinGoal = proteinGoal;
        this.fatGoal = fatGoal;
        this.carbsGoal = carbsGoal;
        this.sugarsGoal = sugarsGoal;
    }


    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getStartingWeight() {
        return startingWeight;
    }

    public void setStartingWeight(double startingWeight) {
        this.startingWeight = startingWeight;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public double getGoalWeight() {
        return goalWeight;
    }

    public void setGoalWeight(double goalWeight) {
        this.goalWeight = goalWeight;
    }

    public ActivityLevel getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(ActivityLevel activityLevel) {
        this.activityLevel = activityLevel;
    }

    public Long getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(Long experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public double getCaloriesGoal() {
        return caloriesGoal;
    }

    public void setCaloriesGoal(double caloriesGoal) {
        this.caloriesGoal = caloriesGoal;
    }

    public double getProteinGoal() {
        return proteinGoal;
    }

    public void setProteinGoal(double proteinGoal) {
        this.proteinGoal = proteinGoal;
    }

    public double getFatGoal() {
        return fatGoal;
    }

    public void setFatGoal(double fatGoal) {
        this.fatGoal = fatGoal;
    }

    public double getCarbsGoal() {
        return carbsGoal;
    }

    public void setCarbsGoal(double carbsGoal) {
        this.carbsGoal = carbsGoal;
    }

    public double getSugarsGoal() {
        return sugarsGoal;
    }

    public void setSugarsGoal(double sugarsGoal) {
        this.sugarsGoal = sugarsGoal;
    }
}
