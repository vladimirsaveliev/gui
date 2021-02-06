import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Win extends JFrame {
    JLabel label;
    JTextField textField;
    JButton button;
    eHandler handler = new eHandler();

    public Win(String title, String textFieldLabel, String initTextField) {
        super(title);
        setLayout(new FlowLayout());

        label = new JLabel(textFieldLabel);
        add(label);

        textField = new JTextField(initTextField, 20);
        add(textField);
        textField.addActionListener(handler);

        button = new JButton("OK");
        add(button);
        button.addActionListener(handler);

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public class eHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == button) {
                /* JButton is pressed */
                dispose();
            }
            if (event.getSource() == textField) {
                /* Enter is pressed in JTextField t */
                dispose();
            }
        }
    }

    public JTextField getT() {
        return textField;
    }
}
