class Order {
    int orderId;
    String orderDate;

    public Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public void getOrderStatus() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Status: Order Placed");
    }
}

class ShippedOrder extends Order {
    String trackingNumber;

    public ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    public void getOrderStatus() {
        super.getOrderStatus();
        System.out.println("Tracking Number: " + trackingNumber);
        System.out.println("Status: Order Shipped");
    }
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    public DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public void getOrderStatus() {
        super.getOrderStatus();
        System.out.println("Delivery Date: " + deliveryDate);
        System.out.println("Status: Order Delivered");
        System.out.println("----------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Order o1 = new Order(101, "2025-09-10");
        ShippedOrder o2 = new ShippedOrder(102, "2025-09-11", "TRK12345");
        DeliveredOrder o3 = new DeliveredOrder(103, "2025-09-12", "TRK67890", "2025-09-15");

        o1.getOrderStatus();
        System.out.println();
        o2.getOrderStatus();
        System.out.println();
        o3.ge
