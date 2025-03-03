public class CardPaymentProcessor {

    public static void processCardPayment(String cardNumber, String expiryDate, int cvv) {
        int cardLength = cardNumber.length();
        if (cardLength != 14) {
            System.out.println("Invalid card");
            return;
        }
        System.out.println("Card accepted");

        int firstCardDigit = Integer.parseInt(cardNumber.substring(0, 1));

        String blacklistedNumber = "12345678901234";
        if (cardNumber.equals(blacklistedNumber)) {
            System.out.println("Card is blacklisted. Please use another card.");
            return;
        }

        int lastFourDigits = Integer.parseInt(cardNumber.substring(cardLength - 4));

        String cardNumberToDisplay = cardNumber.charAt(0) + cardNumber.substring(1, cardLength - 4).replaceAll(".", "*") + cardNumber.substring(cardLength - 4);
        System.out.println("Card number to display: " + cardNumberToDisplay);
    }

    public static void main(String[] args) {
        String cardNumber = "12345678901234";
        String expiryDate = "12/25";
        int cvv = 123;
        processCardPayment(cardNumber, expiryDate, cvv);
    }
}