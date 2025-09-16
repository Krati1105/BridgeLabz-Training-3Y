package com.bridgelabz.oops.levelone;

class Item {
    private int itemCode;
    private String itemName;
    private double price;

    public Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Item Price: " + price);
    }

    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }
}

public class ItemMain {
    public static void main(String[] args) {
        Item item1 = new Item(101, "Laptop", 55000.0);
        Item item2 = new Item(102, "Headphones", 2500.0);

        item1.displayDetai
