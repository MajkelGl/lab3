import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class MainWindow extends JFrame {
    private final JFileChooser fileChooser = new JFileChooser(".");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow window = new MainWindow();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        });
    }

    public MainWindow() throws HeadlessException {
        this("undefined");
    }

    public MainWindow(String title) throws HeadlessException {
        super(title);
        buildFrame();
    }

    protected void buildFrame() {
        setBounds(200, 200, 600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //program ma się zakończyć po zamknięciu tego okna

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);

        JMenuItem mnitNew = new JMenuItem("New");

        mnitNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    doFileNew();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        mnFile.add(mnitNew);


        JMenuItem mnitOpen = new JMenuItem("Open");
        mnitOpen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doFileOpen();
            }
        });
        mnitOpen.setMnemonic(KeyEvent.VK_O);//można też po prostu 'O'
        mnFile.add(mnitOpen);

        JMenuItem mnitSave = new JMenuItem("Save");
        mnitSave.addActionListener(e -> {
            doFileSave();
        });
        mnitSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        mnFile.add(mnitSave);
    }

        private void doFileOpen () {
            int result = fileChooser.showOpenDialog(null);//okno pojawi się na środku ekranu
            if (result == JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(fileChooser,
                        String.format("Wybrano plik: %s", fileChooser.getSelectedFile()),
                        "Wybór",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }

public static int doFileNew() throws IOException {
    String sciezka = System.getProperty("user.dir");

    File biezacyFolder = new File(sciezka);

    File nowyPlik = new File(biezacyFolder, "nowyPlik.txt");

    if (nowyPlik.createNewFile()) {
        System.out.println("Nowy plik został utworzony: " + nowyPlik.getAbsolutePath());
        return 1;
    } else {
        System.out.println("Plik już istnieje.");
        return 0;
    }
}

        private void doFileSave () {
            fileChooser.showSaveDialog(this);
        }
}