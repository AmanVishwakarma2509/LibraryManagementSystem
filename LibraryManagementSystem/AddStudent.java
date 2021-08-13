package LibraryManagementSystem;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddStudent extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4;
    private JComboBox comboBox;
    JButton b1,b2;

    public static void main(String[] args) {
        new AddStudent().setVisible(true);
    }

    public void random() {
        Random rd = new Random();
        t1.setText("" + rd.nextInt(10000 + 1));
    }

    public AddStudent() {
        super("Add Student");
        setBounds(250, 100, 400, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("Student ID");
        l1.setForeground(new Color(0,0,0));
        l1.setFont(new Font("Verdana", Font.PLAIN, 14));
        l1.setBounds(64, 63, 102, 22);
        contentPane.add(l1);

        JLabel l2 = new JLabel("Student Name");
        l2.setForeground(new Color(0,0,0));
        l2.setFont(new Font("Verdana", Font.PLAIN, 14));
        l2.setBounds(64, 97, 102, 22);
        contentPane.add(l2);

        JLabel l4 = new JLabel("Course");
        l4.setForeground(new Color(0,0,0));
        l4.setFont(new Font("Verdana", Font.PLAIN, 14));
        l4.setBounds(64, 130, 102, 22);
        contentPane.add(l4);

        JLabel l5 = new JLabel("Phone No");
        l5.setForeground(new Color(0,0,0));
        l5.setFont(new Font("Verdana", Font.PLAIN, 14));
        l5.setBounds(64, 165, 102, 22);
        contentPane.add(l5);

        JLabel l6 = new JLabel("Email id");
        l6.setForeground(new Color(0,0,0));
        l6.setFont(new Font("Verdana", Font.PLAIN, 14));
        l6.setBounds(64, 200, 102, 22);
        contentPane.add(l6);

        t1 = new JTextField(); //StudentID
        t1.setEditable(false);
        t1.setForeground(new Color(47, 79, 79));
        t1.setFont(new Font("Verdana", Font.PLAIN, 14));
        t1.setBounds(174, 66, 156, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        t2 = new JTextField(); //Student Name
        t2.setForeground(new Color(47, 79, 79));
        t2.setFont(new Font("Verdana", Font.PLAIN, 14));
        t2.setColumns(10);
        t2.setBounds(174, 100, 156, 20);
        contentPane.add(t2);

        t3 = new JTextField(); // Phone no
        t3.setForeground(new Color(47, 79, 79));
        t3.setFont(new Font("Verdana", Font.PLAIN, 14));
        t3.setColumns(10);
        t3.setBounds(174, 165, 156, 20);
        contentPane.add(t3);

        t4 = new JTextField(); // Email id
        t4.setForeground(new Color(47, 79, 79));
        t4.setFont(new Font("Verdana", Font.PLAIN, 14));
        t4.setColumns(10);
        t4.setBounds(174, 200, 156, 20);
        contentPane.add(t4);

        b1 = new JButton("ADD");
        b1.addActionListener(this);
        b1.setFont(new Font("Verdana", Font.PLAIN, 14));
        b1.setBounds(64, 250, 111, 33);
        b1.setBackground(new Color(255, 113, 113));
        b1.setForeground(Color.BLACK);
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setFont(new Font("Verdana", Font.PLAIN, 14));
        b2.setBounds(198, 250, 111, 33);
        b2.setBackground(new Color(255, 113, 113));
        b2.setForeground(Color.BLACK);
        contentPane.add(b2);

        comboBox = new JComboBox();  //Course
        comboBox.setModel(new DefaultComboBoxModel(
                new String[] { "B.E", "B.Tech", "M.Tech", "MBA", "BBA", "BCA", "B.Sc", "M.Sc", "B.Com", "M.Com" }));
        comboBox.setForeground(new Color(47, 79, 79));
        comboBox.setFont(new Font("Verdana", Font.PLAIN, 14));
        comboBox.setBounds(176, 133, 154, 20);
        contentPane.add(comboBox);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0,0,0), 2, true), "Add Student Details",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0,0,0)));
        panel.setBackground(new Color(240, 228, 215));
        panel.setBounds(10, 38, 358, 275);

        contentPane.setBackground(new Color(240, 228, 215));
        panel.setBackground(new Color(240, 228, 215));

        contentPane.add(panel);
        random();
    }

    public void actionPerformed(ActionEvent ae){
        try{

            if(ae.getSource() == b1){
                try{
                    ConnectToDatabase connection = new ConnectToDatabase();
                    String sql = "insert into addstudent(studentid, studentname, course, phoneno, emailid) values(?, ?, ?, ?, ?)";
                    PreparedStatement st = connection.connect.prepareStatement(sql);
                    st.setString(1, t1.getText());
                    st.setString(2, t2.getText());
                    st.setString(3, (String) comboBox.getSelectedItem());
                    st.setString(4, t3.getText());
                    st.setString(5, t4.getText());

                    int i = st.executeUpdate();
                    if (i > 0){
                        JOptionPane.showMessageDialog(null, "Successfully Added");
                        this.setVisible(false);
                        new Home().setVisible(true);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "error");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            if(ae.getSource() == b2){
                this.setVisible(false);
                new Home().setVisible(true);
            }
        }catch(Exception e){

        }
    }
}

