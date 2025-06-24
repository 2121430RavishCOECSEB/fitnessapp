package com.example.fitnessapp.service;

import com.example.fitnessapp.model.ShopItem;
import com.example.fitnessapp.repository.ShopItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    @Autowired
    private ShopItemRepository shopItemRepository;

    public ShopItem createItem(ShopItem item) {
        return shopItemRepository.save(item);
    }

    public List<ShopItem> getAllItems() {
        return shopItemRepository.findAll();
    }

    public List<ShopItem> getItemsByCategory(String category) {
        return shopItemRepository.findByCategory(category);
    }

    public Optional<ShopItem> getItemById(Long id) {
        return shopItemRepository.findById(id);
    }
}
