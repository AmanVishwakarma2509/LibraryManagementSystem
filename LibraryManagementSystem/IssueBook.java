package LibraryManagementSystem;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class IssueBook extends JFrame implements ActionListener {
    private JPanel contentPane;
    JDateChooser dateChooser;
    private JTextField t1;
    private JTextField t2;
    private JTextField t3;
    private JTextField t4;
    private JTextField t5;
    private JTextField t6;
    private JTextField t8;
    private JTextField t9;
    private JTextField t10;
    private JTextField t11;
    private JTextField t12;
    private JTextField t13;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;

    public static void main(String[] args) {
        (new IssueBook()).setVisible(true);
    }

    public IssueBook() {
        this.setBounds(200, 100, 850, 500);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setBackground(new Color(240, 228, 215));
        this.contentPane.setLayout((LayoutManager)null);

        JLabel l1 = new JLabel("Book ID");
        l1.setFont(new Font("Verdana", Font.PLAIN, 14));
        l1.setForeground(new Color(0,0,0));
        l1.setBounds(47, 63, 100, 23);
        this.contentPane.add(l1);

        JLabel l2 = new JLabel("Book Name");
        l2.setForeground(new Color(0,0,0));
        l2.setFont(new Font("Verdana",Font.PLAIN, 14));
        l2.setBounds(47, 97, 100, 23);
        this.contentPane.add(l2);

        JLabel l3 = new JLabel("Author");
        l3.setForeground(new Color(0,0,0));
        l3.setFont(new Font("Verdana", Font.PLAIN, 14));
        l3.setBounds(47, 131, 100, 23);
        this.contentPane.add(l3);

        JLabel l4 = new JLabel("Pages");
        l4.setForeground(new Color(0,0,0));
        l4.setFont(new Font("Verdana", Font.PLAIN, 14));
        l4.setBounds(47, 165, 100, 23);
        this.contentPane.add(l4);

        JLabel l5 = new JLabel("Genre");
        l5.setForeground(new Color(0,0,0));
        l5.setFont(new Font("Verdana", Font.PLAIN, 14));
        l5.setBounds(47, 199, 100, 23);
        this.contentPane.add(l5);

        JLabel l6 = new JLabel("Price");
        l6.setForeground(new Color(0,0,0));
        l6.setFont(new Font("Verdana", Font.PLAIN, 14));
        l6.setBounds(47, 233, 100, 23);
        this.contentPane.add(l6);

        this.t1 = new JTextField(); // BookID
        this.t1.setForeground(new Color(0,0,0));
        this.t1.setFont(new Font("Verdana", Font.PLAIN, 14));
        this.t1.setBounds(130, 66, 86, 20);
        this.contentPane.add(this.t1);

        this.b1 = new JButton("Search");
        this.b1.addActionListener(this);
        this.b1.setBorder(new LineBorder(new Color(0,0,0), 1, true));
        this.b1.setBackground(new Color(255, 113, 113));
        this.b1.setForeground(Color.BLACK);
        this.b1.setFont(new Font("Verdana", Font.PLAIN, 14));
        this.b1.setBounds(234, 59, 100, 30);
        this.contentPane.add(this.b1);

        this.t2 = new JTextField(); // BookNAme
        this.t2.setEditable(false);
        this.t2.setForeground(new Color(102,102,102));
        this.t2.setFont(new Font("Verdana", Font.PLAIN, 14));
        this.t2.setBounds(130, 100, 208, 20);
        this.contentPane.add(this.t2);
        this.t2.setColumns(10);

        this.t3 = new JTextField(); // Author
        this.t3.setEditable(false);
        this.t3.setForeground(new Color(102,102,102));
        this.t3.setFont(new Font("Verdana", Font.PLAIN, 14));
        this.t3.setColumns(10);
        this.t3.setBounds(130, 131, 208, 20);
        this.contentPane.add(this.t3);

        this.t4 = new JTextField(); //PAges
        this.t4.setEditable(false);
        this.t4.setForeground(new Color(102,102,102));
        this.t4.setFont(new Font("Verdana", Font.PLAIN, 14));
        this.t4.setColumns(10);
        this.t4.setBounds(130, 168, 208, 20);
        this.contentPane.add(this.t4);

        this.t5 = new JTextField(); //Genre
        this.t5.setEditable(false);
        this.t5.setForeground(new Color(102,102,102));
        this.t5.setFont(new Font("Verdana", Font.PLAIN, 14));
        this.t5.setColumns(10);
        this.t5.setBounds(130, 202, 208, 20);
        this.contentPane.add(this.t5);

        this.t6 = new JTextField(); //Price
        this.t6.setEditable(false);
        this.t6.setForeground(new Color(102,102,102));
        this.t6.setFont(new Font("Verdana", Font.PLAIN, 14));
        this.t6.setColumns(10);
        this.t6.setBounds(130, 236, 208, 20);
        this.contentPane.add(this.t6);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0,0,0), 2, true), "Issue Book", 4, 2, (Font)null, new Color(0,0,0)));
        panel.setFont(new Font("Verdana", Font.PLAIN, 14));
        panel.setBounds(30, 38, 345, 250);
        panel.setBackground(new Color(240, 228, 215));
        this.contentPane.add(panel);

        JLabel l8 = new JLabel("Student ID");
        l8.setForeground(new Color(0,0,0));
        l8.setFont(new Font("Verdana", Font.PLAIN, 14));
        l8.setBounds(420, 63, 100, 23);
        this.contentPane.add(l8);

        JLabel l9 = new JLabel("Student Name");
        l9.setForeground(new Color(0,0,0));
        l9.setFont(new Font("Verdana", Font.PLAIN, 13));
        l9.setBounds(420, 103, 100, 23);
        this.contentPane.add(l9);

        JLabel l10 = new JLabel("Course");
        l10.setForeground(new Color(0,0,0));
        l10.setFont(new Font("Verdana", Font.PLAIN, 14));
        l10.setBounds(420, 147, 100, 23);
        this.contentPane.add(l10);

        JLabel l11 = new JLabel("Phone No");
        l11.setForeground(new Color(0,0,0));
        l11.setFont(new Font("Verdana", Font.PLAIN, 14));
        l11.setBounds(420, 187, 100, 23);
        this.contentPane.add(l11);

        JLabel l12 = new JLabel("Email id");
        l12.setForeground(new Color(0,0,0));
        l12.setFont(new Font("Verdana", Font.PLAIN, 14));
        l12.setBounds(420, 233, 100, 23);
        this.contentPane.add(l12);


        this.t8 = new JTextField();  // Student ID
        this.t8.setForeground(new Color(102,102,102));
        this.t8.setFont(new Font("Verdana", Font.PLAIN, 14));
        this.t8.setColumns(10);
        this.t8.setBounds(520, 66, 86, 20);
        this.contentPane.add(this.t8);

        this.b2 = new JButton("Search");
        this.b2.addActionListener(this);
        this.b2.setFont(new Font("Verdana", Font.PLAIN, 14));
        this.b2.setBorder(new LineBorder(new Color(0,0,0), 1, true));
        this.b2.setBounds(650, 59, 100, 30);
        this.b2.setBackground(new Color(255, 113, 113));
        this.b2.setForeground(Color.BLACK);
        this.contentPane.add(this.b2);

        this.t9 = new JTextField();  // Student Name
        this.t9.setForeground(new Color(102,102,102));
        this.t9.setFont(new Font("Verdana", Font.PLAIN, 14));
        this.t9.setEditable(false);
        this.t9.setColumns(10);
        this.t9.setBounds(520, 106, 208, 20);
        this.contentPane.add(this.t9);

        this.t10 = new JTextField();  // Course
        this.t10.setForeground(new Color(102,102,102));
        this.t10.setFont(new Font("Verdana", Font.PLAIN, 14));
        this.t10.setEditable(false);
        this.t10.setColumns(10);
        this.t10.setBounds(520, 150, 208, 20);
        this.contentPane.add(this.t10);

        this.t11 = new JTextField();  // Phone no.
        this.t11.setForeground(new Color(102,102,102));
        this.t11.setFont(new Font("Verdana", Font.PLAIN, 14));
        this.t11.setEditable(false);
        this.t11.setColumns(10);
        this.t11.setBounds(520, 190, 208, 20);
        this.contentPane.add(this.t11);

        this.t12 = new JTextField();   // Email id
        this.t12.setForeground(new Color(102,102,102));
        this.t12.setFont(new Font("Verdana", Font.PLAIN, 14));
        this.t12.setEditable(false);
        this.t12.setColumns(10);
        this.t12.setBounds(520, 236, 208, 20);
        this.contentPane.add(this.t12);


        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0,0,0), 2, true), "Student Details", 4, 2, (Font)null, new Color(0,0,0)));
        panel_1.setForeground(new Color(0, 100, 0));
        panel_1.setBounds(400, 38, 400, 250);
        panel_1.setBackground(new Color(240, 228, 215));
        this.contentPane.add(panel_1);

        JLabel l15 = new JLabel(" Date of Issue :");
        l15.setForeground(new Color(0,0,0));
        l15.setFont(new Font("Verdana", Font.PLAIN, 15));
        l15.setBounds(250, 320, 118, 26);
        this.contentPane.add(l15);
        this.dateChooser = new JDateChooser();
        this.dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        this.dateChooser.setForeground(new Color(105, 105, 105));
        this.dateChooser.setBounds(380, 320, 200, 29);
        this.contentPane.add(this.dateChooser);

        this.b3 = new JButton("Issue");
        this.b3.addActionListener(this);
        this.b3.setFont(new Font("Verdana", Font.PLAIN, 14));
        this.b3.setBorder(new LineBorder(new Color(0,0,0), 1, true));
        this.b3.setBounds(300, 360, 118, 33);
        this.b3.setBackground(new Color(255, 113, 113));
        this.b3.setForeground(Color.BLACK);
        this.contentPane.add(this.b3);

        this.b4 = new JButton("Back");
        this.b4.addActionListener(this);
        this.b4.setFont(new Font("Verdana", Font.PLAIN, 14));
        this.b4.setBorder(new LineBorder(new Color(0,0,0), 1, true));
        this.b4.setBounds(450, 360, 100, 33);
        this.b4.setBackground(new Color(255, 113, 113));
        this.b4.setForeground(Color.BLACK);
        this.contentPane.add(this.b4);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            ConnectToDatabase con = new ConnectToDatabase();
            String sql;
            PreparedStatement st;
            ResultSet rs;
            if (ae.getSource() == this.b1) {
                sql = "select * from addbook where bookid = ?";
                st = con.connect.prepareStatement(sql);
                st.setString(1, this.t1.getText());
                rs = st.executeQuery();

                while(true) {
                    if (!rs.next()) {
                        st.close();
                        rs.close();
                        break;
                    }

                    this.t2.setText(rs.getString("bookname"));
                    this.t3.setText(rs.getString("author"));
                    this.t4.setText(rs.getString("pages"));
                    this.t5.setText(rs.getString("genre"));
                    this.t6.setText(rs.getString("price"));
                }
            }

            if (ae.getSource() == this.b2) {
                sql = "select * from addstudent where studentid = ?";
                st = con.connect.prepareStatement(sql);
                st.setString(1, this.t8.getText());
                rs = st.executeQuery();

                while(rs.next()) {
                    this.t9.setText(rs.getString("studentname"));
                    this.t10.setText(rs.getString("course"));
                    this.t11.setText(rs.getString("phoneno"));
                    this.t12.setText(rs.getString("emailid"));
                }

                st.close();
                rs.close();
            }

            if (ae.getSource() == this.b3) {
                try {
                    sql = "insert into issuebook (BookID,bookname,author,pages,genre,price,DateOfIssue,studentid,studentname,course,phoneno,emailid) values(?, ?, ?, ?, ?, ?, ?,?,?,?,?,?)";
                    st = con.connect.prepareStatement(sql);
                    st.setString(1, this.t1.getText());
                    st.setString(2, this.t2.getText());
                    st.setString(3, this.t3.getText());
                    st.setString(4, this.t4.getText());
                    st.setString(5, this.t5.getText());
                    st.setString(6, this.t6.getText());
                    st.setString(7, ((JTextField)this.dateChooser.getDateEditor().getUiComponent()).getText());
                    st.setString(8, this.t8.getText());
                    st.setString(9, this.t9.getText());
                    st.setString(10, this.t10.getText());
                    st.setString(11, this.t11.getText());
                    st.setString(12, this.t12.getText());

                    int i = st.executeUpdate();
                    if (i > 0) {
                        JOptionPane.showMessageDialog((Component)null, "Successfully Book Issued..!");
                    } else {
                        JOptionPane.showMessageDialog((Component)null, "error");
                    }
                } catch (Exception var6) {
                    var6.printStackTrace();
                }
            }

            if (ae.getSource() == this.b4) {
                this.setVisible(false);
                (new Home()).setVisible(true);
            }

            con.connect.close();
        } catch (Exception var7) {
        }

    }
}
