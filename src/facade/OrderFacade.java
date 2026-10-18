package facade;

import subsystem.*;

public class OrderFacade {
    private final InventoryService inventoryService;
    private final PaymentProcessor paymentProcessor;
    private final ShippingService shippingService;
    private final NotificationService notificationService;

    public OrderFacade() {
        this.inventoryService = new InventoryService();
        this.paymentProcessor = new PaymentProcessor();
        this.shippingService = new ShippingService();
        this.notificationService = new NotificationService();
    }

    public boolean placeOrder(String customerId, String customerEmail, String itemId, int quantity, double price, String cardDetails, String address) {
        String orderId = "ORD-" + System.currentTimeMillis() % 1000;
        System.out.println("\n=== Processing Order: " + orderId + " ===");

        // Step 1: Reserve Inventory
        if (!inventoryService.reserveStock(itemId, quantity)) {
            notificationService.sendPaymentFailureNotification(customerEmail, "Item out of stock");
            return false;
        }

        // Step 2: Process Payment
        double totalAmount = price * quantity;
        if (!paymentProcessor.processPayment(customerId, totalAmount, cardDetails)) {
            System.out.println("[OrderFacade] Rolling back order due to payment failure...");
            inventoryService.releaseStock(itemId, quantity); // Rollback
            notificationService.sendPaymentFailureNotification(customerEmail, "Card transaction declined");
            return false;
        }

        // Step 3: Schedule Shipping
        String trackingId = shippingService.scheduleDelivery(itemId, quantity, address);

        // Step 4: Send Confirmation
        notificationService.sendOrderConfirmation(customerEmail, orderId, trackingId);
        System.out.println("=== Order " + orderId + " Successfully Placed ===");
        return true;
    }
}