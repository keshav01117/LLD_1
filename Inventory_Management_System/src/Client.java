import java.util.*;

public class Client {
    public static void main(String[] args){
        Item item1 = new Item("001", "Laptop", 1000, 10);
        Item item2 = new Item("004", "Mouse", 30, 50);
        Item item3 = new Item("003", "Keyboard", 80, 30);

        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);

        // Collections.sort(items);
        // System.out.println("Sorted Items:" + items);

        // System.out.println("Sorted Items:");
        // for (Item item : items) {
        //     System.out.println(item.getName() + ": " + item.getPrice() + " x " + item.getQuantity());
        // }

        Inventory<Item> inventory = new Inventory<>();
        inventory.addItem(item1);
        inventory.addItem(item2);
        inventory.addItem(item3);

        // System.out.println("All Items in Inventory:");
        // for (Item item : inventory.getAllItems()) {
        //     System.out.println(item.getId() + ": " + item.getName() + ": " + item.getPrice() + " x " + item.getQuantity());
        // }

        //After removing an item from the inventory
        // inventory.removeItem("004");

        // System.out.println("Items in Inventory after removal:");
        // for (Item item : inventory.getAllItems()) {
        //     System.out.println(item.getId() + ": " + item.getName() + ": " + item.getPrice() + " x " + item.getQuantity());
        // }

        // add duplicate id
        // Item item4 = new Item("003", "Monitor", 200, 20);
        // inventory.addItem(item4);
        // System.out.println("Items in Inventory after adding duplicate:");
        // for (Item item : inventory.getAllItems()) {
        //     System.out.println(item.getId() + ": " + item.getName() + ": " + item.getPrice() + " x " + item.getQuantity());
        // }

        // NOTE : Duplicate will overwrite the existing item with the same ID, so the inventory will now contain the new item with ID "003" (Monitor) instead of the old item (Keyboard).


    //     RecentlyViewedItems recentlyViewedItems = new RecentlyViewedItems();
    //     recentlyViewedItems.addRecentlyViewedItem(item1);
    //     recentlyViewedItems.addRecentlyViewedItem(item2);

    //     System.out.println("Recently Viewed Items:");
    //     for (Item item : recentlyViewedItems.getRecentlyViewed()) {
    //         System.out.println(item.getId() + ": " + item.getName() + ": " + item.getPrice() + " x " + item.getQuantity());
    //     }

    //     recentlyViewedItems.addRecentlyViewedItem(item3); // This will remove item1 from the list

    //     System.out.println("Recently Viewed Items:");
    //     for (Item item : recentlyViewedItems.getRecentlyViewed()) {
    //         System.out.println(item.getId() + ": " + item.getName() + ": " + item.getPrice() + " x " + item.getQuantity());
    //     }


        // Milestone 4: Process orders by prioritzing express orders using a PriorityQueue

        // System.out.println("=== Testing OrderProcessor ===\n");
        
        // // Create OrderProcessor instance
        // OrderProcessor processor = new OrderProcessor();
        
        // // Add multiple orders (mix of express and regular)
        // Order order1 = new Order("001", false);
        // Order order2 = new Order("002", true);
        // Order order3 = new Order("003", false);
        // Order order4 = new Order("004", true);
        // Order order5 = new Order("005", true);
        
        // System.out.println("Adding orders to processor:");
        // System.out.println("Order 001 - Regular");
        // System.out.println("Order 002 - Express");
        // System.out.println("Order 003 - Regular");
        // System.out.println("Order 004 - Express");
        // System.out.println("Order 005 - Express\n");
        
        // processor.addOrder(order1);
        // processor.addOrder(order2);
        // processor.addOrder(order3);
        // processor.addOrder(order4);
        // processor.addOrder(order5);
        
        // // Process and display orders in priority order
        // System.out.println("Processing orders (Express orders processed first):");
        // System.out.println("-----------------------------------------------");
        
        // Order processedOrder;
        // while ((processedOrder = processor.processNextOrder()) != null) {
        //     String orderType = processedOrder.isExpress() ? "Express" : "Regular";
        //     System.out.println("Order ID: " + processedOrder.getOrderId() + " | Type: " + orderType);
        // }
        
        // System.out.println("-----------------------------------------------");
        // System.out.println("All orders processed!\n");



        // milestone 5: Enable sorting and filtering of items based on different criteria (e.g., price, quantity, name) using Comparator.

        // implement custom comparator.
        System.out.println("\n=== Testing Custom Comparators ===\n");
        
        // Custom Comparator for sorting by price (ascending)
        Comparator<Item> priceComparator = new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                return Double.compare(item1.getPrice(), item2.getPrice());
            }
        };
        
        // Custom Comparator for sorting by quantity (ascending)
        Comparator<Item> quantityComparator = new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                return Integer.compare(item1.getQuantity(), item2.getQuantity());
            }
        };
        
        //test sorting and filtering methods with list of items.
        List<Item> allItems = inventory.getAllItems();
        System.out.println("All Items in Inventory:");
        for (Item item : allItems) {
            System.out.println(item.getId() + ": " + item.getName() + ": " + item.getPrice() + " x " + item.getQuantity());
        }

        // Sort items by price
        List<Item> sortedByPrice = inventory.filterByPriceRange(0, 10000);
        System.out.println("\nItems sorted by Price (Ascending):");
        for (Item item : sortedByPrice) {
            System.out.println(item);
        }

        List<Item> filteredByAvailability = inventory.filterByAvailability();
        System.out.println("\nItems filtered by Availability (Quantity > 0):");
        for (Item item : filteredByAvailability) {
            System.out.println(item);
        }


        //Milestone 6: Manage customer wishlist using a set to ensure uniqueness
        System.out.println("\n=== Testing Wishlist Functionality ===\n");
        
        // Create a wishlist
        Wishlist wishlist = new Wishlist();
        
        // Test 1: Add items to wishlist
        System.out.println("Test 1: Adding items to wishlist");
        System.out.println("--------------------------------");
        wishlist.addToWishlist(item1);  // Laptop
        wishlist.addToWishlist(item2);  // Mouse
        wishlist.addToWishlist(item3);  // Keyboard
        System.out.println();
        
        // Test 2: Display wishlist
        System.out.println("Test 2: Display Wishlist");
        System.out.println("------------------------");
        wishlist.displayWishlist();
        System.out.println();
        
        // Test 3: Try adding duplicate item (should show warning due to Set uniqueness)
        System.out.println("Test 3: Adding duplicate item (Testing Set uniqueness)");
        System.out.println("-----------------------------------------------------");
        wishlist.addToWishlist(item1);  // Try adding Laptop again
        System.out.println();
        
        // Test 4: Check if item is in wishlist
        System.out.println("Test 4: Checking if items are in wishlist");
        System.out.println("-----------------------------------------");
        System.out.println("Is Laptop in wishlist? " + wishlist.isInWishlist(item1));
        System.out.println("Is Monitor in wishlist? " + wishlist.isInWishlist(new Item("005", "Monitor", 300, 15)));
        System.out.println();
        
        // Test 5: Get wishlist size
        System.out.println("Test 5: Wishlist size");
        System.out.println("---------------------");
        System.out.println("Total items in wishlist: " + wishlist.getWishlistSize());
        System.out.println();
        
        // Test 6: Calculate total wishlist value
        System.out.println("Test 6: Calculate total wishlist value");
        System.out.println("--------------------------------------");
        double totalValue = wishlist.getTotalWishlistValue();
        System.out.println("Total Wishlist Value: $" + totalValue);
        System.out.println();
        
        // Test 7: Remove item from wishlist
        System.out.println("Test 7: Remove item from wishlist");
        System.out.println("---------------------------------");
        wishlist.removeFromWishlist(item2);  // Remove Mouse
        System.out.println();
        
        // Test 8: Display updated wishlist
        System.out.println("Test 8: Display updated wishlist");
        System.out.println("--------------------------------");
        wishlist.displayWishlist();
        System.out.println();
        
        // Test 9: Try removing item that's not in wishlist
        System.out.println("Test 9: Try removing item not in wishlist");
        System.out.println("-----------------------------------------");
        wishlist.removeFromWishlist(new Item("005", "Monitor", 300, 15));
        System.out.println();
        
        // Test 10: Clear wishlist
        System.out.println("Test 10: Clear wishlist");
        System.out.println("----------------------");
        wishlist.clearWishlist();
        wishlist.displayWishlist();

    }
}
