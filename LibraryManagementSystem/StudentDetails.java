package LibraryManagementSystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import net.proteanit.sql.DbUtils;

public class StudentDetails extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JTable table;
    private JTextField search;
    private JButton b1;
    private JButton b2;

    public static void main(String[] args) {
        (new StudentDetails()).setVisible(true);
    }

    public void student() {
        try {
            ConnectToDatabase con = new ConnectToDatabase();
            String sql = "select * from addstudent";
            PreparedStatement st = con.connect.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            this.table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.connect.close();
        } catch (Exception var5) {
        }

    }

    public StudentDetails() {
        this.setBounds(200, 100, 945, 500);
        this.contentPane = new JPanel();
        this.contentPane.setBackground(new Color(240, 228, 215));
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setBackground(new Color(240, 228, 215));
        this.contentPane.setLayout((LayoutManager)null);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(79, 133, 771, 288);
        this.contentPane.add(scrollPane);
        this.table = new JTable();
        this.table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                int row = StudentDetails.this.table.getSelectedRow();
                StudentDetails.this.search.setText(StudentDetails.this.table.getModel().getValueAt(row, 1).toString());
            }
        });
        this.table.setBackground(new Color(240, 228, 215));
        this.table.setForeground(Color.BLACK);
        this.table.setFont(new Font("Verdana",Font.PLAIN, 12));
        scrollPane.setViewportView(this.table);

        JButton b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setBorder(new LineBorder(new Color(0,0,0), 1, true));
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("LibraryManagementSystem/icons/Search.png"));
        Image i2 = i1.getImage().getScaledInstance(30, 30, 1);
        ImageIcon i3 = new ImageIcon(i2);
        b1.setIcon(i3);
        b1.setForeground(new Color(0,0,0));
        b1.setBackground(new Color(255, 113, 113));
        b1.setFont(new Font("Verdana", 1, 14));
        b1.setBounds(600, 89, 110, 30);
        this.contentPane.add(b1);

        JButton b2 = new JButton("Delete");
        b2.addActionListener(this);
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("LibraryManagementSystem/icons/DeleteUser.png"));
        Image i5 = i4.getImage().getScaledInstance(30, 30, 1);
        ImageIcon i6 = new ImageIcon(i5);
        b2.setIcon(i6);
        b2.setForeground(new Color(0,0,0));
        b2.setBackground(new Color(255, 113, 113));
        b2.setFont(new Font("Verdana", 1, 14));
        b2.setBorder(new LineBorder(new Color(0,0,0), 1, true));
        b2.setBounds(730, 89, 110, 30);
        this.contentPane.add(b2);

        JLabel l1 = new JLabel("Student Details");
        l1.setForeground(new Color(0,0,0));
        l1.setFont(new Font("Verdana", Font.PLAIN, 25));
        l1.setBounds(350, 20, 400, 47);
        this.contentPane.add(l1);

        this.search = new JTextField();
        this.search.setBackground(new Color(255, 240, 245));
        this.search.setBorder(new LineBorder(new Color(102,102,102), 2, true));
        this.search.setForeground(new Color(102,102,102));
        this.search.setFont(new Font("Verdana", 3, 17));
        this.search.setBounds(200, 89, 350, 30);
        this.contentPane.add(this.search);
        this.search.setColumns(10);

        JLabel l2 = new JLabel("Back");
        l2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                StudentDetails.this.setVisible(false);
                Home home = new Home();
                home.setVisible(true);
            }
        });
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Verdana", 1, 18));
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("LibraryManagementSystem/icons/BAck.png"));
        Image i8 = i7.getImage().getScaledInstance(20, 20, 1);
        ImageIcon i9 = new ImageIcon(i8);
        l2.setIcon(i9);
        l2.setBounds(97, 89, 100, 30);
        this.contentPane.add(l2);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0,0,0), 3, true)));
        panel.setBounds(68, 59, 790, 370);
        panel.setBackground(new Color(240, 228, 215));
        this.contentPane.add(panel);
        this.student();
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            ConnectToDatabase con = new ConnectToDatabase();
            String sql;
            PreparedStatement st;
            if (ae.getSource() == this.b1) {
                sql = "select * from addstudent where concat(studentname, studentid) like ?";
                st = con.connect.prepareStatement(sql);
                st.setString(1, "%" + this.search.getText() + "%");
                ResultSet rs = st.executeQuery();
                this.table.setModel(DbUtils.resultSetToTableModel(rs));
                rs.close();
                st.close();
            }

            if (ae.getSource() == this.b2) {
                sql = "delete from addstudent where studentname = '" + this.search.getText() + "'";
                st = con.connect.prepareStatement(sql);
                JDialog.setDefaultLookAndFeelDecorated(true);
                int response = JOptionPane.showConfirmDialog((Component)null, "Do you want to continue?", "Confirm", 0, 3);
                if (response != 1) {
                    if (response == 0) {
                        int rs = st.executeUpdate();
                        JOptionPane.showMessageDialog((Component)null, "Deleted !!");
                    } else if (response == -1) {
                    }
                }

                st.close();
            }

            con.connect.close();
        } catch (Exception var7) {
        }

    }
}
