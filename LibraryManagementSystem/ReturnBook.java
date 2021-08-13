package LibraryManagementSystem;


import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.*;

public class ReturnBook extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton b1,b2,b3,b4;
    private JDateChooser dateChooser;

    public static void main(String[] args) {
        new ReturnBook().setVisible(true);
    }

    public void delete() {
        try {
            ConnectToDatabase connect = new ConnectToDatabase();
            String sql = "delete from issueBook where bookid=?";
            PreparedStatement st = connect.connect.prepareStatement(sql);
            st.setString(1, textField.getText());
            int i = st.executeUpdate();
            if (i > 0)
                JOptionPane.showConfirmDialog(null, "Book Returned");
            else
                JOptionPane.showMessageDialog(null, "error in Deleting");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }

    public ReturnBook() {
        setBounds(450, 100, 617, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(new Color(240, 228, 215));
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Book ID");
        lblNewLabel.setForeground(new Color(0,0,0));
        lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        lblNewLabel.setBounds(52, 52, 87, 24);
        contentPane.add(lblNewLabel);

        JLabel lblStudentid = new JLabel("Student ID");
        lblStudentid.setForeground(new Color(0,0,0));
        lblStudentid.setFont(new Font("Verdana", Font.PLAIN, 14));
        lblStudentid.setBounds(52, 98, 87, 24);
        contentPane.add(lblStudentid);

        JLabel lblBook = new JLabel("Book Name");
        lblBook.setForeground(new Color(0,0,0));
        lblBook.setFont(new Font("Verdana", Font.PLAIN, 14));
        lblBook.setBounds(52, 143, 87, 24);
        contentPane.add(lblBook);

        JLabel lblName = new JLabel("Student Name");
        lblName.setForeground(new Color(0,0,0));
        lblName.setFont(new Font("Verdana", Font.PLAIN, 14));
        lblName.setBounds(52, 188, 105, 29);
        contentPane.add(lblName);

        JLabel lblCourse = new JLabel("Course");
        lblCourse.setForeground(new Color(0,0,0));
        lblCourse.setFont(new Font("Verdana", Font.PLAIN, 14));
        lblCourse.setBounds(52, 234, 118, 29);
        contentPane.add(lblCourse);


        JLabel lblDateOfIssue = new JLabel("Date of Issue");
        lblDateOfIssue.setForeground(new Color(0,0,0));
        lblDateOfIssue.setFont(new Font("Verdana", Font.PLAIN, 14));
        lblDateOfIssue.setBounds(52, 280, 105, 29);
        contentPane.add(lblDateOfIssue);

        JLabel lblDateOfReturn = new JLabel("Date of Return");
        lblDateOfReturn.setForeground(new Color(0,0,0));
        lblDateOfReturn.setFont(new Font("Verdana", Font.PLAIN, 14));
        lblDateOfReturn.setBounds(52, 325, 118, 29);
        contentPane.add(lblDateOfReturn);

        textField = new JTextField(); // BookID
        textField.setForeground(new Color(0,0,0));
        textField.setFont(new Font("Verdana", Font.PLAIN, 14));
        textField.setBounds(167, 56, 105, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        textField1 = new JTextField(); // StudentID
        textField1.setForeground(new Color(0,0,0));
        textField1.setFont(new Font("Verdana", Font.PLAIN, 14));
        textField1.setBounds(167, 102, 105, 20);
        contentPane.add(textField1);
        textField1.setColumns(10);

        b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setBounds(300, 52, 105, 29);
        b1.setFont(new Font("Verdana", Font.PLAIN, 15));
        b1.setBorder(new LineBorder(new Color(0,0,0), 1, true));
        b1.setBackground(new Color(255, 113, 113));
        b1.setForeground(Color.BLACK);
        contentPane.add(b1);

        textField2 = new JTextField(); //Bookname
        textField2.setEditable(false);
        textField2.setForeground(new Color(0,0,0));
        textField2.setFont(new Font("Verdana", Font.PLAIN, 13));
        textField2.setBounds(167, 143, 179, 20);
        contentPane.add(textField2);
        textField2.setColumns(10);

        textField3 = new JTextField(); //Course
        textField3.setEditable(false);
        textField3.setForeground(new Color(0, 0, 0));
        textField3.setFont(new Font("Verdana", Font.PLAIN, 13));
        textField3.setColumns(10);
        textField3.setBounds(167,234 , 179, 20);
        contentPane.add(textField3);


        textField5 = new JTextField(); // Date Of Issue
        textField5.setForeground(new Color(0, 0, 0));
        textField5.setFont(new Font("Verdana", Font.PLAIN, 13));
        textField5.setEditable(false);
        textField5.setColumns(10);
        textField5.setBounds(167, 280, 179, 20);
        contentPane.add(textField5);

        textField6 = new JTextField(); //student Name
        textField6.setForeground(new Color(0, 0, 0));
        textField6.setFont(new Font("Verdana", Font.PLAIN, 13));
        textField6.setEditable(false);
        textField6.setColumns(10);
        textField6.setBounds(167, 194, 179, 20);
        contentPane.add(textField6);

        dateChooser = new JDateChooser();
        dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
        dateChooser.setBounds(167, 327, 172, 29);
        contentPane.add(dateChooser);

        b4 = new JButton("Return");
        b4.addActionListener(this);
        b4.setFont(new Font("Verdana", Font.PLAIN, 15));
        b4.setBorder(new LineBorder(new Color(0,0,0), 1, true));
        b4.setBounds(369,325 , 149, 30);
        b4.setBackground(new Color(255, 113, 113));
        b4.setForeground(Color.BLACK);
        contentPane.add(b4);

        b3 = new JButton("Back");
        b3.addActionListener(this);
        b3.setFont(new Font("Verdana", Font.PLAIN, 15));
        b3.setBorder(new LineBorder(new Color(0,0,0), 1, true));
        b3.setBounds(369, 280, 149, 30);
        b3.setBackground(new Color(255, 113, 113));
        b3.setForeground(Color.BLACK);
        contentPane.add(b3);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0,0,0), 2, true), "Return Book Details",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0,0,0)));
        panel.setBounds(10, 24, 569, 400);
        panel.setBackground(new Color(240, 228, 215));
        contentPane.add(panel);
    }

    public void actionPerformed(ActionEvent ae){
        try{
            ConnectToDatabase connect = new ConnectToDatabase();
            if(ae.getSource() == b1){
                String sql = "select * from issueBook where studentid = ? or bookid =?";
                PreparedStatement st = connect.connect.prepareStatement(sql);
                st.setString(2, textField.getText());
                st.setString(1, textField1.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    textField.setText(rs.getString("bookid"));
                    textField1.setText(rs.getString("studentid"));
                    textField2.setText(rs.getString("bookname"));
                    textField3.setText(rs.getString("course"));
                    textField5.setText(rs.getString("dateofissue"));
                    textField6.setText(rs.getString("studentname"));
                }
                st.close();
                rs.close();

            }
            if(ae.getSource() == b4){
                String sql = "insert into returnBook(bookid, studentid, bookname,studentname,course, dateOfIssue, dateOfReturn) values(?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement st = connect.connect.prepareStatement(sql);
                st.setString(1, textField.getText());
                st.setString(2, textField1.getText());
                st.setString(3, textField2.getText());
                st.setString(4, textField6.getText());
                st.setString(5, textField3.getText());
                st.setString(6, textField5.getText());
                st.setString(7, ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText());

                int i = st.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Processing..");
                    delete();
                } else
                    JOptionPane.showMessageDialog(null, "error");

            }

            if(ae.getSource() == b3){
                this.setVisible(false);
                new Home().setVisible(true);

            }
        }catch(Exception e){

        }
    }
}
