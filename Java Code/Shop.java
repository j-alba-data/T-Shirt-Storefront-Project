import java.util.ArrayList;
public class Shop {

    private String name;

    private ArrayList<Product> products;

    public Shop(String name, ArrayList<Product> products) {
        this.name = name;
        this.products = new ArrayList<Product>(products);
    }

    public String getName() {
        return this.name;
    }

    public void printProducts() {
        System.out.println("--Products--");

        for (Product product : products) {
            String formattedProduct = String.format("ID %d: %s - $%.2f",
                    product.getID(), product.getName(), product.getPrice());

            System.out.println(formattedProduct);
        }
    }

    public int findProduct(String searchText) {
        int prodIndex = -1;
        for (Product product : products) {
            String prod = product.getName();
            if (searchText.equals(prod)) {
                prodIndex = product.getID();
            }
        } return prodIndex;
    }

    public Product getProductById(int id) {
        return products.get(id);
    }
}
