package shoppingcart;

public class ShoppingCartDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Adding products
        cart.addProduct("Apple", 1.20);
        cart.addProduct("Banana", 0.75);
        cart.addProduct("Cherry", 2.50);
        cart.addProduct("Banana", 0.75);
        cart.addProduct("Apple", 1.20);

        // Displaying Cart Details
        System.out.println("Cart Order: " + cart.getCartOrder());
        System.out.println("Sorted by Price: " + cart.getSortedByPrice());
        System.out.println("Total Price: $" + cart.getTotalPrice());

        // Removing a product
        cart.removeProduct("Banana");
        System.out.println("Cart Order after removing one Banana: " + cart.getCartOrder());
    }
}

