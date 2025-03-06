import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class SliceOfHeaven {

    public static void takeOrder() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter three ingredients for your pizza (use spaces to separate ingredients):");
        String ing1 = scanner.next();
        String ing2 = scanner.next();
        String ing3 = scanner.next();

        System.out.println("Enter size of pizza (Small, Medium, Large):");
        String pizzaSize = scanner.next();

        System.out.println("Do you want extra cheese (Y/N):");
        String extraCheese = scanner.next();

        System.out.println("Enter one side dish (Calzone, Garlic bread, None):");
        String sideDish = scanner.next();

        System.out.println("Enter drinks (Cold Coffee, Cocoa drink, Coke, None):");
        String drinks = scanner.next();
    }

    public static void isItYourBirthday() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your birthday (format: yyyy-MM-dd):");
        String birthdateStr = scanner.next();
        LocalDate birthdate = LocalDate.parse(birthdateStr);
        LocalDate today = LocalDate.now();
        Period period = Period.between(birthdate, today);
        int age = period.getYears();

        if (age < 18 && birthdate.getDayOfYear() == today.getDayOfYear()) {
            System.out.println("Congratulations! You pay only half the price for your order");
        } else {
            System.out.println("Too bad! You do not meet the conditions to get our 50% discount");
        }
    }

    public static void makeCardPayment() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your card number:");
        long cardNumber = scanner.nextLong();

        System.out.println("Enter the card's expiry date (year and month, format: yyyy-MM):");
        String expiryDate = scanner.next();

        System.out.println("Enter the card's cvv number:");
        int cvv = scanner.nextInt();

        processCardPayment(cardNumber, expiryDate, cvv);
    }

    public static void processCardPayment(long cardNumber, String expiryDate, int cvv) {
        if (String.valueOf(cardNumber).length() != 14) {
            System.out.println("Invalid card");
            return;
        }

        long firstCardDigit = Long.parseLong(String.valueOf(cardNumber).substring(0, 1));

        long blacklistedNumber = 12345678901234L;
        if (cardNumber == blacklistedNumber) {
            System.out.println("Card is blacklisted. Please use another card");
            return;
        }

        String lastFourDigits = String.valueOf(cardNumber).substring(String.valueOf(cardNumber).length() - 4);

        String cardNumberToDisplay = String.valueOf(cardNumber).charAt(0) + 
                                     "**********" + 
                                     lastFourDigits;
        System.out.println("Card accepted");
        System.out.println("Formatted card number: " + cardNumberToDisplay);
    }

    public static void specialOfTheDay() {
        System.out.println("Today's special is not implemented yet.");
    }

    public static void printReceipt() {
        System.out.println("Pizza Order Receipt");
        System.out.println("Payment processed successfully.");
    }

    public static void main(String[] args) {
        takeOrder();
        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        Scanner scanner = new Scanner(System.in);
        String wantDiscount = scanner.next();
        if ("Y".equalsIgnoreCase(wantDiscount)) {
            isItYourBirthday();
        } else {
            makeCardPayment();
        }
        specialOfTheDay();
        printReceipt();
    }
}