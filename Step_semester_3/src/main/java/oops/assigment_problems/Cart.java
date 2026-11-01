public class Cart {
    private final double[] itemPrices;
    private final String cartId;
    private int itemCount;

    public Cart(String cartId, int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        this.cartId = cartId;
        itemPrices = new double[capacity];
        itemCount = 0;
    }

    public boolean addItem(double price) {
        if (price < 0 || itemCount >= itemPrices.length) {
            return false;
        }
        itemPrices[itemCount] = price;
        itemCount++;
        return true;
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += itemPrices[i];
        }
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getCartId() {
        return cartId;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}
