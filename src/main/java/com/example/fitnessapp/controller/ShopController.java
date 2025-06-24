package com.example.fitnessapp.controller;

import com.example.fitnessapp.model.ShopItem;
import com.example.fitnessapp.service.ShopService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shop")
@CrossOrigin(origins = "*")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping
    public ShopItem addItem(@Valid @RequestBody ShopItem item) {
        return shopService.createItem(item);
    }

    @GetMapping
    public List<ShopItem> getAll() {
        return shopService.getAllItems();
    }

    @GetMapping("/category/{category}")
    public List<ShopItem> getByCategory(@PathVariable String category) {
        return shopService.getItemsByCategory(category);
    }

    @GetMapping("/{id}")
    public ShopItem getById(@PathVariable Long id) {
        return shopService.getItemById(id).orElseThrow();
    }
}
