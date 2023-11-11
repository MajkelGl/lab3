import javax.swing.*;
import java.awt.*;

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

    protected void buildFrame(){
        setBounds(200, 200, 600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //program ma się zakończyć po zamknięciu tego okna

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
    }
}