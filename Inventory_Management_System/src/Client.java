import java.util.*;

public class Client {
    public static void main(String[] args){
        Item item1 = new Item("001", "Laptop", 999.99, 10);
        Item item2 = new Item("004", "Mouse", 29.99, 50);
        Item item3 = new Item("003", "Keyboard", 79.99, 30);

        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);

        Collections.sort(items);

        System.out.println("Sorted Items:");
        for (Item item : items) {
            System.out.println(item.getName() + ": " + item.getPrice() + " x " + item.getQuantity());
        }

    }
}
