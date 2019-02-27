package homework_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyChat extends JFrame {
    JPanel jpG = new JPanel(new GridLayout());
    JPanel jpB = new JPanel(new BorderLayout());

    JButton jb = new JButton("SEND");
    JTextArea jta = new JTextArea();
    JTextField jtf = new JTextField();
    JScrollPane jsp = new JScrollPane(jta);

    JMenuBar mainMenu = new JMenuBar();
    JMenu mFile = new JMenu("File");
    JMenu mHelp = new JMenu("Help");

    JMenuItem miFileExit = new JMenuItem("Exit");
    JMenuItem miHelpAbout = new JMenuItem("About");

    public MyChat() throws IOException {
        super("MyChatApp");
        setSize(400, 300);
        setMinimumSize(new Dimension(400, 300));

        jta.setLineWrap(true);
        jta.setEditable(false);

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Pressed");
                sendMessage();
            }
        });

        jtf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    sendMessage();
            }
        });

        setJMenuBar(mainMenu);
        mainMenu.add(mFile);
        mainMenu.add(mHelp);
        mFile.add(miFileExit);
        mHelp.add(miHelpAbout);

        miFileExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        miHelpAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Chat version 1.0 ", "About", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        jpG.add(jsp);
        jpB.add(jtf, BorderLayout.CENTER);
        jpB.add(jb, BorderLayout.EAST);

        add(jpG);
        add("South", jpB);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void sendMessage() {
        String str;
        if (!jtf.getText().isEmpty()) {
            str = jtf.getText();
            jta.append(getTime() + ": " + str + "\n");
            jtf.setText("");
            jtf.grabFocus();
        }
    }

    public String getTime() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }
}
