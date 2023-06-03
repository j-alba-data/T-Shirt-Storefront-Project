import java.math.BigDecimal;
import java.util.ArrayList;

public class Cart {

    private ArrayList<Product> items = new ArrayList<>();
    private BigDecimal total = new BigDecimal("0.00");
    private double taxRate;

    private StringBuilder cartDetails = new StringBuilder();
    public void addItem(Product p) {
        items.add(p);
        total = total.add(p.getPrice());
        taxRate += p.getPrice().doubleValue() * .10;
    }

    public void showDetails() {
        appendCartHeaderToStringBuilder(cartDetails);
        appendItemsWithPricesToStringBuilder(cartDetails);
        appendCartTotalsToStringBuilder(cartDetails);
        System.out.println(cartDetails);
    }
    public int getCartQty() {
        return items.size();
    }
    public BigDecimal getTotal() {
        BigDecimal postTaxTotal = total.add(BigDecimal.valueOf(taxRate));
        return postTaxTotal;
    }
    public boolean checkout() {
        clearCart();
        return true;
    }
    private void clearCart() {
        items.clear();
    }
    private void appendCartHeaderToStringBuilder(StringBuilder sb) {
        sb.append("--Cart--");
    }
    private void appendItemsWithPricesToStringBuilder(StringBuilder sb) {
        sb.append("\n");
        int itemsArraySize = items.size();
        String currentCountMessage = String.format("Item Count: %d", itemsArraySize);
        sb.append(currentCountMessage);
        sb.append("\n");
        sb.append("Items:");
        sb.append("\n");
        for (Product item : items) {
            String itemName = item.getName();
            BigDecimal itemPrice = item.getPrice();
            String currentItemsMessage = String.format("%s: $%.2f", itemName, itemPrice);
            sb.append(currentItemsMessage);
            sb.append("\n");
        }
    }

    private void appendCartTotalsToStringBuilder(StringBuilder sb) {
        BigDecimal preTaxTotal = total;
        BigDecimal postTaxTotal = total.add(BigDecimal.valueOf(taxRate));
        sb.append("\n");
        String preTaxTotalMessage = String.format("Pre-Tax Total: $%.2f", preTaxTotal);
        String postTaxTotalMessage = String.format("Post-Tax Total (10.00%% Tax): $%.2f", postTaxTotal);
        sb.append(preTaxTotalMessage);
        sb.append("\n");
        sb.append(postTaxTotalMessage);
    }
}
