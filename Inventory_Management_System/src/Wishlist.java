import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class Wishlist {
    private Set<Item> wishlistItems;

    public Wishlist() {
        this.wishlistItems = new HashSet<>();
    }

    // Add item to wishlist (ensures uniqueness via Set)
    public void addToWishlist(Item item) {
        if (item != null) {
            if (wishlistItems.add(item)) {
                System.out.println("✓ Added '" + item.getName() + "' to wishlist");
            } else {
                System.out.println("⚠ '" + item.getName() + "' is already in your wishlist");
            }
        }
    }

    // Remove item from wishlist
    public void removeFromWishlist(Item item) {
        if (item != null && wishlistItems.remove(item)) {
            System.out.println("✓ Removed '" + item.getName() + "' from wishlist");
        } else {
            System.out.println("⚠ '" + item.getName() + "' not found in wishlist");
        }
    }

    // Check if item is in wishlist
    public boolean isInWishlist(Item item) {
        return wishlistItems.contains(item);
    }

    // Get all wishlist items
    public Set<Item> getWishlistItems() {
        return new HashSet<>(wishlistItems);
    }

    // Get the size of wishlist
    public int getWishlistSize() {
        return wishlistItems.size();
    }

    // Display all wishlist items
    public void displayWishlist() {
        if (wishlistItems.isEmpty()) {
            System.out.println("Your wishlist is empty");
            return;
        }
        
        System.out.println("=== Your Wishlist ===");
        int index = 1;
        for (Item item : wishlistItems) {
            System.out.println(index + ". " + item.getName() + " - $" + item.getPrice() + " (Qty: " + item.getQuantity() + ")");
            index++;
        }
        System.out.println("Total items: " + wishlistItems.size());
    }

    // Clear entire wishlist
    public void clearWishlist() {
        wishlistItems.clear();
        System.out.println("✓ Wishlist cleared");
    }

    // Calculate total value of wishlist
    public double getTotalWishlistValue() {
        return wishlistItems.stream()
                .mapToDouble(Item::getPrice)
                .sum();
    }
}
