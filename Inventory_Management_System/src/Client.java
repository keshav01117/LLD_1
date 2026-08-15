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


        RecentlyViewedItems recentlyViewedItems = new RecentlyViewedItems();
        recentlyViewedItems.addRecentlyViewedItem(item1);
        recentlyViewedItems.addRecentlyViewedItem(item2);

        System.out.println("Recently Viewed Items:");
        for (Item item : recentlyViewedItems.getRecentlyViewed()) {
            System.out.println(item.getId() + ": " + item.getName() + ": " + item.getPrice() + " x " + item.getQuantity());
        }

        recentlyViewedItems.addRecentlyViewedItem(item3); // This will remove item1 from the list

        System.out.println("Recently Viewed Items:");
        for (Item item : recentlyViewedItems.getRecentlyViewed()) {
            System.out.println(item.getId() + ": " + item.getName() + ": " + item.getPrice() + " x " + item.getQuantity());
        }
    }
}
