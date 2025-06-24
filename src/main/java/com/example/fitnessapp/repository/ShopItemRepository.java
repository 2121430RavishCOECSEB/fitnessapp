package com.example.fitnessapp.repository;

import com.example.fitnessapp.model.ShopItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopItemRepository extends JpaRepository<ShopItem, Long> {
    List<ShopItem> findByCategory(String category);
}
