package currency_converter;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {

    private final Map<String, String> currencyCodes = new HashMap<>();
    private static final int FROM_CURRENCY_INDEX = 1;
    private static final int TO_CURRENCY_INDEX = 3;

    public CurrencyConverter() {
        currencyCodes.put("Pesos", "COP");
        currencyCodes.put("Dólares", "USD");
        currencyCodes.put("Euros", "EUR");
        currencyCodes.put("Libras", "GBP");
        currencyCodes.put("Yen", "JPY");
        currencyCodes.put("Won", "KRW");

    }

    public String convert(double amount, String currencyString) {
        HashMap<String, Double> rates = Api.getRates();
        String fromCurrency = getFromCurrency(currencyString);
        String toCurrency = getToCurrency(currencyString);
        double fromRates = rates.get(fromCurrency);
        double toRates = rates.get(toCurrency);
        double value = (amount / fromRates) * toRates;
        double value1 = Math.round(value * 100.0) / 100.0;
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        return decimalFormat.format(value1);
    }

    public String getFromCurrency(String currencyString) {
        return getCurrency(currencyString,FROM_CURRENCY_INDEX);
    }

    public String getToCurrency(String currencyString) {
        return getCurrency(currencyString, TO_CURRENCY_INDEX);
    }

    private String getCurrency(String currencyString, int index) {
        String[] strings = currencyString.split(" ");
        String coin = strings[index];
        return currencyCodes.get(coin);
    }



}