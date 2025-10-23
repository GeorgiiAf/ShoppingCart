import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ShoppingCart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Locale locale = selectLanguage(scanner);

        System.out.println(getLocalizedMessage(locale, "enter.number.of.items"));
        int numItems = scanner.nextInt();

        double totalCost = 0;

        for (int i = 1; i <= numItems; i++) {
            System.out.println(getLocalizedMessage(locale, "enter.price.for.item") + " " + i + ":");
            double price = scanner.nextDouble();

            System.out.println(getLocalizedMessage(locale, "enter.quantity.for.item") + " " + i + ":");
            int quantity = scanner.nextInt();

            totalCost += calculateItemCost(price, quantity);
        }

        System.out.println(getLocalizedMessage(locale, "total.cost") + " " + totalCost);
    }




    // SELECT LANG AND RETUN LOCALE
    public static Locale selectLanguage(Scanner scanner) {
        System.out.println("Select Language / Valitse kieli / Välj språk / 言語を選択してください:");
        System.out.println("1. English");
        System.out.println("2. Finnish");
        System.out.println("3. Swedish");
        System.out.println("4. Japanese");

        int choice = scanner.nextInt();
        String language = "en";
        String country = "US";

        switch (choice) {
            case 2:
                language = "fi"; country = "FI"; break;
            case 3:
                language = "sv"; country = "SE"; break;
            case 4:
                language = "ja"; country = "JP"; break;
            default:
                break;
        }

        return new Locale(language, country);
    }


    public static String getLocalizedMessage(Locale locale, String key) {
        ResourceBundle messages = ResourceBundle.getBundle("messages", locale);
        return messages.getString(key);
    }

    public static double calculateItemCost(double price, int quantity) {
        return price * quantity;
    }

}
