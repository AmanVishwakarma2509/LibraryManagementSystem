package LibraryManagementSystem;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class SignUp extends JFrame implements ActionListener{
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton b1,b2;
    private JComboBox comboBox;

    public static void main(String[] args) {
        new SignUp().setVisible(true);
    }

    public SignUp(){
        setBounds(250,200,570,406);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setBackground(new Color(240, 228, 215));
        contentPane.setLayout(null);

        JLabel J1 = new JLabel("UserName : ");
        J1.setForeground(Color.BLACK);
        J1.setFont(new Font("Verdana",Font.PLAIN,14));
        J1.setBounds(99,86,92,26);
        contentPane.add(J1);

        JLabel J2 = new JLabel("Name : ");
        J2.setForeground(Color.BLACK);
        J2.setFont(new Font("Verdana",Font.PLAIN,14));
        J2.setBounds(99,123,92,26);
        contentPane.add(J2);

        JLabel J3 = new JLabel("Password : ");
        J3.setForeground(Color.BLACK);
        J3.setFont(new Font("Verdana",Font.PLAIN,14));
        J3.setBounds(99,160,92,26);
        contentPane.add(J3);

        JLabel J4 = new JLabel("Answer : ");
        J4.setForeground(Color.BLACK);
        J4.setFont(new Font("Verdana",Font.PLAIN,14));
        J4.setBounds(99,234,92,26);
        contentPane.add(J4);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Your Nickname ?", "Your Lucky Number?"
                ,"Your Favourite colour","Your Date of Birth"}));
        comboBox.setBounds(265,202,148,20);
        contentPane.add(comboBox);

        JLabel J5 = new JLabel("Security Question: ");
        J5.setForeground(Color.BLACK);
        J5.setFont(new Font("Verdana", Font.PLAIN,14));
        J5.setBounds(99, 197, 140, 26);
        contentPane.add(J5);

        textField = new JTextField();
        textField.setBounds(265,91,148,20);
        contentPane.add(textField);
        textField.setColumns(10);

        textField1 = new JTextField();
        textField1.setBounds(265,128,148,20);
        contentPane.add(textField1);
        textField1.setColumns(10);

        textField2 = new JTextField();
        textField2.setBounds(265,165,148,20);
        contentPane.add(textField2);
        textField2.setColumns(10);

        textField3 = new JTextField();
        textField3.setBounds(265,239,148,20);
        contentPane.add(textField3);
        textField3.setColumns(10);

        b1 = new JButton("Create");
        b1.addActionListener(this);
        b1.setFont(new Font("Verdana", Font.PLAIN, 13));
        b1.setBounds(140,289,100,30);
        b1.setBackground(new Color(255, 113, 113));
        b1.setForeground(Color.BLACK);
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setFont(new Font("Verdana", Font.PLAIN, 13));
        b2.setBounds(300,289,100,30);
        b2.setBackground(new Color(255, 113, 113));
        b2.setForeground(Color.BLACK);
        contentPane.add(b2);

        JPanel panel = new JPanel();
        panel.setForeground(new Color(0,0,0));
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0,0,0),2),"Create New Account",
                        TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0,0,0)));
        panel.setBounds(31,35,476,296);
        panel.setBackground(new Color(240, 228, 215));
        contentPane.add(panel);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            ConnectToDatabase con = new ConnectToDatabase();
            if(ae.getSource() == b1){
                String sql = "insert into signup(username, name, password, sq, answer) values(?,?,?,?,?)";
                PreparedStatement st = con.connect.prepareStatement(sql);

                st.setString(1, textField.getText());
                st.setString(2,textField1.getText());
                st.setString(3, textField2.getText());
                st.setString(4,(String) comboBox.getSelectedItem());
                st.setString(5, textField3.getText());

                int i = st.executeUpdate();
                if (i>0){
                    JOptionPane.showMessageDialog(null, "successfully Created");
                }

                textField.setText("");
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
                new LoginUser().setVisible(true);
            }
        }catch (Exception e){

        }
    }

}
