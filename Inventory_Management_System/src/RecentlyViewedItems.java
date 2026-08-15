import java.util.*;

public class RecentlyViewedItems {
    private LinkedList<Item> recentlyViewed;

    public RecentlyViewedItems() {
        this.recentlyViewed = new LinkedList<>();
    }

    public void addRecentlyViewedItem(Item item) {
        recentlyViewed.add(item);
        if (recentlyViewed.size() > 2) {
            recentlyViewed.removeFirst();
        }
    }

    public List<Item> getRecentlyViewed() {
        return new ArrayList<>(recentlyViewed);
    }
}
