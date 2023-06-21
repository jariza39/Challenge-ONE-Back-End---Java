package converter_settings;

import javax.swing.*;

public class Output {
    public static void showResult(String convertedValue,String simbol, String destination) {
        JOptionPane.showMessageDialog(null, "Tienes "+ simbol +" "+ convertedValue +" "+ destination);
    }

    public static void showResult(double convertedValue, String simbol) {
        JOptionPane.showMessageDialog(null, "Tienes "+ convertedValue+ " "+simbol);
    }
}
