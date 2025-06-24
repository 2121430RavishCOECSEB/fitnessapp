package com.example.fitnessapp.controller;

import com.example.fitnessapp.model.CartItem;
import com.example.fitnessapp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public CartItem addToCart(@RequestParam Long userId, @RequestParam Long itemId, @RequestParam int quantity) {
        return cartService.addToCart(userId, itemId, quantity);
    }

    @GetMapping("/{userId}")
    public List<CartItem> getUserCart(@PathVariable Long userId) {
        return cartService.getCartByUserId(userId);
    }

    @DeleteMapping("/{cartItemId}")
    public void removeItem(@PathVariable Long cartItemId) {
        cartService.removeCartItem(cartItemId);
    }
}
