package subsystem;

public class NotificationService {
    public void sendOrderConfirmation(String customerEmail, String orderId, String trackingId) {
        System.out.println("[NotificationService] Email sent to " + customerEmail + ": Order " + orderId + " confirmed! Tracking: " + trackingId);
    }

    public void sendPaymentFailureNotification(String customerEmail, String reason) {
        System.out.println("[NotificationService] Email sent to " + customerEmail + ": Payment failed. Reason: " + reason);
    }
}