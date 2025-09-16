import java.util.*;

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName; this.price = price; this.quantity = quantity;
    }

    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int q) { this.quantity = q; }

    public abstract double calculateTotalPrice(); // price * qty (+ extras)

    public void getItemDetails() {
        System.out.printf("%s x%d = %.2f%n", itemName, quantity, calculateTotalPrice());
    }
}

interface Discountable {
    void applyDiscount(double percent);
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    private double discountPercent = 0;
    public VegItem(String name, double price, int qty) { super(name,price,qty); }
    public double calculateTotalPrice() {
        double total = getPrice() * getQuantity();
        return total - total * (discountPercent / 100.0);
    }
    public void applyDiscount(double percent) { this.discountPercent = percent; }
    public String getDiscountDetails() { return discountPercent + "% off"; }
}

class NonVegItem extends FoodItem {
    private double nonVegCharge = 30; // extra charge per item
    public NonVegItem(String name, double price, int qty) { super(name,price,qty); }
    public double calculateTotalPrice() {
        return (getPrice() + nonVegCharge) * getQuantity();
    }
}

public class FoodDelivery {
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();
        VegItem paneer = new VegItem("Paneer Butter Masala", 200, 2);
        paneer.applyDiscount(10); // a discount
        order.add(paneer);
        order.add(new NonVegItem("Chicken Biryani", 250, 1));

        double grandTotal = 0;
        for (FoodItem fi : order) {
            fi.getItemDetails();
            grandTotal += fi.calculateTotalPrice();
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }
}
