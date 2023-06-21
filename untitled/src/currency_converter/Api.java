package currency_converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import org.json.JSONObject;

public class Api {
    private static final String BASE_URL = "https://openexchangerates.org/api/latest.json";
    private static final String API_KEY = "b2cc53498c8f414eb15216b8129613e7"; // Reemplaza con tu propia clave de acceso

    // Método para obtener las tasas de conversión desde la API
    public static HashMap<String, Double> getRates() {
        HashMap<String, Double> value = new HashMap<>();
        try {
            URL url = new URL(BASE_URL + "?app_id=" + API_KEY);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            JSONObject json = new JSONObject(content.toString());
            JSONObject rates = json.getJSONObject("rates");
            value.put("USD", rates.getDouble("USD"));
            value.put("EUR", rates.getDouble("EUR"));
            value.put("GBP", rates.getDouble("GBP"));
            value.put("JPY", rates.getDouble("JPY"));
            value.put("KRW", rates.getDouble("KRW"));
            value.put("COP", rates.getDouble("COP"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}

