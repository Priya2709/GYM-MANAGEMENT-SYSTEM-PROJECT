package Quarantine;

import PAGES.Login;
import TOOLS.TemplateClass;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import javax.swing.*;

public class backup extends JFrame {

    JLabel greetLabel;
    JButton updateLabel, deleteLabel, manageLabel, trackLabel;

    JButton addCoachButton, addMemberButton;
    JButton updateCoachButton, updateMemberButton;
    JButton trackCoachButton, trackMemberButtton;
    JButton deleteCoachButton, deleteMemberButton;

    public backup() throws HeadlessException {

        Container cc = getContentPane();
        JPanel header = TemplateClass.getHeader();
        JPanel body = TemplateClass.getBody();
        JPanel manageBody = new JPanel();
        JPanel trackBody = new JPanel();
        JPanel updateBody = new JPanel();
        JPanel Deletebody = new JPanel();
        JPanel menuPanel = new JPanel(new GridLayout(1, 4, 10, 0));
        JPanel footer = TemplateClass.getFooter();
        JButton backButton = TemplateClass.getBackButton();

        cc.add(header);
        cc.add(body);
        body.add(manageBody);
        body.add(trackBody);
        body.add(updateBody);
        body.add(Deletebody);
        cc.add(footer);

        greetLabel = new JLabel("  " + Login.ADMIN + "  ");

        manageLabel = new JButton("Manage");
        manageLabel.setBackground(null);
        manageLabel.setBorder(null);
        trackLabel = new JButton("Track");
        trackLabel.setBackground(null);
        trackLabel.setBorder(null);
        updateLabel = new JButton("Update");
        updateLabel.setBackground(null);
        updateLabel.setBorder(null);
        deleteLabel = new JButton("Delete");
        deleteLabel.setBackground(null);
        deleteLabel.setBorder(null);

        addCoachButton = new JButton("Add Coach");
        addMemberButton = new JButton("Add Member");
        updateCoachButton = new JButton("Update Coach Details");
        updateMemberButton = new JButton("Update Member Details");
        trackCoachButton = new JButton("Track Coach");
        trackMemberButtton = new JButton("Track Member");
        deleteCoachButton = new JButton("Delete Coach");
        deleteMemberButton = new JButton("Delete Member");

        greetLabel.setFont(new Font("Arial", Font.BOLD, 24));
        greetLabel = (JLabel) TemplateClass.formatFont(greetLabel, TextAttribute.UNDERLINE_ON, 28);

        menuPanel.setBounds(100, 75, 600, 50);
        body.add(menuPanel);
        body.add(greetLabel);

        menuPanel.add(manageLabel);
        menuPanel.add(trackLabel);
        menuPanel.add(updateLabel);
        menuPanel.add(deleteLabel);

        manageBody.add(addCoachButton);
        manageBody.add(addMemberButton);
        trackBody.add(trackCoachButton);
        trackBody.add(trackMemberButtton);
        updateBody.add(updateCoachButton);
        updateBody.add(updateMemberButton);
        Deletebody.add(deleteCoachButton);
        Deletebody.add(deleteMemberButton);

        manageBody.setBounds(100, 140, 600, 400);
        trackBody.setBounds(100, 140, 600, 400);
        updateBody.setBounds(100, 140, 600, 400);
        Deletebody.setBounds(100, 140, 600, 400);

        manageBody.setBackground(Color.CYAN);
        trackBody.setBackground(Color.CYAN);
        updateBody.setBackground(Color.CYAN);
        Deletebody.setBackground(Color.cyan);

        addCoachButton.setBounds(100, 150, 150, 50);
        addMemberButton.setBounds(100, 250, 150, 50);
        updateCoachButton.setBounds(0, 20, 100, 50);
        updateMemberButton.setBounds(0, 20, 100, 50);
        trackCoachButton.setBounds(100, 150, 150, 50);
        trackMemberButtton.setBounds(100, 250, 150, 50);

        manageBody.setLayout(null);
        trackBody.setLayout(null);
        updateBody.setLayout(null);
        Deletebody.setLayout(null);

        setSize(800, 800);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setResizable(false);

        footer.add(backButton);
        backButton.addActionListener((ActionEvent e) -> {
            new Login(Login.ADMIN);
            dispose();
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addCoachButton.addActionListener((ActionEvent e) -> {
        });

        addMemberButton.addActionListener((ActionEvent e) -> {
        });

        updateCoachButton.addActionListener((ActionEvent e) -> {
        });
        manageLabel.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                System.out.println("found");
            }

            @Override
            public void focusLost(FocusEvent e) {
                System.out.println("Lost");
            }
        });
    }

    public static void main(String[] args) {
        new backup();
    }

}
