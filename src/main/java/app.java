import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class app extends JFrame implements ActionListener {
    static JMenuBar mb;
    static JMenu menu[];
    static JMenuItem m1, m2, m3, q;
    static JFrame f;
    static JLabel l;

    public static void main(String[] args) {
        app a = new app();

        f = new JFrame("Flight booking");
        mb = new JMenuBar();

        menu = new JMenu[4];

        /* Companies/[New|Find|Open] */
        menu[0] = new JMenu("Companies");
        menu[0].add(new JMenuItem("New"));
        menu[0].add(new JMenuItem("Find"));
        menu[0].add(new JMenuItem("Open"));

        /* Directions/[New|Find] */
        menu[1] = new JMenu("Directions");
        menu[1].add(new JMenuItem("New"));
        menu[1].add(new JMenuItem("Find"));

        /* Directions/[New|Find] */
        menu[2] = new JMenu("Tickets");
        menu[2].add(new JMenuItem("Book"));
        menu[2].add(new JMenuItem("Find"));

        /* Tickets/[Book|Find] */
        menu[3] = new JMenu("Quit");
        menu[3].add(new JMenuItem("Quit"));

        for (int i = 0; i < 4; i ++)
            mb.add(menu[i]);

        /* Companies/[New|Find|Open] */
        menu[0].getItem(0).addActionListener(a);
        menu[0].getItem(1).addActionListener(a);
        menu[0].getItem(2).addActionListener(a);

        /* Directions/[New|Find] */
        menu[1].getItem(0).addActionListener(a);
        menu[1].getItem(1).addActionListener(a);

        /* Tickets/[Book|Find] */
        menu[2].getItem(0).addActionListener(a);
        menu[2].getItem(0).addActionListener(a);

        /* Quit */
        menu[3].getItem(0).addActionListener(a);

        l = new JLabel("Book safe", SwingConstants.CENTER);
        f.add(l);

        f.setJMenuBar(mb);
        f.setSize(300,200);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /* Menu item is selected */
    public void actionPerformed(ActionEvent ev) {
        String s = ev.getActionCommand();
        l.setText(s + " selected");

        Win w;
        if (ev.getSource() == menu[0].getItem(0)) {
            /* Companies->New */
            w = new Win("Companies->New");
        }

        if (ev.getSource() == menu[0].getItem(1)) {
            /* Companies->New */
            w = new Win("Companies->Find");
        }

        if (ev.getSource() == menu[0].getItem(2)) {
            /* Companies->Open */
            w = new Win("Companies->Open");
        }


        if (ev.getSource() == menu[1].getItem(0)) {
            /* Direction->New */
            w = new Win("Direction->New");
        }

        if (ev.getSource() == menu[1].getItem(1)) {
            /* Direction->Find */
            w = new Win("Direction->Find");
        }

        if (ev.getSource() == menu[2].getItem(0)) {
            /* Tickets->Book */
            w = new Win("Tickets->Book");
        }
        if (ev.getSource() == menu[2].getItem(1)) {
            /* Tickets->Find */
            w = new Win("Tickets->Find");
        }

        if (ev.getSource() == menu[3].getItem(0)) {
                /* Quit->Quit */
                System.exit(0);
        }
    }
}
