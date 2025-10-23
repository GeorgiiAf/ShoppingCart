import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    @Test
    public void testCalculateItemCost() {
        assertEquals(100.0, ShoppingCart.calculateItemCost(20.0, 5));
        assertEquals(0.0, ShoppingCart.calculateItemCost(0.0, 10));
        assertEquals(0.0, ShoppingCart.calculateItemCost(50.0, 0));
        assertEquals(33.33 * 3, ShoppingCart.calculateItemCost(33.33, 3), 0.001);
    }

    @Test
    public void testGetLocalizedMessageEnglish() {
        Locale enLocale = new Locale("en", "US");
        String message = ShoppingCart.getLocalizedMessage(enLocale, "enter.number.of.items");
        assertEquals("Enter the number of items to purchase:", message);
    }

    @Test
    public void testGetLocalizedMessageFinnish() {
        Locale fiLocale = new Locale("fi", "FI");
        String message = ShoppingCart.getLocalizedMessage(fiLocale, "total.cost");
        assertEquals("Kokonaishinta:", message);
    }

    @Test
    public void testGetLocalizedMessageSwedish() {
        Locale svLocale = new Locale("sv", "SE");
        String message = ShoppingCart.getLocalizedMessage(svLocale, "total.cost");
        assertEquals("Total kostnad:", message);
    }

    @Test
    public void testGetLocalizedMessageJapanese() {
        Locale jaLocale = new Locale("ja", "JP");
        String message = ShoppingCart.getLocalizedMessage(jaLocale, "total.cost");
        assertEquals("合計金額:", message);
    }
}
