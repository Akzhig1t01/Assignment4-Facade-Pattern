package subsystem;

public class ShippingService {
    public String scheduleDelivery(String itemId, int quantity, String address) {
        String trackingId = "TRACK-" + System.currentTimeMillis() % 10000;
        System.out.println("[ShippingService] Scheduled shipment of " + quantity + "x " + itemId + " to '" + address + "'. Tracking ID: " + trackingId);
        return trackingId;
    }

    public void cancelDelivery(String trackingId) {
        System.out.println("[ShippingService] Cancelled shipment for tracking ID: " + trackingId);
    }
}