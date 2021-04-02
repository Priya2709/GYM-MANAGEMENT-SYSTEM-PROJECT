package Quarantine;

/**
 *
 * @author dhars
 */
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.*;

public class TableDesign extends JFrame {

    private Container container = getContentPane();
    private JPanel headerPanel = new JPanel();
    private JLabel headerTitleLabel = new JLabel(" BOOTCAMP E-PASS ADMIN PANEL");
    private JLabel passLabel = new JLabel("Interstate E-Pass");
    private JPanel bodyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
    private JPanel buttonPanel = new JPanel();
    private JLabel idLabel = new JLabel("ID :");
    private JLabel statusLabel = new JLabel("Status     :");
    private JLabel validLabel = new JLabel("Valid Till :");
    private JTextField idTextField = new JTextField();
    private JTextField statusTextField = new JTextField();
    private JTextField validTextField = new JTextField();
    private JButton showButton = new JButton("Show");
    private JButton updateStatusButton = new JButton("Update");
    private JButton updateDateButton = new JButton("Update");
    private JButton backButton = new JButton("Back");
    private JTable table = new JTable() {
        @Override
        public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
            Component comp = super.prepareRenderer(renderer, row, column);
            comp.setBackground(row % 2 == 0 ? Color.white : new Color(161, 242, 255));
            return comp;
        }
    };

    DefaultTableModel model;
    JScrollPane scrollpane = new JScrollPane(table);

    TableDesign() {
        setLayoutManager();
        setLocationAndSize();
        setHeaderPanel();
        setTable();
        addRow();
        resizeColumnWidth(table);
        addComponentsToContainer();
        setLabel();
        setButtonPanel();
        setBackButton();
        setFrame();

    }

    private void setLayoutManager() {
        container.setBackground(Color.WHITE);
        container.setLayout(null);
    }

    private void setLabel() {
        passLabel.setFont(new Font("Roboto", Font.BOLD, 24));
        passLabel.setBounds(0, 70, 1200, 80);
        passLabel.setHorizontalAlignment(JLabel.CENTER);
        container.add(passLabel);
    }

    private void setBackButton() {
        backButton.setFont(new Font("Roboto", Font.BOLD, 17));
        backButton.setBounds(10, 599, 90, 40);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        container.add(backButton);
    }

    private void setButtonPanel() {
        buttonPanel.setBounds(552, 465, 650, 198);
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setLayout(null);
        statusLabel.setBounds(250, 90, 120, 30);
        statusTextField.setBounds(350, 90, 160, 30);
        idLabel.setBounds(20, 90, 120, 30);
        idTextField.setBounds(60, 90, 160, 30);
        validLabel.setBounds(250, 140, 120, 30);
        validTextField.setBounds(350, 140, 160, 30);
        showButton.setBounds(530, 40, 100, 30);
        statusLabel.setFont(new Font("Roboto", Font.BOLD, 18));
        statusTextField.setFont(new Font("Roboto", Font.PLAIN, 18));
        validLabel.setFont(new Font("Roboto", Font.BOLD, 18));
        validTextField.setFont(new Font("Roboto", Font.PLAIN, 18));
        idLabel.setFont(new Font("Roboto", Font.BOLD, 18));
        idTextField.setFont(new Font("Roboto", Font.PLAIN, 18));
        showButton.setFont(new Font("Roboto", Font.BOLD, 18));
        updateStatusButton.setFont(new Font("Roboto", Font.BOLD, 18));
        updateDateButton.setFont(new Font("Roboto", Font.BOLD, 18));
        updateStatusButton.setBounds(530, 140, 100, 30);
        updateDateButton.setBounds(530, 90, 100, 30);
        showButton.setBackground(new Color(39, 54, 147));
        showButton.setForeground(Color.WHITE);
        updateStatusButton.setBackground(new Color(39, 54, 147));
        updateStatusButton.setForeground(Color.WHITE);
        updateDateButton.setBackground(new Color(39, 54, 147));
        updateDateButton.setForeground(Color.WHITE);

        validTextField.setOpaque(true);
        validTextField.setBackground(new Color(216, 216, 216));
        statusTextField.setOpaque(true);
        statusTextField.setBackground(new Color(216, 216, 216));
        idTextField.setOpaque(true);
        idTextField.setBackground(new Color(216, 216, 216));
        buttonPanel.add(showButton);
        buttonPanel.add(updateStatusButton);
        buttonPanel.add(updateDateButton);
        buttonPanel.add(statusTextField);
        buttonPanel.add(statusLabel);
        buttonPanel.add(idLabel);
        buttonPanel.add(idTextField);
        buttonPanel.add(validLabel);
        buttonPanel.add(validTextField);
        buttonPanel.setLayout(null);
        container.add(buttonPanel);
    }

    private void setHeaderPanel() {
        headerPanel.setBackground(new Color(39, 54, 147));
        headerPanel.setLayout(new GridLayout(1, 1, 0, 0));
        ImageIcon iconLogo = new ImageIcon(new ImageIcon("C:/Users/dhars/Desktop/dbluelogo.png").getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH));
        headerTitleLabel.setIcon(iconLogo);
        headerTitleLabel.setFont(new Font("Roboto", Font.BOLD, 26));
        headerTitleLabel.setForeground(Color.white);
        headerPanel.add(headerTitleLabel);
        //sp.setCorner(, container);
    }

    private void setTable() {
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollpane.setPreferredSize(new Dimension(1195, 326));
        table.setRowHeight(35);
        table.getTableHeader().setBackground(new Color(39, 54, 147));
        table.getTableHeader().setForeground(Color.white);
        table.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 18));
        table.setFont(new Font("Roboto", Font.PLAIN, 14));
        table.getTableHeader().setReorderingAllowed(false);
        scrollpane.setViewportView(table);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        bodyPanel.add(scrollpane);
    }

    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 30, width);
            }
            if (width > 300) {
                width = 300;
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    public void addRow() {
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        table.setModel(model);
        model.addColumn("EMAIL");
        model.addColumn("PASSWORD");
        model.addColumn("FIRST NAME");
        model.addColumn("FIRST NAME");
        model.addColumn("FIRST NAME");
        model.addColumn("FIRST NAME");
        model.addColumn("FIRST NAME");
        model.addColumn("FIRST NAME");
        model.addColumn("FIRST NAME");
        model.addColumn("FIRST NAME");
        model.addColumn("FIRST NAME");
        model.addColumn("FIRST NAME");

        //model.addColumn("email");
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\SQLiteStudio-3.2.1 (1)\\SQLiteStudio\\skcet");
            Statement stmt = con.createStatement();
            String query = "select * from login";
            //System.out.println("connection established");
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String s = rs.getString("email");
                String s1 = rs.getString("password");
                String s2 = rs.getString("fname");
                //System.out.println(s+" "+s1);
                model.addRow(new Object[]{s, s1, s2});
            }
            con.close();
        } catch (Exception ae) {

        }
    }

    private void setLocationAndSize() {
        headerPanel.setBounds(0, 0, 1200, 70);
        bodyPanel.setBounds(0, 150, 1200, 326);
    }

    private void addComponentsToContainer() {
        container.add(headerPanel);
        container.add(bodyPanel);
    }

    private void setFrame() {
        Image icon = Toolkit.getDefaultToolkit().getImage("C:/Users/dhars/Desktop/dbluelogo.png");
        setIconImage(icon);
        setVisible(true);
        setBounds(0, 0, 1200, 675);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    public static void main(String args[]) {
        TableDesign tb = new TableDesign();
    }
}
