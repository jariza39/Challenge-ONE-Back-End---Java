import static currency_converter.CurrencyMethod.CURRENCYS;
import static weight_converter.WeightMethod.WEIGHTS;

import converter_settings.Input;
import converter_settings.Output;
import converter_settings.SelectionOptions;
import currency_converter.CurrencyConverter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import weight_converter.WeightConverter;

public class Main {

    public static final String MESSAGE = "Seleccione la unidad a convertir";
    public static final String[] opciones = {"Conversor de Moneda", "Conversor de Peso"};

    public static void main(String[] args) {
        boolean continuar;

        do {
            String opcionConversion = (String) JOptionPane.showInputDialog(null,
                "Seleccione una opción de conversión", "Menu", JOptionPane.PLAIN_MESSAGE,
                null, opciones, opciones[0]);

            double valueToConvert = 0.0;
            List<String> values = new ArrayList<>();

            try {
                valueToConvert = Input.getAmount("Ingrese la cantidad a convertir");
            } catch (RuntimeException e) {
                System.exit(0);
            }
            switch (opcionConversion) {
                case "Conversor de Moneda" -> {
                    var selection = selectOptions(CURRENCYS, MESSAGE);
                    values.add(CurrencyConverter.getSymbolToCurrency(selection));
                    values.add(CurrencyConverter.convert(valueToConvert, selection));
                    values.add(CurrencyConverter.getToCurrency(selection));
                    Output.showResult(values);
                }
                case "Conversor de Peso" -> {
                    var selectionWeight = selectOptions(WEIGHTS, MESSAGE);
                    values.add(String.valueOf(WeightConverter.convert(valueToConvert, selectionWeight)));
                    values.add(CurrencyConverter.getToCurrency(selectionWeight));
                    Output.showResult(values);
                }
                default -> throw new IllegalStateException("Unexpected value: " + opcionConversion);
            }
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea continuar?",
                "Select an Option", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
            continuar = (opcion == JOptionPane.YES_OPTION);
        } while (continuar);

        JOptionPane.showMessageDialog(null, "Programa Finalizado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }


    public static String selectOptions(String[] values, String message) {
        return SelectionOptions.getdata(values, message);
    }
}
