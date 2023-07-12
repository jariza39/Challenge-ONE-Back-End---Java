package currency_converter;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {

    private static final int FROM_CURRENCY_INDEX = 1;
    private static final int TO_CURRENCY_INDEX = 3;


    public static String convert(double amount, String currencyString) {
        HashMap<String, Double> rates = Api.getRates();
        String fromCurrency = getCurrencyCodes().get(getFromCurrency(currencyString)) ;
        String toCurrency = getCurrencyCodes().get(getToCurrency(currencyString));
        double fromRates = rates.get(fromCurrency);
        double toRates = rates.get(toCurrency);
        double value = (amount / fromRates) * toRates;
        return new DecimalFormat("#,##0.00").format(value);
    }

    public static String getFromCurrency(String currencyString) {
        return getCurrency(currencyString,FROM_CURRENCY_INDEX);
    }

    public static String getSymbolToCurrency(String currencyString) {
        return getSymbol(getCurrencySymbol(currencyString, TO_CURRENCY_INDEX));
    }

    public static String getToCurrency(String currencyString) {
        return getCurrency(currencyString, TO_CURRENCY_INDEX);
    }

    private static String getCurrencySymbol(String currencyString, int index) {
        return getCurrencyCodes().get(getCurrency( currencyString,  index));
    }
    private static String getCurrency(String currencyString, int index) {
        String[] strings = currencyString.split(" ");
        return  strings[index];
    }

    private static Map<String, String> getCurrencyCodes(){
        Map<String, String> currencyCodes = new HashMap<>();
        currencyCodes.put("Pesos", "COP");
        currencyCodes.put("Dólares", "USD");
        currencyCodes.put("Euros", "EUR");
        currencyCodes.put("Libras", "GBP");
        currencyCodes.put("Yen", "JPY");
        currencyCodes.put("Won", "KRW");
        return currencyCodes;
    }

    public static String getSymbol(String currency) {
        Map<String, String> currencySymbols = new HashMap<>() {{
            put("COP", "$");
            put("USD", "$");
            put("EUR", "€");
            put("GBP", "£");
            put("JPY", "¥");
            put("KRW", "₩");
        }};
        return currencySymbols.get(currency);
    }


}