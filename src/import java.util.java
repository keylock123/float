import java.util.Scanner;
import java.time.LocalDate;
import java.time.Year;

public class Slice_o_Heaven {
    // Constants
    public static final String BLACKLISTED_NUMBER = "12345678901234";

    // Variables
    private String ing1;
    private String ing2;
    private String ing3;
    private String pizzaSize;
    private String extraCheese;
    private String sideDish;
    private String drinks;
    private String halfPay;
    private LocalDate birthday;
    private String cardNumber;
    private LocalDate cardExpiry;


    public void takeOrder() {
        Scanner scanner = new Scanner(System.in);
        boolean validIngredients = false;
        while (!validIngredients) {
            System.out.println("Please pick any three of the following ingredients:");
            System.out.println("1. Mushroom");
            System.out.println("2. Paprika");
            System.out.println("3. Sun - dried tomatoes");
            System.out.println("4. Chicken");
            System.out.println("5. Pineapple");
            System.out.print("Enter any three choices (1, 2, 3,...) separated by spaces:");

            int ingChoice1 = scanner.nextInt();
            int ingChoice2 = scanner.nextInt();
            int ingChoice3 = scanner.nextInt();

            if (isValidIngredientChoice(ingChoice1) && isValidIngredientChoice(ingChoice2) && isValidIngredientChoice(ingChoice3)) {
                ing1 = getIngredientName(ingChoice1);
                ing2 = getIngredientName(ingChoice2);
                ing3 = getIngredientName(ingChoice3);
                validIngredients = true;
            } else {
                System.out.println("Invalid choice(s). Please pick only from the given list:");
            }
        }

        boolean validSize = false;
        while (!validSize) {
            System.out.println("What size should your pizza be?");
            System.out.println("1. Large");
            System.out.println("2. Medium");
            System.out.println("3. Small");
            System.out.print("Enter only one choice (1, 2, or 3):");
            int sizeChoice = scanner.nextInt();
            if (sizeChoice >= 1 && sizeChoice <= 3) {
                switch (sizeChoice) {
                    case 1:
                        pizzaSize = "Large";
                        break;
                    case 2:
                        pizzaSize = "Medium";
                        break;
                    case 3:
                        pizzaSize = "Small";
                        break;
                }
                validSize = true;
            } else {
                System.out.println("Invalid choice. Please pick from the given options.");
            }
        }

        System.out.print("Do you want extra cheese (Y/N):");
        extraCheese = scanner.next();

        boolean validSideDish = false;
        while (!validSideDish) {
            System.out.println("Following are the side dish that go well with your pizza:");
            System.out.println("1. Calzone");
            System.out.println("2. Garlic bread");
            System.out.println("3. Chicken puff");
            System.out.println("4. Muffin");
            System.out.println("5. Nothing for me");
            System.out.print("What would you like? Pick one (1, 2, 3,...):");
            int sideDishChoice = scanner.nextInt();
            if (sideDishChoice >= 1 && sideDishChoice <= 5) {
                sideDish = getSideDishName(sideDishChoice);
                validSideDish = true;
            } else {
                System.out.println("Invalid choice. Please pick from the given options.");
            }
        }

        boolean validDrink = false;
        while (!validDrink) {
            System.out.println("Choose from one of the drinks below. We recommend Coca Cola:");
            System.out.println("1. Coca Cola");
            System.out.println("2. Cold coffee");
            System.out.println("3. Cocoa Drink");
            System.out.println("4. No drinks for me");
            System.out.print("Enter your choice:");
            int drinkChoice = scanner.nextInt();
            if (drinkChoice >= 1 && drinkChoice <= 4) {
                drinks = getDrinkName(drinkChoice);
                validDrink = true;
            } else {
                System.out.println("Invalid choice. Please pick from the given options.");
            }
        }

        System.out.print("Would you like the chance to pay only half for your order? (Y/N):");
        halfPay = scanner.next();
    }

    private boolean isValidIngredientChoice(int choice) {
        return choice >= 1 && choice <= 5;
    }

    private String getIngredientName(int choice) {
        switch (choice) {
            case 1:
                return "Mushroom";
            case 2:
                return "Paprika";
            case 3:
                return "Sun - dried tomatoes";
            case 4:
                return "Chicken";
            case 5:
                return "Pineapple";
            default:
                return "";
        }
    }

    private String getSideDishName(int choice) {
        switch (choice) {
            case 1:
                return "Calzone";
            case 2:
                return "Garlic bread";
            case 3:
                return "Chicken puff";
            case 4:
                return "Muffin";
            case 5:
                return "Nothing for me";
            default:
                return "";
        }
    }

    private String getDrinkName(int choice) {
        switch (choice) {
            case 1:
                return "Coca Cola";
            case 2:
                return "Cold coffee";
            case 3:
                return "Cocoa Drink";
            case 4:
                return "No drinks for me";
            default:
                return "";
        }
    }


    public void isItYourBirthday() {
        Scanner scanner = new Scanner(System.in);
        boolean validDate = false;
        while (!validDate) {
            System.out.print("Is it your birthday today? Enter your birth date (YYYY-MM-DD): ");
            String input = scanner.nextLine();
            try {
                birthday = LocalDate.parse(input);
                int currentYear = Year.now().getValue();
                int birthYear = birthday.getYear();
                int age = currentYear - birthYear;
                if (age >= 5 && age <= 120) {
                    validDate = true;
                } else {
                    System.out.println("Invalid date. You are either too young or too dead to order.");
                    System.out.println("Please enter a valid date:");
                }
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter a valid date (YYYY-MM-DD).");
            }
        }
    }


    public void makeCardPayment() {
        Scanner scanner = new Scanner(System.in);
        boolean validExpiry = false;
        while (!validExpiry) {
            System.out.print("Enter your card's expiry date (YYYY-MM-DD): ");
            String input = scanner.nextLine();
            try {
                cardExpiry = LocalDate.parse(input);
                if (cardExpiry.isAfter(LocalDate.now())) {
                    validExpiry = true;
                } else {
                    System.out.println("Invalid expiry date. Please enter a future date.");
                }
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter a valid date (YYYY-MM-DD).");
            }
        }
    }


    public void processCardPayment() {
        Scanner scanner = new Scanner(System.in);
        boolean validCard = false;
        while (!validCard) {
            System.out.print("Enter your 14 - digit card number: ");
            cardNumber = scanner.nextLine();
            if (cardNumber.length() == 14 &&!cardNumber.equals(BLACKLISTED_NUMBER)) {
                validCard = true;
            } else {
                System.out.println("Invalid card number. Please enter a 14 - digit number not on the blacklist.");
            }
        }
    }


    public String specialOfTheDay() {
        return "Today's special: Pizza with Mushroom and Sun - dried tomatoes!";
    }


    @Override
    public String toString() {
        return "Your order details:\n" +
                "Pizza size: " + pizzaSize + "\n" +
                "Ingredients: " + ing1 + ", " + ing2 + ", " + ing3 + "\n" +
                "Extra cheese: " + extraCheese + "\n" +
                "Side dish: " + sideDish + "\n" +
                "Drink: " + drinks + "\n" +
                "Half - pay offer: " + halfPay + "\n" +
                "Birthday: " + birthday + "\n" +
                "Card number: " + cardNumber + "\n" +
                "Card expiry: " + cardExpiry;
    }


    public static void main(String[] args) {
        Slice_o_Heaven order = new Slice_o_Heaven();
        order.takeOrder();
        order.isItYourBirthday();
        order.makeCardPayment();
        order.processCardPayment();
        System.out.println(order.specialOfTheDay());
        System.out.println(order);
    }
}