package shoppingcart;

import java.util.*;

public class ShoppingCart {
    // Store product prices
    private Map<String, Double> productPrices;

    // Maintain order of items added
    private Map<String, Integer> cartOrder;

    public ShoppingCart() {
        productPrices = new HashMap<>();
        cartOrder = new LinkedHashMap<>();
    }

    // Add a product with its price
    public void addProduct(String product, double price) {
        productPrices.put(product, price);
        cartOrder.put(product, cartOrder.getOrDefault(product, 0) + 1);
    }

    // Remove a product from the cart
    public void removeProduct(String product) {
        if (cartOrder.containsKey(product)) {
            int quantity = cartOrder.get(product);
            if (quantity > 1) {
                cartOrder.put(product, quantity - 1);
            } else {
                cartOrder.remove(product);
            }
        }
    }

    // Get total price of all items in the cart
    public double getTotalPrice() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cartOrder.entrySet()) {
            total += productPrices.get(entry.getKey()) * entry.getValue();
        }
        return total;
    }

    // Display items in the order they were added
    public Map<String, Integer> getCartOrder() {
        return new LinkedHashMap<>(cartOrder);
    }

    // Display items sorted by price (ascending order)
    public Map<String, Double> getSortedByPrice() {
        TreeMap<String, Double> sortedByPrice = new TreeMap<>(Comparator.comparingDouble(productPrices::get));
        sortedByPrice.putAll(productPrices);
        return sortedByPrice;
    }
}
