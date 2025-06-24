package com.example.fitnessapp.service;

import com.example.fitnessapp.model.CartItem;
import com.example.fitnessapp.model.ShopItem;
import com.example.fitnessapp.repository.CartItemRepository;
import com.example.fitnessapp.repository.ShopItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ShopItemRepository shopItemRepository;

    public CartItem addToCart(Long userId, Long itemId, int quantity) {
        ShopItem item = shopItemRepository.findById(itemId).orElseThrow();
        CartItem cartItem = new CartItem(userId, item, quantity);
        return cartItemRepository.save(cartItem);
    }

    public List<CartItem> getCartByUserId(Long userId) {
        return cartItemRepository.findByUserId(userId);
    }

    public void removeCartItem(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }
}
