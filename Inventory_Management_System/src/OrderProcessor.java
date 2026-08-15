import java.util.Comparator;
import java.util.PriorityQueue;


public class OrderProcessor implements Comparator<Order> {
    private PriorityQueue<Order> orderQueue ;

    public OrderProcessor() {
        orderQueue = new PriorityQueue<>(this);
    }

    public void addOrder(Order order) {
        orderQueue.offer(order);
    }

    public Order processNextOrder() {
        return orderQueue.poll();
    }

    @Override
    public int compare(Order o1, Order o2) {
        if(o1.isExpress() && o2.isExpress()) {
            return o1.getOrderId().compareTo(o2.getOrderId());
        }
        if(o1.isExpress()) {
            return -1;
        }
        return 1;
    }
    
}
