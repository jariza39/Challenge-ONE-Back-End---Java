package converter_settings;

import javax.swing.*;

public class SelectionOptions {
    public static String getdata(String[] currencies, String message){
        return (String) JOptionPane.showInputDialog(null, message,
                "Mensaje", JOptionPane.PLAIN_MESSAGE, null, currencies, currencies[0]);
    }

    public static boolean confirm( String message){
        return JOptionPane.showConfirmDialog(null, message,
            "Select an Option", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null)== JOptionPane.YES_OPTION;
    }
    public static void message( String message){
        JOptionPane.showMessageDialog(null, message, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }
}
