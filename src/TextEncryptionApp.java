import javax.swing.*;

public class TextEncryptionApp extends JFrame {

    private JTextField inputTextField;
    private JComboBox<String> encryptionTypeComboBox;
    private JTextArea resultTextArea;

    public TextEncryptionApp() {
        setTitle("Text Encryption App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel inputLabel = new JLabel("Enter Text:");
        inputLabel.setBounds(10, 20, 80, 25);
        panel.add(inputLabel);

        inputTextField = new JTextField(20);
        inputTextField.setBounds(100, 20, 250, 25);
        panel.add(inputTextField);

        JLabel encryptionTypeLabel = new JLabel("Encryption Type:");
        encryptionTypeLabel.setBounds(10, 50, 120, 25);
        panel.add(encryptionTypeLabel);

        String[] encryptionTypes = {"Cezar", "ROT13"};
        encryptionTypeComboBox = new JComboBox<>(encryptionTypes);
        encryptionTypeComboBox.setBounds(130, 50, 120, 25);
        panel.add(encryptionTypeComboBox);

        JButton encryptButton = new JButton("Encrypt");
        encryptButton.setBounds(10, 80, 80, 25);
        encryptButton.addActionListener(e -> encryptText());
        panel.add(encryptButton);

        resultTextArea = new JTextArea();
        resultTextArea.setBounds(10, 120, 350, 100);
        panel.add(resultTextArea);
    }

    private void encryptText() {
        String inputText = inputTextField.getText();
        String selectedEncryptionType = (String) encryptionTypeComboBox.getSelectedItem();
        String encryptedText = "";

        if ("Cezar".equals(selectedEncryptionType)) {
            encryptedText = encryptCesar(inputText);
        } else if ("ROT13".equals(selectedEncryptionType)) {
            encryptedText = encryptROT13(inputText);
        }

        resultTextArea.setText(encryptedText);
    }

    private String encryptCesar(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                result.append((char) (((c - base + 3) % 26) + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    private String encryptROT13(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                result.append((char) (((c - base + 13) % 26) + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TextEncryptionApp::new);
    }
}