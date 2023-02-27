package com.codeclan.MacrOS_backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;


@Entity
@Table(name = "days")
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date")
    private LocalDate date;

    @JsonBackReference
    @OneToMany(mappedBy = "day", fetch = FetchType.LAZY)
    private ArrayList<Meal> meals;


    @Column(name="completed")
    private boolean completed;
    @Column(name="user")
    private User user;




    public Day(LocalDate date, ArrayList<Meal> meals, User user) {
        this.date = date;
        this.meals = meals;
        this.completed = false;
        this.user = user;
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

    public ArrayList<Meal> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<Meal> meals) {
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
}
