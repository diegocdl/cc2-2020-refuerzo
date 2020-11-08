import javax.swing.*;
import java.awt.event.*;

public class Ventana1 implements ActionListener {
    JFrame ventana;
    JButton btn1;
    JButton btn2;
    JLabel label;

    public Ventana1() {
        loadGUI();
    }

    public void loadGUI() {
        ventana = new JFrame("Ventana 1");
        ventana.setLayout(null);
        ventana.setSize(500, 500);

        btn1 = new JButton("Boton 1");
        btn1.setBounds(120, 220, 100, 30);
        btn1.addActionListener(this);
        ventana.add(btn1);

        btn2 = new JButton("Abrir Ventana 2");
        btn2.setBounds(240, 220, 100, 30);
        btn2.addActionListener(this);
        ventana.add(btn2);

        label = new JLabel();
        label.setBounds(50, 180, 400, 30);
        ventana.add(label);

        ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            int n = (int)(Math.random()*100);
            label.setText("Dieron click en un boton " + n);
        } else {
            label.setText("Dieron Click a boton dos");
            Ventana2 v2 = new Ventana2();
            v2.setLocationRelativeTo(null);
            ventana.setVisible(false);
        }
    }

    public static void main(String[] args) {
        Ventana1 v = new Ventana1();
    }

}