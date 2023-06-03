import java.math.BigDecimal;

public class Product {
    private int id;
    private String name;
    private BigDecimal price;

    public Product(int id, String name, BigDecimal price) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public int getID() {
        return this.id;
    }
}
