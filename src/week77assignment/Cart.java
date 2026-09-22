package week77assignment;

class Cart {
    private double[] prices;
    private int count;
    private final String cartId;

    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.prices = new double[maxItems];
        this.count = 0;
    }

    public void addItem(double price) {
        if (count < prices.length) {
            prices[count++] = price;
        } else {
            System.out.println("Cart full!");
        }
    }

    public double getTotal() {
        double sum = 0;
        for (int i = 0; i < count; i++) sum += prices[i];
        return sum;
    }

    public int getItemCount() {
        return count;
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

