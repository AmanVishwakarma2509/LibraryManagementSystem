package LibraryManagementSystem;
import jdk.jshell.execution.LoaderDelegate;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import java.awt.event.*;
import java.sql.*;

public class LoginUser extends JFrame implements ActionListener {

    private JPanel panel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton b1,b2,b3;


    public LoginUser() {

        setBackground(new Color(240, 228, 215));
        setBounds(300, 100, 650, 400);
        panel = new JPanel();
        panel.setBackground(new Color(240, 228, 215));
        setContentPane(panel);
        panel.setLayout(null);


        JLabel l1 = new JLabel("Username: ");
        l1.setBounds(124, 89, 95, 24);
        l1.setFont(new Font("Verdana", Font.PLAIN, 15));
        panel.add(l1);

        JLabel l2 = new JLabel("Password : ");
        l2.setBounds(124, 124, 95, 24);
        l2.setFont(new Font("Verdana", Font.PLAIN, 15));
        panel.add(l2);

        textField = new JTextField();
        textField.setBounds(210, 93, 157, 20);
        panel.add(textField);

        passwordField = new JPasswordField();
        passwordField.setBounds(210, 128, 157, 20);
        panel.add(passwordField);

        JLabel l3 = new JLabel("");
        l3.setBounds(377, 79, 46, 34);
        l3.setFont(new Font("Verdana", Font.PLAIN, 15));
        panel.add(l3);

        JLabel l4 = new JLabel("");
        l4.setBounds(377, 124, 46, 34);
        l4.setFont(new Font("Verdana", Font.PLAIN, 15));
        panel.add(l3);

        JLabel l6 = new JLabel("Apna Library Welcomes You");
        l6.setBounds(120, 30, 300, 40);
        l6.setFont(new Font("Verdana", Font.BOLD, 18));
        panel.add(l6);

        b1 = new JButton("Login");
        b1.addActionListener(this);
        b1.setBorder(new LineBorder(new Color(0,0,0), 1, true));
        b1.setForeground(new Color(0,0,0));
        b1.setBackground(new Color(255, 113, 113));
        b1.setBounds(149, 181, 113, 39);
        b1.setFont(new Font("Verdana", Font.PLAIN, 15));
        panel.add(b1);

        b2 = new JButton("SignUp");
        b2.addActionListener(this);
        b2.setBorder(new LineBorder(new Color(0,0,0), 1, true));
        b2.setForeground(new Color(0,0,0));
        b2.setBackground(new Color(255, 113, 113));
        b2.setBounds(289, 181, 113, 39);
        b2.setFont(new Font("Verdana", Font.PLAIN, 15));
        panel.add(b2);

        b3 = new JButton("Forgot Password");
        b3.addActionListener(this);
        b3.setBorder(new LineBorder(new Color(0,0,0), 1, true));
        b3.setForeground(new Color(204,0, 0));
        b3.setBackground(new Color(253, 245, 230));
        b3.setBounds(180, 231, 179, 39);
        b3.setFont(new Font("Verdana", Font.PLAIN, 15));
        panel.add(b3);


        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(240, 228, 215));
        panel2.setBounds(24, 40, 434, 263);
        panel.add(panel2);



    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            Boolean status = false;
            try {
                ConnectToDatabase con = new ConnectToDatabase();
                String sql = "select * from signup where username=? and password=?";
                PreparedStatement st = con.connect.prepareStatement(sql);

                st.setString(1, textField.getText());
                st.setString(2, passwordField.getText());

                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    this.setVisible(false);
                    new Home().setVisible(true);
                } else
                    JOptionPane.showMessageDialog(null, "Invalid Login...!.");

            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if(ae.getSource() == b2){
            setVisible(false);
            SignUp su = new SignUp();
            su.setVisible(true);
        }
        if(ae.getSource() == b3){
            setVisible(false);
            Forgot forgot = new Forgot();
            forgot.setVisible(true);
        }
    }
        public static void main(String[] args) {
            new LoginUser().setVisible(true);
        }

    }

