package converter_settings;

import javax.swing.*;


public class Input {

    private static final String INVALID_INPUT_MESSAGE = "Entrada inválida. Por favor ingrese un número valido.";

    public static double getAmount(String message){
        while (true) {
            String input = JOptionPane.showInputDialog(null,
                message, "Mensaje", JOptionPane.QUESTION_MESSAGE);

            if (input == null) {
                throw new RuntimeException("El usuario ha cancelado la entrada de datos.");
            }

            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, INVALID_INPUT_MESSAGE,
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}