package Quarantine;

import PAGES.Register;
import PAGES.Login;
import TOOLS.TemplateClass;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Que extends JFrame {

    private String userType;

    Container cc = getContentPane();
    JPanel header = TemplateClass.getHeader();
    JPanel body = TemplateClass.getBody();
    JPanel footer = TemplateClass.getFooter();
    JPanel innerPanel = new JPanel();
    JLabel que;

    JButton New;
    JButton Old;

    public Que(String UserType) throws HeadlessException {

        this.userType = UserType;

        cc.add(header);
        cc.add(body);
        cc.add(footer);

        que = new JLabel("Are you???");

        New = new JButton("NewUser");
        Old = new JButton("ExtistingUser");

        que.setFont(new Font("Arial", Font.BOLD, 24));

        que.setForeground(Color.WHITE);

        New.setBackground(new Color(1, 214, 106));
        Old.setBackground(new Color(1, 214, 106));

        innerPanel.setBounds(190, 100, 400, 300);
        que.setBounds(200, 50, 200, 40);
        New.setBounds(315, 50, 150, 50);
        Old.setBounds(315, 150, 150, 50);

        body.add(innerPanel);
        body.add(que);
        innerPanel.add(New);
        innerPanel.add(Old);

        setSize(800, 800);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        New.addActionListener((ActionEvent e) -> {
            new Register(userType);
            dispose();
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Old.addActionListener((ActionEvent e) -> {
            new Login(userType);
            dispose();
        });
    }

    public static void main(String[] args) {
        new Que("Hii");
    }

}
