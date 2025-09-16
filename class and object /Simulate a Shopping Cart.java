package com.bridgelabz.oops.levelone;

import java.util.ArrayList;

class CartItem {
    private String itemName;
    private double price;
    private int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void displayItem() {
        S
