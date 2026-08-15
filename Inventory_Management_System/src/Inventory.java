import java.util.*;

public class Inventory<T extends Item> {
    private HashMap<String, T> items;

    public Inventory() {
        this.items = new HashMap<>();
    }

    public void addItem(T item) {
        if(item.getQuantity() <= 0) {
            System.out.println("Cannot add item with zero or negative quantity.");
            return;
        }
        items.put(item.getId(), item);
    }

    public void removeItem(String itemId) {
        if(items.get(itemId) == null) {
            System.out.println("Item with ID: " + itemId + " does not exist in the inventory.");
            return;
        }
        System.out.println("Removing item with ID: " + itemId);
        items.remove(itemId);
    }

    public T getItem(String id){
        return items.get(id);
    }

    public List<T> getAllItems() {
        return new ArrayList<>(items.values());
    }

}
