package currency_converter;

import java.util.HashMap;
import java.util.Map;

public class CurrencySymbols {

    private static final Map<String, String> currencySymbols = new HashMap<>() {{
        put("COP", "$");
        put("USD", "$");
        put("EUR", "€");
        put("GBP", "£");
        put("JPY", "¥");
        put("KRW", "₩");
    }};

    public static String getSymbol(String currency) {
        return currencySymbols.get(currency);
    }
}
