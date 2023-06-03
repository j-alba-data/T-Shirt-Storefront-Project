import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Menu class is responsible for greeting the user, showing a menu
 * to the user for interaction with the application.
 * The class maintains a String[] array of menu options, which it
 * uses for printing the menu to standard out.
 * The class is also responsible for responding to user interaction
 * with respect to its menu.
 */
public class Menu {
    private Cart cart;
    private Shop shop;
    private MenuOption[] menuOpts = MenuOption.values();
    private Scanner scanner;

    /**
     * Class constructor, which expects a Scanner object
     * It allows for the user to specify how a Scanner is to
     * be configured outside this class and for basic inversion of control.
     * @param scanner takes in a Scanner object to initialize
     * @param shop takes in an array of product objects
     * @param cart updates and checks out items in cart
     */
    public Menu(Scanner scanner, Shop shop, Cart cart) {
        this.scanner = scanner;
        this.shop = shop;
        this.cart = cart;
    }

    /**
     * Prints the menu to standard output, using the class's menuOptions array.
     * It accepts user input using the encapsulated Scanner instance.
     * All output is printed to standard out.
     * All input is collected from standard in.
     */
    public void executeMenu() {
        printMenu();
        while (scanner.hasNextInt()) {

            int userInput = getNextIntFromUser();
            if (userInput == 0) {
                exit();
                break;
            }
            if (userInput < 0 || userInput > 5) {
                System.out.println("Please enter a valid option from Main Menu");
                printMenu();
            } else {
                handleShopperMenuOptionSelection(getNextOptionFromUser(userInput));
            }
        }
    }

    /**
     * Asks the user to enter their name.
     * After the user provides their name, it outputs a greeting to the user to standard out.
     */
    public void greet() {
        System.out.println("Hello. Please enter your name:");
        String name = scanner.nextLine();
        String storeName = shop.getName();
        System.out.println(String.format("Welcome %s to %s", name, storeName));
    }

    /**
     * Prints the menu header and menu options.
     */
    private void printMenu() {
        StringBuilder pMenu = new StringBuilder();
        pMenu.append("\n");
        pMenu.append("--Main Menu--");
        pMenu.append("\n");
        pMenu.append("Select an option using one of the numbers shown");
        pMenu.append("\n");
        for (int i = 0; i < menuOpts.length; i++) {
            pMenu.append(String.format("\n%d: %s", i, menuOpts[i].getDisplayValue()));
        }
        System.out.println(pMenu);
    }

    /**
     * Collects next user-entered int.
     * @return integer value denoting the user selection
     */
    private int getNextIntFromUser() {
        return scanner.nextInt();
    }

    private MenuOption getNextOptionFromUser(int userSelectInt) {
        return MenuOption.fromOptionId(userSelectInt);
    }

    /**
     * Skips a line of empty input from the scanner's input stream
     * and then returns the next available line.
     * @return string representing the line of input typed by the user
     */
    private String getNextStringLineFromUser() {
        scanner.nextLine();
        return scanner.nextLine();
    }

    /**
     * Prints an exit statement and closes the scanner object.
     */
    private void exit() {
        System.out.println("Exiting now. Goodbye.");
        scanner.close();
    }

    private void handleShopperMenuOptionSelection(MenuOption option) {
        switch (option.getId()) {
            case 1:
                shop.printProducts();
                printMenu();
                break;
            case 2:
                System.out.println("Please enter the ID of the product you would like to purchase:");
                int prodID = getNextIntFromUser();
                if (prodID >= 0 && prodID < 5) {
                    Product selectedProduct = shop.getProductById(prodID);
                    cart.addItem(selectedProduct);
                    String itemName = selectedProduct.getName();
                    System.out.printf("%s has been added to your cart.", itemName);
                    System.out.println();
                    printMenu();
                } else {
                    System.out.println("That item ID is invalid and could not be added to the cart.");
                    printMenu();
                }
                break;
            case 3:
                System.out.println("Enter the item to search for:");
                String itemToFind = getNextStringLineFromUser();
                int prodIndex = shop.findProduct(itemToFind);
                if (prodIndex >= 0) {
                    System.out.println(itemToFind + " was found and its product id is " + prodIndex);
                    printMenu();
                } else {
                    System.out.println("That product was not found.");
                    printMenu();
                }
                break;
            case 4:
                if (cart.getCartQty() > 0) {
                    cart.showDetails();
                    printMenu();
                } else {
                    System.out.println("The cart is empty. Please add at least one product to see it in the cart.");
                    printMenu();
                }
                break;
            case 5:
                boolean isCheckedOut = false;
                if (cart.getCartQty() > 0) {
                    isCheckedOut = cart.checkout();

                    if (isCheckedOut) {
                        BigDecimal total = cart.getTotal();
                        String storeName = shop.getName();
                        String totalMessage = String.format("Your total is $%.2f", total);
                        String thankYouMessage = String.format("Thank you for shopping at %s.", storeName);
                        System.out.println(totalMessage);
                        System.out.println(thankYouMessage);
                    }
                } else {
                    System.out.println("Your cart is currently empty. Please add at least one product to check out.");
                }
                printMenu();
                break;
            default:
                System.out.println("Please enter a valid option from Main Menu");
                break;
        }
    }
}
