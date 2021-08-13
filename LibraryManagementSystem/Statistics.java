package LibraryManagementSystem;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import net.proteanit.sql.DbUtils;

public class Statistics extends JFrame {
    private JPanel contentPane;
    private JTable table;
    private JTable table_1;

    public static void main(String[] args) {
        (new Statistics()).setVisible(true);
    }

    public void issueBook() {
        try {
            ConnectToDatabase con = new ConnectToDatabase();
            String sql = "select bookid,bookname,studentid,studentname,dateofissue from issuebook";
            PreparedStatement st = con.connect.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            this.table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception var5) {
        }

    }

    public void returnBook() {
        try {
            ConnectToDatabase con = new ConnectToDatabase();
            String sql = "select bookid,bookname,studentid,studentname,dateofissue,dateofreturn from returnBook";
            PreparedStatement st = con.connect.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            this.table_1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception var5) {
        }

    }

    public Statistics() {
        this.setBounds(200, 50, 810, 594);
        this.contentPane = new JPanel();
        this.contentPane.setBackground(new Color(240, 228, 215));
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout((LayoutManager)null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(40, 51, 708, 217);
        this.contentPane.add(scrollPane);
        this.table = new JTable();
        this.table.setBackground(new Color(240, 228, 215));
        this.table.setForeground(new Color(0,0,0));
        this.table.setFont(new Font("Verdana", Font.PLAIN, 10));
        scrollPane.setViewportView(this.table);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0,0,0), 2, true), "Issue Book Details", 4, 2, (Font)null, new Color(0,0,0)));
        panel.setForeground(new Color(0,0,0));
        panel.setBounds(26, 36, 737, 240);
        panel.setBackground(Color.WHITE);
        this.contentPane.add(panel);
        JLabel l1 = new JLabel("Back");
        l1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                Statistics.this.setVisible(false);
                Home home = new Home();
                home.setVisible(true);
            }
        });
        l1.setForeground(new Color(0,0,0));
        l1.setFont(new Font("Verdana", 1, 18));
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("LibraryManagementSystem/icons/BAck.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, 1);
        ImageIcon i3 = new ImageIcon(i2);
        l1.setIcon(i3);
        l1.setBounds(690, 10, 96, 27);
        this.contentPane.add(l1);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(40, 316, 717, 217);
        this.contentPane.add(scrollPane_1);
        this.table_1 = new JTable();
        this.table_1.setBackground(new Color(240, 228, 215));
        this.table_1.setForeground(new Color(0,0,0));
        this.table_1.setFont(new Font("Verdana", Font.PLAIN, 10));
        scrollPane_1.setViewportView(this.table_1);
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0,0,0), 2, true), "Return Book Details", 3, 2, (Font)null, new Color(0,0,0)));
        panel_1.setBounds(22, 299, 741, 240);
        panel_1.setBackground(Color.WHITE);
        this.contentPane.add(panel_1);
        this.issueBook();
        this.returnBook();
    }
}

