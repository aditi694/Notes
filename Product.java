import java.util.List;

public class Product {

    private String name;
    private String category;
    private double price;
    private int quantity;
    private boolean inStock;
    private List<Review> reviews;

    public Product(String name, String category, double price,
                   int quantity, boolean inStock,
                   List<Review> reviews) {

        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.inStock = inStock;
        this.reviews = reviews;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public boolean isInStock() { return inStock; }
    public List<Review> getReviews() { return reviews; }
}