package converter_settings;

import javax.swing.*;

public class SelectionOptions {
    public static String getdata(String[] currencies, String message){
        return (String) JOptionPane.showInputDialog(null, message,
                "Mensaje", JOptionPane.PLAIN_MESSAGE, null, currencies, currencies[0]);
    }
}
