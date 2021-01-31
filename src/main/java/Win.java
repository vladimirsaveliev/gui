import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Win extends JFrame {
    JButton b;
    eHandler handler = new eHandler();

    public Win(String s) {
        super(s);
        setLayout(new FlowLayout());
        b = new JButton("OK");
        add(b);
        b.addActionListener(handler);
        setSize(300,300);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public class eHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == b) {
                JOptionPane.showMessageDialog(null,"ErrorMSG", "Title!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
