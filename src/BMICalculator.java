import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculator extends JFrame {
    private JTextField weightField, heightField, resultField;

    public BMICalculator() {
        setTitle("Kalkulator BMI");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel weightLabel = new JLabel("Waga (kg):");
        JLabel heightLabel = new JLabel("Wzrost (cm):");
        JLabel resultLabel = new JLabel("BMI:");

        weightField = new JTextField(10);
        heightField = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);

        JButton calculateButton = new JButton("Oblicz");

        JPanel panel = new JPanel();
        panel.add(weightLabel);
        panel.add(weightField);
        panel.add(heightLabel);
        panel.add(heightField);
        panel.add(resultLabel);
        panel.add(resultField);
        panel.add(calculateButton);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateBMI();
            }
        });

        // Dodanie panelu do okna
        add(panel);

        // Wyświetlenie okna
        setVisible(true);
    }

    private void calculateBMI() {
        try {
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText());

            double bmi = weight / (height/100 * height/100);

            resultField.setText(String.format("%.2f", bmi));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Wprowadź poprawne wartości wagi i wzrostu.", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BMICalculator();
            }
        });
    }
}