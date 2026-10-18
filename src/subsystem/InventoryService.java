package subsystem;

import java.util.HashMap;
import java.util.Map;

public class InventoryService {
    private final Map<String, Integer> stock = new HashMap<>();

    public InventoryService() {
        stock.put("ITEM-101", 10);
        stock.put("ITEM-102", 0); // Out of stock
    }

    public boolean reserveStock(String itemId, int quantity) {
        int currentStock = stock.getOrDefault(itemId, 0);
        if (currentStock >= quantity) {
            stock.put(itemId, currentStock - quantity);
            System.out.println("[InventoryService] Reserved " + quantity + " units of " + itemId);
            return true;
        }
        System.out.println("[InventoryService] Failed to reserve " + itemId + ": Insufficient stock");
        return false;
    }

    public void releaseStock(String itemId, int quantity) {
        stock.put(itemId, stock.getOrDefault(itemId, 0) + quantity);
        System.out.println("[InventoryService] Released " + quantity + " units of " + itemId + " back to stock");
    }
}