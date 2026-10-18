import facade.OrderFacade;

public class Main {
    public static void main(String[] args) {
        OrderFacade orderFacade = new OrderFacade();

        // Test Case 1: Successful Order
        orderFacade.placeOrder(
                "CUST-001", "alice@example.com", "ITEM-101", 2, 49.99, "CARD-1234-OK", "123 Main St, Astana"
        );

        // Test Case 2: Rollback on Payment Failure
        orderFacade.placeOrder(
                "CUST-002", "bob@example.com", "ITEM-101", 1, 99.99, "INVALID-CARD", "456 Abay Ave, Almaty"
        );

        // Test Case 3: Stock Failure
        orderFacade.placeOrder(
                "CUST-003", "charlie@example.com", "ITEM-102", 1, 150.00, "CARD-1234-OK", "789 Mangilik El, Astana"
        );
    }
}