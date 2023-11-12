import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaZakupowAppJFrame {

    private DefaultListModel<String> listaModel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ListaZakupowAppJFrame app = new ListaZakupowAppJFrame();
            app.createAndShowGui();
        });
    }

    public void createAndShowGui() {
        JFrame frame = new JFrame("Lista Zakupów");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        listaModel = new DefaultListModel<>();
        JList<String> listaZakupow = new JList<>(listaModel);
        JTextField poleTekstowe = new JTextField(20);
        JButton przyciskDodaj = new JButton("Dodaj");
        JButton przyciskUsun = new JButton("Usuń zaznaczone");

        przyciskDodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String produkt = poleTekstowe.getText().trim();
                if (!produkt.isEmpty()) {
                    listaModel.addElement(produkt);
                    poleTekstowe.setText("");
                }
            }
        });

        przyciskUsun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = listaZakupow.getSelectedIndex();
                if (selectedIndex >= 0) {
                    listaModel.remove(selectedIndex);
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(poleTekstowe);
        panel.add(przyciskDodaj);
        panel.add(listaZakupow);
        panel.add(przyciskUsun);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }
}