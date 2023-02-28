package com.codeclan.MacrOS_backend.repositories;

import com.codeclan.MacrOS_backend.models.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodItemRepository extends JpaRepository<FoodItem,Long> {

    List<FoodItem> findByName(String name);
    List<FoodItem> findByBarcode(String barcode);

}
