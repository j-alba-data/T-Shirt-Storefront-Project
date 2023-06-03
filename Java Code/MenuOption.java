public enum MenuOption {
    EXIT,
    LIST_PRODUCTS,
    BUY_PRODUCT,
    FIND_PRODUCT,
    SHOW_CART,
    CHECKOUT;

    private int id;
    private String displayValue;

    public int getId() {
        for (int i = 0; i < MenuOption.values().length; i++) {
            if (this.equals(MenuOption.values()[i])) {
                id = i;
            }
        }
        return id;
    }
    public String getDisplayValue() {
        String[] words = this.name().replace("_", " ").toLowerCase().split("\\s");
        displayValue = "";
        for (String w : words) {
            String first = w.substring(0, 1);
            String afterFirst = w.substring(1);
            displayValue += first.toUpperCase() + afterFirst + " ";
        }
        return displayValue.trim();
    }
    public static MenuOption fromOptionId(int optionId) {
        MenuOption optionFromMenu = null;
        for (MenuOption menuOption : MenuOption.values()) {
            if (menuOption.equals(MenuOption.values()[optionId])) {
                optionFromMenu = menuOption;
            }
        }
        return optionFromMenu;
    }
}
