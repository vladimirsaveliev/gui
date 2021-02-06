import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class app extends JFrame implements ActionListener {
    static JMenuBar mb;
    static JMenu[] menu;
    static JMenuItem m1, m2, m3, q;
    static JFrame f;
    static JLabel l;

    public static void main(String[] args) {
        app a = new app();

        f = new JFrame("Flight booking");
        mb = new JMenuBar();

        menu = new JMenu[4];

        /* Airlines/[Register airline|Find airline|Open direction] */
        menu[0] = new JMenu("Airlines");
        menu[0].add(new JMenuItem("Register airline"));
        menu[0].add(new JMenuItem("Find airline"));
        menu[0].add(new JMenuItem("Open direction"));

        /* Directions/[New|Find] */
        menu[1] = new JMenu("Directions");
        menu[1].add(new JMenuItem("New"));
        menu[1].add(new JMenuItem("Find"));

        /* Tickets/[Book|Find] */
        menu[2] = new JMenu("Tickets");
        menu[2].add(new JMenuItem("Book"));
        menu[2].add(new JMenuItem("Find"));

        /* Quit/[Quit] */
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

        if (ev.getSource() == menu[0].getItem(0)) {
            /* Companies->New menu item is selected, open dialog */
            Win w = new Win("Companies->New", "Enter company name",
                    "Foo Airlines");
            w.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    /* dialog is closed */
                    l.setText(s + " : " + w.getT().getText());
                }
            });
        }

        if (ev.getSource() == menu[0].getItem(1)) {
            /* Companies->New */
            Win w = new Win("Companies->Find", "", "");
        }

        if (ev.getSource() == menu[0].getItem(2)) {
            /* Companies->Open */
            Win w = new Win("Companies->Open", "", "");
        }

        if (ev.getSource() == menu[1].getItem(0)) {
            /* Direction->New */
            Win w = new Win("Direction->New", "", "");
        }

        if (ev.getSource() == menu[1].getItem(1)) {
            /* Direction->Find */
            Win w = new Win("Direction->Find", "", "");
        }

        if (ev.getSource() == menu[2].getItem(0)) {
            /* Tickets->Book */
            Win w = new Win("Tickets->Book", "","");
        }
        if (ev.getSource() == menu[2].getItem(1)) {
            /* Tickets->Find */
            Win w = new Win("Tickets->Find", "", "");
        }

        if (ev.getSource() == menu[3].getItem(0)) {
                /* Quit->Quit */
                System.exit(0);
        }
    }
}
