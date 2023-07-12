package converter_settings;

import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;

public class Output {

    public static void showResult(List<String> values) {
        JOptionPane.showMessageDialog(null, "Tienes".concat(values
            .stream()
            .map(s -> " ".concat(s))
            .collect(Collectors.joining())));
    }
}
