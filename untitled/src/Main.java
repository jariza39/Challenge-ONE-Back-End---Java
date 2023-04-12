import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String[] opciones = { "Conversor de Moneda", "Conversor de Peso" };
        String opcionConversion = (String) JOptionPane.showInputDialog(null,
                "Seleccione una opción de conversión", "Menu", JOptionPane.PLAIN_MESSAGE,
                null, opciones, opciones[0]);
        switch (opcionConversion){
            case "Conversor de Moneda":
                int valor = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la cantidad de dinero que deseas convertir:"));


        }






    }
}