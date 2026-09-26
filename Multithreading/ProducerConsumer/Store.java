package ProducerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Store {

    private int maxSize;
    private List<Object> items;
    private Lock lock = new ReentrantLock();

    public Store(int maxSize) {
        this.maxSize = maxSize;
        this.items = new ArrayList<>(maxSize);
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

    public void addItem(Object item) {
        lock.lock();
        items.add(item);  // O(1)
        System.out.println("Producer has added an item. Size of items: " + items.size());
        lock.unlock();
    }

    public void removeItem() {
        lock.lock();
        items.remove(items.size() - 1);
        System.out.println("Consumer has consume. Size of items: " + items.size());
        lock.unlock();
    }
}