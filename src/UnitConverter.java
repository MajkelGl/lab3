import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnitConverter extends JFrame {
    private JComboBox<String> inputUnitComboBox, outputUnitComboBox;
    private JTextField inputValueField, resultField;

    public UnitConverter() {
        setTitle("Konwerter Jednostek");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] units = {"Metry", "Centymetry", "Milimetry", "Kilogramy", "Gramy", "Litry", "Mililitry"};

        inputUnitComboBox = new JComboBox<>(units);
        outputUnitComboBox = new JComboBox<>(units);
        inputValueField = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);

        JButton convertButton = new JButton("Przelicz");

        JPanel panel = new JPanel();
        panel.add(new JLabel("Wartość:"));
        panel.add(inputValueField);
        panel.add(inputUnitComboBox);
        panel.add(new JLabel("na:"));
        panel.add(resultField);
        panel.add(outputUnitComboBox);
        panel.add(convertButton);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convert();
            }
        });

        add(panel);

        setVisible(true);
    }

    private void convert() {
        try {
            double inputValue = Double.parseDouble(inputValueField.getText());
            String inputUnit = (String) inputUnitComboBox.getSelectedItem();
            String outputUnit = (String) outputUnitComboBox.getSelectedItem();

            double result = performConversion(inputValue, inputUnit, outputUnit);

            resultField.setText(String.format("%.2f", result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Wprowadź poprawną liczbę.", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double performConversion(double value, String inputUnit, String outputUnit) {

        switch (inputUnit) {
            case "Metry":
                switch (outputUnit) {
                    case "Metry":
                        return value;
                    case "Centymetry":
                        return value * 100;
                    case "Milimetry":
                        return value * 1000;
                    // Dodaj inne przypadki
                }
                break;
            case "Centymetry":
                switch(outputUnit){
                    case "Metry":
                        return value/100;
                    case "Centymetry":
                        return value;
                    case "Milimetry":
                        return value * 10;
                }
            case "Milimetry":
                switch(outputUnit){
                    case "Metry":
                        return value / 1000;
                    case "Centymetry":
                        return value / 10;
                    case "Milimetry":
                        return value;
                }
            case "Kilogramy":
                switch(outputUnit){
                    case "Kilogramy":
                        return value;
                    case "Gramy":
                        return value * 1000;
                }
            case "Gramy":
                switch(outputUnit){
                    case "Kilogramy":
                        return value/1000;
                    case "Gramy":
                        return value;
                }
            case "Litry":
                switch(outputUnit){
                    case "Litry":
                        return value;
                    case "Mililitry":
                        return value * 1000;
                }
            case "Mililitry":
                switch(outputUnit){
                    case "Litry":
                        return value/1000;
                    case "Mililitry":
                        return value;
                }
                break;
        }
        return 0;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UnitConverter();
            }
        });
    }
}