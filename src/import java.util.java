import java.util.Scanner;

// Enum for pizza selection
enum PizzaSelection {
    PEPPERONI("Pepperoni", "Lots of pepperoni and extra cheese", 18),
    HAWAIIAN("Hawaiian", "Pineapple, ham, and extra cheese", 22),
    VEGGIE("Veggie", "Green pepper, onion, tomatoes, mushroom, and black olives", 25),
    BBQ_CHICKEN("BBQ Chicken", "Chicken in BBQ sauce, bacon, onion, green pepper, and cheddar cheese", 35),
    EXTRAVAGANZA("Extravaganza", "Pepperoni, ham, Italian sausage, beef, onions, green pepper, mushrooms, black olives, and extra cheese", 45);

    private final String pizzaName;
    private final String pizzaToppings;
    private final int price;

    PizzaSelection(String pizzaName, String pizzaToppings, int price) {
        this.pizzaName = pizzaName;
        this.pizzaToppings = pizzaToppings;
        this.price = price;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public String getPizzaToppings() {
        return pizzaToppings;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return pizzaName + " Pizza with " + pizzaToppings + ", for €" + price;
    }
}

// Enum for pizza toppings
enum PizzaToppings {
    HAM("Ham", 2),
    PEPPERONI("Pepperoni", 2),
    BEEF("Beef", 2),
    CHICKEN("Chicken", 2),
    SAUSAGE("Sausage", 2),
    PINEAPPLE("Pineapple", 1),
    ONION("Onion", 0.5),
    TOMATOES("Tomatoes", 0.4),
    GREEN_PEPPER("Green Pepper", 0.5),
    BLACK_OLIVES("Black Olives", 0.5),
    SPINACH("Spinach", 0.5),
    CHEDDAR_CHEESE("Cheddar Cheese", 0.8),
    MOZZARELLA_CHEESE("Mozzarella Cheese", 0.8),
    FETA_CHEESE("Feta Cheese", 1),
    PARMESAN_CHEESE("Parmesan Cheese", 1);

    private final String topping;
    private final double toppingPrice;

    PizzaToppings(String topping, double toppingPrice) {
        this.topping = topping;
        this.toppingPrice = toppingPrice;
    }

    public String getTopping() {
        return topping;
    }

    public double getToppingPrice() {
        return toppingPrice;
    }

    @Override
    public String toString() {
        return topping;
    }
}

// Enum for pizza size
enum PizzaSize {
    LARGE("Large", 10),
    MEDIUM("Medium", 5),
    SMALL("Small", 0);

    private final String pizzaSize;
    private final int addToPizzaPrice;

    PizzaSize(String pizzaSize, int addToPizzaPrice) {
        this.pizzaSize = pizzaSize;
        this.addToPizzaPrice = addToPizzaPrice;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public int getAddToPizzaPrice() {
        return addToPizzaPrice;
    }

    @Override
    public String toString() {
        return pizzaSize + ": €" + addToPizzaPrice;
    }
}

// Enum for side dishes
enum SideDish {
    CALZONE("Calzone", 15),
    CHICKEN_PUFF("Chicken Puff", 20),
    MUFFIN("Muffin", 12),
    NOTHING("No side dish", 0);

    private final String sideDishName;
    private final int addToPizzaPrice;

    SideDish(String sideDishName, int addToPizzaPrice) {
        this.sideDishName = sideDishName;
        this.addToPizzaPrice = addToPizzaPrice;
    }

    public String getSideDishName() {
        return sideDishName;
    }

    public int getAddToPizzaPrice() {
        return addToPizzaPrice;
    }

    @Override
    public String toString() {
        return sideDishName + ": €" + addToPizzaPrice;
    }
}

// Enum for drinks
enum Drinks {
    COCA_COLA("Coca Cola", 8),
    COCOA_DRINK("Cocoa Drink", 10),
    NOTHING("No drinks", 0);

    private final String drinkName;
    private final int addToPizzaPrice;

    Drinks(String drinkName, int addToPizzaPrice) {
        this.drinkName = drinkName;
        this.addToPizzaPrice = addToPizzaPrice;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public int getAddToPizzaPrice() {
        return addToPizzaPrice;
    }

    @Override
    public String toString() {
        return drinkName + ": €" + addToPizzaPrice;
    }
}

public class PizzaOrderingSystem {
    private static final double PIZZA_BASE_PRICE = 10.0;
    private static String[] pizzasOrdered = new String[10];
    private static String[] pizzaSizesOrdered = new String[10];
    private static String[] sideDishesOrdered = new String[20];
    private static String[] drinksOrdered = new String[20];
    private static double totalOrderPrice = 0;
    private static int pizzaIndex = 0;
    private static int sideDishIndex = 0;
    private static int drinkIndex = 0;

    public static void takeOrder() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to Slice - o - Heaven Pizzeria. Here’s what we serve:");
            PizzaSelection[] pizzaSelections = PizzaSelection.values();
            for (int i = 0; i < pizzaSelections.length; i++) {
                System.out.println((i + 1) + ". " + pizzaSelections[i]);
            }
            System.out.println((pizzaSelections.length + 1) + ". Custom Pizza with a maximum of 10 toppings that you choose");
            System.out.print("Please enter your choice (1 - " + (pizzaSelections.length + 1) + "): ");
            int pizzaChoice = scanner.nextInt();
            scanner.nextLine();

            if (pizzaChoice >= 1 && pizzaChoice <= pizzaSelections.length) {
                PizzaSelection selectedPizza = pizzaSelections[pizzaChoice - 1];
                pizzasOrdered[pizzaIndex] = selectedPizza.toString();
                totalOrderPrice += selectedPizza.getPrice();
            } else if (pizzaChoice == pizzaSelections.length + 1) {
                System.out.println("Available toppings:");
                PizzaToppings[] toppings = PizzaToppings.values();
                for (int i = 0; i < toppings.length; i++) {
                    System.out.println((i + 1) + ". " + toppings[i]);
                }
                System.out.print("Enter up to 10 toppings separated by commas (e.g., 1,2,3): ");
                String input = scanner.nextLine();
                String[] toppingChoices = input.split(",");
                double customPizzaPrice = PIZZA_BASE_PRICE;
                StringBuilder toppingNames = new StringBuilder();
                for (String choice : toppingChoices) {
                    int toppingIndex = Integer.parseInt(choice) - 1;
                    if (toppingIndex >= 0 && toppingIndex < toppings.length) {
                        customPizzaPrice += toppings[toppingIndex].getToppingPrice();
                        if (toppingNames.length() > 0) {
                            toppingNames.append(", ");
                        }
                        toppingNames.append(toppings[toppingIndex].getTopping());
                    }
                }
                pizzasOrdered[pizzaIndex] = "Custom Pizza with " + toppingNames + ", for €" + customPizzaPrice;
                totalOrderPrice += customPizzaPrice;
            }

            System.out.println("Choose a pizza size:");
            PizzaSize[] sizes = PizzaSize.values();
            for (int i = 0; i < sizes.length; i++) {
                System.out.println((i + 1) + ". " + sizes[i]);
            }
            System.out.print("Enter your choice: ");
            int sizeChoice = scanner.nextInt();
            scanner.nextLine();
            PizzaSize selectedSize = sizes[sizeChoice - 1];
            pizzaSizesOrdered[pizzaIndex] = selectedSize.getPizzaSize();
            totalOrderPrice += selectedSize.getAddToPizzaPrice();

            System.out.println("Choose a side dish:");
            SideDish[] sideDishes = SideDish.values();
            for (int i = 0; i < sideDishes.length; i++) {
                System.out.println((i + 1) + ". " + sideDishes[i]);
            }
            System.out.print("Enter your choice: ");
            int sideDishChoice = scanner.nextInt();
            scanner.nextLine();
            SideDish selectedSideDish = sideDishes[sideDishChoice - 1];
            sideDishesOrdered[sideDishIndex] = selectedSideDish.getSideDishName();
            totalOrderPrice += selectedSideDish.getAddToPizzaPrice();

            System.out.println("Choose a drink:");
            Drinks[] drinkOptions = Drinks.values();
            for (int i = 0; i < drinkOptions.length; i++) {
                System.out.println((i + 1) + ". " + drinkOptions[i]);
            }
            System.out.print("Enter your choice: ");
            int drinkChoice = scanner.nextInt();
            scanner.nextLine();
            Drinks selectedDrink = drinkOptions[drinkChoice - 1];
            drinksOrdered[drinkIndex] = selectedDrink.getDrinkName();
            totalOrderPrice += selectedDrink.getAddToPizzaPrice();

            pizzaIndex++;
            sideDishIndex++;
            drinkIndex++;

            System.out.print("Do you want to order more? (yes/no): ");
            String moreOrder = scanner.nextLine();
            if (!moreOrder.equalsIgnoreCase("yes")) {
                break;
            }
        }
        scanner.close();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Thank you for dining with Slice - o - Heaven Pizzeria. Your order details are as follows:\n");
        for (int i = 0; i < pizzaIndex; i++) {
            result.append(i + 1).append(". ").append(pizzasOrdered[i]).append("\n");
            PizzaSize size = PizzaSize.valueOf(pizzaSizesOrdered[i].toUpperCase());
            result.append(size).append("\n");
            SideDish sideDish = null;
            for (SideDish dish : SideDish.values()) {
                if (dish.getSideDishName().equals(sideDishesOrdered[i])) {
                    sideDish = dish;
                    break;
                }
            }
            result.append(sideDish).append("\n");
            Drinks drink = null;
            for (Drinks d : Drinks.values()) {
                if (d.getDrinkName().equals(drinksOrdered[i])) {
                    drink = d;
                    break;
                }
            }
            result.append(drink).append("\n");
        }
        result.append("ORDER TOTAL: €").append(totalOrderPrice);
        return result.toString();
    }

    public static void main(String[] args) {
        takeOrder();
        PizzaOrderingSystem system = new PizzaOrderingSystem();
        System.out.println(system);
    }
}