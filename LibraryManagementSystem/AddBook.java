package LibraryManagementSystem;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddBook extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5;
    private JButton b1,b2;
    JComboBox comboBox;

    public static void main(String[] args) {
        new AddBook().setVisible(true);
    }

    public AddBook(){
        setBounds(450,100,435,400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel J1 = new JLabel("Book Name");
        J1.setForeground(new Color(0,0,0));
        J1.setFont(new Font("Verdana",Font.PLAIN,14));
        J1.setBounds(73,84,90,22);
        contentPane.add(J1);

        JLabel J2 = new JLabel("Author ");
        J2.setForeground(new Color(0,0,0));
        J2.setFont(new Font("Verdana",Font.PLAIN,13));
        J2.setBounds(73, 117, 90, 22);
        contentPane.add(J2);

        JLabel J3 = new JLabel("Pages");
        J3.setForeground(new Color(0,0,0));
        J3.setFont(new Font("Verdana",Font.PLAIN,14));
        J3.setBounds(73, 150, 90, 22);
        contentPane.add(J3);

        JLabel J4 = new JLabel("Price");
        J4.setForeground(new Color(0,0,0));
        J4.setFont(new Font("Verdana",Font.PLAIN,14));
        J4.setBounds(73, 216, 90, 22);
        contentPane.add(J4);

        JLabel J6 = new JLabel("BookID");
        J6.setForeground(new Color(0,0,0));
        J6.setFont(new Font("Verdana",Font.PLAIN,14));
        J6.setBounds(73, 51, 90, 22);
        contentPane.add(J6);

        JLabel l7 = new JLabel("Genre");
        l7.setForeground(new Color(0,0,0));
        l7.setFont(new Font("Verdana", Font.PLAIN, 14));
        l7.setBounds(73, 183, 90, 22);
        contentPane.add(l7);

        t1 = new JTextField(); //BookID
        t1.setForeground(new Color(47,79,79));
        t1.setFont(new Font("Verdana", Font.PLAIN, 14));
        t1.setBounds(169,54,198,20);
        contentPane.add(t1);
        t1.setColumns(10);

        t2 = new JTextField(); //BookName
        t2.setForeground(new Color(47,79,79));
        t2.setFont(new Font("Verdana", Font.PLAIN, 14));
        t2.setBounds(169,87,198,20);
        contentPane.add(t2);
        t2.setColumns(10);

        t3 = new JTextField(); //Author
        t3.setForeground(new Color(47,79,79));
        t3.setFont(new Font("Verdana", Font.PLAIN, 14));
        t3.setBounds(169,120,198,20);
        contentPane.add(t3);
        t3.setColumns(10);

        t4 = new JTextField(); //Pages
        t4.setForeground(new Color(47,79,79));
        t4.setFont(new Font("Verdana", Font.PLAIN, 14));
        t4.setBounds(169,153,198,20);
        contentPane.add(t4);
        t4.setColumns(10);

        t5 = new JTextField(); // Price
        t5.setForeground(new Color(47,79,79));
        t5.setFont(new Font("Verdana", Font.PLAIN, 14));
        t5.setBounds(169,219,198,20);
        contentPane.add(t5);
        t5.setColumns(10);


        comboBox = new JComboBox(); // Genre
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Historical", "Science", "Geography", "Mathematics", "Engineering","Thriller", "Horror", "Adventure", "Fantasy","Sociology","Programming" }));
        comboBox.setBounds(169,186,198,20);
        contentPane.add(comboBox);

        b1 = new JButton("Add");
        b1.addActionListener(this);
        b1.setBorder(new LineBorder(new Color(0,0,0), 1, true));
        b1.setBounds(220,250,100,33);
        b1.setFont(new Font("Verdana", Font.PLAIN, 14));
        b1.setBackground(new Color(255, 113, 113));
        b1.setForeground(Color.BLACK);
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBorder(new LineBorder(new Color(0,0,0), 1, true));
        b2.setBounds(90,250,108,33);
        b2.setFont(new Font("Verdana", Font.PLAIN, 14));
        b2.setBackground(new Color(255, 113, 113));
        b2.setForeground(Color.BLACK);
        contentPane.add(b2);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0,0,0),2),"Add Books Section",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0,0,0)));
        panel.setBounds(10,29,398,300);
        panel.setBackground(new Color(240, 228, 215));
        contentPane.add(panel);
        contentPane.setBackground(new Color(240, 228, 215));
    }

    public void actionPerformed(ActionEvent ae){
        try {
            ConnectToDatabase con = new ConnectToDatabase();
            if (ae.getSource() == b1) {
                String sql = "insert into addbook(BookId, bookname, author, pages, genre, price) values(?, ?, ?, ?, ?, ?)";
                PreparedStatement st = con.connect.prepareStatement(sql);
                st.setString(1, this.t1.getText());
                st.setString(2, this.t2.getText());
                st.setString(3, this.t3.getText());
                st.setString(4, this.t4.getText());
                st.setString(5, (String)this.comboBox.getSelectedItem());
                st.setString(6, this.t5.getText());
                int rs = st.executeUpdate();
                if (rs > 0) {
                    JOptionPane.showMessageDialog((Component)null, "Successfully Added");
                } else {
                    JOptionPane.showMessageDialog((Component)null, "Error");
                }

                this.t1.setText("");
                this.t2.setText("");
                this.t3.setText("");
                this.t4.setText("");
                this.t5.setText("");
                st.close();
            }

            if (ae.getSource() == b2) {
                this.setVisible(false);
                (new Home()).setVisible(true);
            }

            con.connect.close();
        } catch (Exception var6) {
        }

    }
    }


