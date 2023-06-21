import converter_settings.*;
import currency_converter.CurrencyConverter;
import static currency_converter.CurrencySymbols.*;
import static currency_converter.CurrencyMethod.CURRENCYS;
import static weight_converter.WeightMethod.WEIGHTS;
import weight_converter.WeightConverter;

import javax.swing.*;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    boolean continuar;

    do {
      String[] opciones = { "Conversor de Moneda", "Conversor de Peso" };
      String opcionConversion = (String) JOptionPane.showInputDialog(null,
          "Seleccione una opción de conversión", "Menu", JOptionPane.PLAIN_MESSAGE,
          null, opciones, opciones[0]);

      switch (opcionConversion) {

        case "Conversor de Moneda":

          double amount = 0.0;
          try {
            amount = Input.getAmount("Ingrese la cantidad a convertir");

          } catch (RuntimeException e) {
            System.exit(0);
          }
          var selection = SelectionOptions.getdata(CURRENCYS, "Seleccione la moneda de origen y destino");
          var converter = new CurrencyConverter();
          String convert = converter.convert(amount, selection);
          String symbol = getSymbol(converter.getToCurrency(selection));
          String destination = Arrays.stream(selection.split(" ")).skip(3).findFirst().orElse(null);
          Output.showResult(convert, symbol, destination);
          break;

        case "Conversor de Peso":

          double weight = 0.0;
          try {
            weight = Input.getAmount("Ingrese el peso a convertir");
          } catch (RuntimeException e) {
            System.out.println("El usuario ha cancelado la entrada de datos.");
            System.exit(0);
          }
          var selectionWeight = SelectionOptions.getdata(WEIGHTS, "Seleccione el peso de origen y destino");
          double convertWeight1 = WeightConverter.convert(weight, selectionWeight);
          String destinationWeight = Arrays.stream(selectionWeight.split(" ")).skip(3).findFirst().orElse(null);
          Output.showResult(convertWeight1, destinationWeight);
          break;
      }

      int opcion = JOptionPane.showConfirmDialog(null, "¿Desea continuar?",
          "Select an Option", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
      continuar = (opcion == JOptionPane.YES_OPTION);
    } while (continuar);

    JOptionPane.showMessageDialog(null, "Programa Finalizado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
  }
}
