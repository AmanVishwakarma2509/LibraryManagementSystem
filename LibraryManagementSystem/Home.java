package LibraryManagementSystem;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon.*;

public class Home extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JButton b1,b2,b3,b4,b5,b6;

    public static void main(String[] args) {
        new Home().setVisible(true);
    }

    public Home() {

        setBounds(90, 30, 1000, 650);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JMenuBar menuBar = new JMenuBar();
        menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(153,153,153), new Color(153,153,153)));
//        menuBar.setBackground(Color);
        menuBar.setBounds(0, 10, 1000, 35);
        contentPane.add(menuBar);

        JMenu mnExit = new JMenu("Exit");
        mnExit.setFont(new Font("Verdana", Font.PLAIN, 17));

        JMenuItem mntmLogout = new JMenuItem("Logout");
        mntmLogout.setFont(new Font("Verdana", Font.PLAIN, 17));
        mntmLogout.setBackground(new Color(255, 113, 113));
        mntmLogout.setForeground(new Color(105, 105, 105));
        mntmLogout.addActionListener(this);
        mnExit.add(mntmLogout);

        JMenuItem mntmExit = new JMenuItem("Exit");
        mntmExit.setForeground(new Color(153,153,153));
        mntmExit.setBackground(new Color(255, 113, 113));
        mntmExit.setFont(new Font("Verdana", Font.PLAIN, 17));
        mntmExit.addActionListener(this);
        mnExit.add(mntmExit);


        JMenu mnRecord = new JMenu("Record");
        mnRecord.setFont(new Font("Verdana", Font.PLAIN, 17));


        JMenuItem bookdetails = new JMenuItem("Book Details");
        bookdetails.addActionListener(this);
        bookdetails.setBackground(new Color(240, 228, 215));
        bookdetails.setFont(new Font("Verdana", Font.PLAIN, 17));
        bookdetails.setForeground(Color.DARK_GRAY);
        mnRecord.add(bookdetails);

        JMenuItem studentdetails = new JMenuItem("Student Details");
        studentdetails.setBackground(new Color(240, 228, 215));
        studentdetails.setFont(new Font("Verdana", Font.PLAIN, 17));
        studentdetails.setForeground(Color.DARK_GRAY);
        studentdetails.addActionListener(this);
        mnRecord.add(studentdetails);

        menuBar.add(mnRecord);
        menuBar.add(mnExit);


        JLabel l1 = new JLabel("Welcome To APNA Library");
        l1.setForeground(new Color(255,153,0));
        l1.setFont(new Font("Mv Boli", Font.BOLD, 25));
        l1.setBounds(350, 25, 701, 80);
        contentPane.add(l1);

        JLabel l2 = new JLabel("");
        l2.setVerticalAlignment(SwingConstants.TOP);
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("LibraryManagementSystem/icons/AddBooks.png"));
        Image i2 = i1.getImage().getScaledInstance(75, 75,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l2 = new JLabel(i3);
        l2.setBounds(200, 120, 100, 100);
        contentPane.add(l2);

        JLabel l3;
        new JLabel("");
        ImageIcon i4  = new ImageIcon(ClassLoader.getSystemResource("LibraryManagementSystem/icons/Statistics.png"));
        Image i5 = i4.getImage().getScaledInstance(75, 75,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        l3 = new JLabel(i6);
        l3.setBounds(440, 100, 134, 128);
        contentPane.add(l3);

        JLabel l4;
        new JLabel("");
        ImageIcon i7  = new ImageIcon(ClassLoader.getSystemResource("LibraryManagementSystem/icons/AddStudent.png"));
        Image i8 = i7.getImage().getScaledInstance(75, 75,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        l4 = new JLabel(i9);
        l4.setBounds(650, 100, 225, 152);
        contentPane.add(l4);

        b1 = new JButton("Add Books");
        b1.addActionListener(this);
        b1.setBackground(new Color(255, 113, 113));
        b1.setForeground(new Color(0,0,0));
        b1.setBorder(new LineBorder(new Color(0,0,0), 1, true));
        b1.setFont(new Font("Verdana", Font.PLAIN, 14));
        b1.setBounds(180, 220, 125, 40);
        contentPane.add(b1);

        b2 = new JButton("Statistics");
        b2.addActionListener(this);
        b2.setBackground(new Color(255, 113, 113));
        b2.setForeground(new Color(0,0,0));
        b2.setBorder(new LineBorder(new Color(0,0,0), 1, true));
        b2.setFont(new Font("Verdana", Font.PLAIN, 15));
        b2.setBounds(450, 220, 120, 40);
        contentPane.add(b2);

        b3 = new JButton("Add Student");
        b3.addActionListener(this);
        b3.setBackground(new Color(255, 113, 113));
        b3.setForeground(new Color(0,0,0));
        b3.setFont(new Font("Verdana", Font.PLAIN, 14));
        b3.setBorder(new LineBorder(new Color(0,0,0), 1, true));
        b3.setBounds(700, 220, 120, 40);
        contentPane.add(b3);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0,0,0), 2)));
        panel.setBounds(130, 100, 750, 200);
        panel.setBackground(new Color(240, 228, 215));
        contentPane.add(panel);

        b4 = new JButton("Issue Books");
        b4.addActionListener(this);
        b4.setBackground(new Color(255, 113, 113));
        b4.setForeground(new Color(0,0,0));
        b4.setFont(new Font("Verdana", Font.PLAIN, 15));
        b4.setBorder(new LineBorder(new Color(0,0,0), 1, true));
        b4.setBounds(280, 430, 159, 40);
        contentPane.add(b4);

        b5 = new JButton("Return Books");
        b5.addActionListener(this);
        b5.setBackground(new Color(255, 113, 113));
        b5.setForeground(new Color(0,0,0));
        b5.setBorder(new LineBorder(new Color(0,0,0), 1, true));
        b5.setFont(new Font("Verdana", Font.PLAIN, 15));
        b5.setBounds(600, 430, 159, 40);
        contentPane.add(b5);

        JLabel l5;
        new JLabel("");
        ImageIcon i10  = new ImageIcon(ClassLoader.getSystemResource("LibraryManagementSystem/icons/IssueBook.png"));
        Image i11 = i10.getImage().getScaledInstance(75, 75,Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        l5 = new JLabel(i12);
        l5.setBounds(280, 300, 159, 163);
        contentPane.add(l5);

        JLabel l6;
        new JLabel("");
        ImageIcon i13  = new ImageIcon(ClassLoader.getSystemResource("LibraryManagementSystem/icons/ReturnBook.png"));
        Image i14 = i13.getImage().getScaledInstance(75, 75,Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        l6 = new JLabel(i15);
        l6.setBounds(300, 280, 750, 200);
        contentPane.add(l6);


        JPanel panel2 = new JPanel();
        panel2.setBorder(new TitledBorder(new LineBorder(new Color(0,0,0), 2)));
        panel2.setBounds(130, 200, 750, 300);
        panel2.setBackground(new Color(240, 228, 215));
        contentPane.add(panel2);

        getContentPane().setBackground(new Color(240, 228, 215));
        contentPane.setBackground(new Color(240, 228, 215));
    }


    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("Logout")){
            setVisible(false);
            new LoginUser().setVisible(true);
        }else if(msg.equals("Exit")){
            System.exit(ABORT);

        }
        else if(msg.equals("Book Details")){
            setVisible(false);
            new BookDetails().setVisible(true);
        }else if(msg.equals("Student Details")){
            setVisible(false);
            new StudentDetails().setVisible(true);

        }

        if(ae.getSource() == b1){
            this.setVisible(false);
            new AddBook().setVisible(true);
        }
        if(ae.getSource() == b2){
            this.setVisible(false);
            new Statistics().setVisible(true);
        }
        if(ae.getSource() == b3){
            this.setVisible(false);
            new AddStudent().setVisible(true);
        }
        if(ae.getSource() == b4){
            this.setVisible(false);
            new IssueBook().setVisible(true);
        }
        if(ae.getSource() == b5){
            this.setVisible(false);
            new ReturnBook().setVisible(true);

        }


    }
}



