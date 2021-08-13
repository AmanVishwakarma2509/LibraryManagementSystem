package LibraryManagementSystem;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LibraryManagementSystem extends JFrame implements ActionListener{

    JLabel l1,l2,l3,l4;
    JPanel contentPane;
    JButton b1;

    public LibraryManagementSystem() {

        setSize(600,600);
        setLayout(null);
        setLocation(350,50);
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l1;
        new JLabel("");
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("LibraryManagementSystem/icons/LMS.jpg"));
        Image i3 = i1.getImage().getScaledInstance(600, 600,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        l1 = new JLabel(i2);

        l2 = new JLabel("Library");
        l2.setForeground(new Color(232, 167, 167));
        l2.setFont(new Font("Mv Boli", Font.BOLD, 60));
        l2.setBounds(200, 100, 700, 150);
        l1.add(l2);

        l3 = new JLabel("Management");
        l3.setForeground(new Color(232, 167, 167));
        l3.setFont(new Font("Mv Boli", Font.BOLD, 60));
        l3.setBounds(120, 200, 700, 80);
        l1.add(l3);

        l4 = new JLabel("System");
        l4.setForeground(new Color(232, 167, 167));
        l4.setFont(new Font("Mv Boli", Font.BOLD, 60));
        l4.setBounds(195, 280, 700, 80);
        l1.add(l4);


        contentPane.add(l1);
        b1 = new JButton("Next");
        b1.setFont(new Font("Verdana", Font.PLAIN, 14));
        b1.setBackground(new Color(255, 113, 113));
        b1.setForeground(Color.BLACK);
        b1.setBorder(new LineBorder(new Color(0,0,0), 1, true));




        b1.setBounds(242,450,100,30);
        l1.setBounds(0, 0, 600, 600);
        contentPane.add(l1);
        contentPane.add(b1);
        b1.addActionListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        new LoginUser().setVisible(true);
        this.setVisible(false);

    }

    public static void main(String[] args) {
        LibraryManagementSystem window = new LibraryManagementSystem();
        window.setVisible(true);
    }
}