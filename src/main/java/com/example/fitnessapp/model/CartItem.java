package com.example.fitnessapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "shop_item_id")
    private ShopItem item;

    @Positive
    private int quantity;

    // Constructors, Getters, Setters

    public CartItem() {}

    public CartItem(Long userId, ShopItem item, int quantity) {
        this.userId = userId;
        this.item = item;
        this.quantity = quantity;
    }

    // Getters and Setters...

    public Long getId() { return id; }

    public Long getUserId() { return userId; }

    public void setUserId(Long userId) { this.userId = userId; }

    public ShopItem getItem() { return item; }

    public void setItem(ShopItem item) { this.item = item; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }
}
