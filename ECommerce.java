import java.util.*;

abstract class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId; this.name = name; this.price = price;
    }

    public String getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public abstract double calculateDiscount(); // e.g., flat or percent
}

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

class Electronics extends Product implements Taxable {
    public Electronics(String id, String name, double price) { super(id,name,price); }
    public double calculateDiscount() { return getPrice() * 0.10; } // 10% discount
    public double calculateTax() { return getPrice() * 0.18; } // 18% GST
    public String getTaxDetails() { return "GST 18%"; }
}

class Clothing extends Product implements Taxable {
    public Clothing(String id, String name, double price) { super(id,name,price); }
    public double calculateDiscount() { return 50; } // flat discount
    public double calculateTax() { return getPrice() * 0.05; } // 5%
    public String getTaxDetails() { return "GST 5%"; }
}

class Groceries extends Product {
    public Groceries(String id, String name, double price) { super(id,name,price); }
    public double calculateDiscount() { return 0; } // no discount
}

public class ECommerce {
    public static void printFinalPrice(Product p) {
        double price = p.getPrice();
        double discount = p.calculateDiscount();
        double tax = (p instanceof Taxable) ? ((Taxable)p).calculateTax() : 0;
        double finalPrice = price + tax - discount;
        System.out.printf("%s (%s): price=%.2f tax=%.2f discount=%.2f final=%.2f%n",
                          p.getName(), p.getClass().getSimpleName(), price, tax, discount, finalPrice);
    }

    public static void main(String[] args) {
        List<Product> products = List.of(
            new Electronics("E01","Phone",20000),
            new Clothing("C01","Shirt",1200),
            new Groceries("G01","Rice",800)
        );

        for (Product p : products) printFinalPrice(p);
    }
}
