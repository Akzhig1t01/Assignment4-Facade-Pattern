package subsystem;

public class PaymentProcessor {
    public boolean processPayment(String customerId, double amount, String cardDetails) {
        if (cardDetails == null || cardDetails.startsWith("INVALID")) {
            System.out.println("[PaymentProcessor] Payment DECLINED for customer " + customerId + " (Amount: $" + amount + ")");
            return false;
        }
        System.out.println("[PaymentProcessor] Payment APPROVED for customer " + customerId + " (Amount: $" + amount + ")");
        return true;
    }

    public void refundPayment(String customerId, double amount) {
        System.out.println("[PaymentProcessor] Refunded $" + amount + " to customer " + customerId);
    }
}