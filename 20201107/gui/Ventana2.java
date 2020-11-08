import javax.swing.*;

public class Ventana2 extends JFrame {

    JLabel label;
    public Ventana2() {
        super("Ventana 2");
        loadGUI();
    }

    public void loadGUI() {
        label = new JLabel("Hola Mundo!!!");
        label.setBounds(50, 50, 300, 30);
        add(label);

        setSize(400, 100);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}