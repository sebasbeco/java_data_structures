package GEANT;

/**
 *
 * @author seba
 */
public class Product {
    
    private String name;
    private String id;
    private double price;
    private int stock;
    
    public Product(String name, String id, double price, int stock) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public int currentStock() {
        return stock;
    }

    public void changePrice(float newPrice) {
        price = newPrice;
    }    
    
    public void addStock(int stock) {
        this.stock += stock;
    }
    
    public void reduceStock(int units) throws Exception {
        if (units <= stock)
            stock -= units;
        else
            throw new Exception("insuficient stock");
    }
    
}
