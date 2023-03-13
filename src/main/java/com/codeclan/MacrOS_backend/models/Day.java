package com.codeclan.MacrOS_backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "days")
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date")
    private LocalDate date;
    @JsonIgnoreProperties({"days"})
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;
//    @JsonBackReference
    @OneToMany(mappedBy = "day", fetch = FetchType.LAZY)
    private List<Meal> meals;
    @Column(name="completed")
    private boolean completed;
    @Column(name="user_weight")
    private double userWeight;


    public Day(LocalDate date,  User user) {
        this.date = date;
        this.meals = new ArrayList<>();
        this.completed = false;
        this.user = user;
        this.userWeight = user.getCurrentWeight();
    }

    public Day() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(double userWeight) {
        this.userWeight = userWeight;
    }
}
