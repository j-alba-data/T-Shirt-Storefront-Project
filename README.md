# T-Shirt Storefront

<img src=".image/shirts.png">

## Description

This project is a T-Shirt Storefront that has a CommandLine Interface (CLI). A shopper will be able to list available t-shirts, view and search t-shirts, add t-shirts to their cart, see their cart, and check out. Transactions will be simulated.

This project was built to demonstrate the use of object-oriented programming principles and data structures in Java. It also showcases how to use the Scanner class to interact with the user through the console.

## Installation / How to setup

To run this project, you will need to have Java installed on your machine. You can download Java from [here](https://www.java.com/en/download/).

You will also need to clone this repository to your local machine using the following command:

```
git clone https://github.com/j-alba-dev/T-Shirt-Storefront-Project.git
```

Alternatively, you can download the zip file of this repository and extract it to your preferred location.

## Quick start

To run the project, navigate to the src folder and compile all the Java files using the following command:

```
javac *.java
```

Then, run the ShopRunner class using the following command:

```
java ShopRunner
```

You should see a welcome message and a menu with different options. Follow the instructions on the screen to use the application.

## Usage reference

The project consists of five classes and one enum:

- ShopRunner: This is the main class that runs the application and creates an instance of Menu.
- Menu: This class handles the user interface and interaction. It has a Cart, a Shop, and a Scanner as its attributes. It also uses the MenuOption enum to display and handle different menu options.
- Shop: This class represents the shop that sells t-shirts. It has an ArrayList of Products as its attribute. It provides methods to list, view, and search products by name or category.
- Cart: This class represents the shopping cart of the user. It has an ArrayList of Products as its attribute. It provides methods to add, remove, and view products in the cart, as well as calculate the total price and check out.
- Product: This class represents a product that can be sold in the shop. It has a name, a price, and a category as its attributes. It also overrides the toString method to display its information.
- MenuOption: This is an enum that defines the possible menu options that the user can choose from. It has a value and a description as its attributes.

## Future features

Some possible features that can be added to this project are:

- Implementing a database or a file system to store and retrieve products and transactions.
- Adding more product categories and attributes, such as size, color, brand, etc.
- Adding more payment methods and validation logic for checking out.
- Adding more error handling and exception handling for user input and application logic.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

This project was inspired by Amazon Technical Academy's Prerequisite Course
