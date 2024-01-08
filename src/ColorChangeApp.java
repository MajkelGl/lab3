import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChangeApp extends JFrame {

    private JTextField colorTextField;
    private JButton changeColorButton;
    private JPanel colorPanel;

    public ColorChangeApp() {
        setTitle("Zmiana koloru");
        setSize(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        colorTextField = new JTextField();
        changeColorButton = new JButton("Zmień kolor");
        colorPanel = new JPanel();

        add(colorTextField, BorderLayout.NORTH);
        add(changeColorButton, BorderLayout.CENTER);
        add(colorPanel, BorderLayout.SOUTH);

        changeColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeColor();
            }
        });
    }

    private void changeColor() {
        String colorName = colorTextField.getText().toLowerCase();

        Color newColor;
        switch (colorName) {
            case "czerwony":
                newColor = Color.RED;
                break;
            case "zielony":
                newColor = Color.GREEN;
                break;
            case "niebieski":
                newColor = Color.BLUE;
                break;
            case "żółty":
                newColor = Color.YELLOW;
                break;
            case "czarny":
                newColor = Color.BLACK;
                break;
            default:
                JOptionPane.showMessageDialog(this, "Nieprawidłowa nazwa koloru!", "Błąd", JOptionPane.ERROR_MESSAGE);
                return;
        }

        colorPanel.setBackground(newColor);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ColorChangeApp app = new ColorChangeApp();
                app.setVisible(true);
            }
        });
    }
}