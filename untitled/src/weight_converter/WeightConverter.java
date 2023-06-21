package weight_converter;
import java.util.HashMap;
import java.util.Map;

public class WeightConverter {
    
    private static final Map<String, Double> weightCodes = new HashMap<String, Double>() {{
        put("kilogramos", 1.0);
        put("libras", 2.20462);
        put("onzas", 35.274);
        put("gramos", 1000.0);
        put("miligramos", 1000000.0);
        put("toneladas", 0.001);
        put("stone", 0.157473);
    }};
    
    public static double convert(double amount, String cadena) {
        String[] parts = cadena.split(" ");
        double fromWeightValue = weightCodes.get(parts[1]);
        double toWeightValue = weightCodes.get(parts[3]);
        double result = amount * (toWeightValue / fromWeightValue);
        return Math.round(result * 100.0) / 100.0;
    }
}
    


