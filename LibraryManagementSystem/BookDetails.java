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

public class BookDetails extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JTable table;
    private JTextField search;
    private JButton b1;
    private JButton b2;
    private JButton b3;

    public static void main(String[] args) {
        (new BookDetails()).setVisible(true);
    }

    public void Book1() {
        try {
            ConnectToDatabase con = new ConnectToDatabase();
            String sql = "select * from addbook";
            PreparedStatement st = con.connect.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            this.table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.connect.close();
        } catch (Exception var5) {
        }

    }

    public BookDetails() {
        this.setBounds(250, 100, 930, 500);
        this.contentPane = new JPanel();
        this.contentPane.setBackground(new Color(240, 228, 215));
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout((LayoutManager)null);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(79, 133, 771, 282);
        this.contentPane.add(scrollPane);
        this.table = new JTable();
        this.table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent arg0) {
                int row = BookDetails.this.table.getSelectedRow();
                BookDetails.this.search.setText(BookDetails.this.table.getModel().getValueAt(row, 1).toString());
            }
        });
        this.table.setBackground(new Color(240, 228, 215));
        this.table.setForeground(new Color(0, 0, 0));
        this.table.setFont(new Font("Verdana", Font.PLAIN, 12));
        scrollPane.setViewportView(this.table);

        JButton b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setBorder(new LineBorder(new Color(0,0,0), 1, true));
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("LibraryManagementSystem/icons/Search.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, 1);
        ImageIcon i3 = new ImageIcon(i2);
        b1.setIcon(i3);
        b1.setBackground(new Color(255, 113, 113));
        b1.setForeground(new Color(0,0,0));
        b1.setFont(new Font("Verdana", Font.PLAIN, 14));
        b1.setBounds(564, 89, 138, 33);
        this.contentPane.add(b1);

        JButton b2 = new JButton("Delete");
        b2.addActionListener(this);
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("LibraryManagementSystem/icons/DeleteUser.png"));
        Image i5 = i4.getImage().getScaledInstance(18, 18, 1);
        ImageIcon i6 = new ImageIcon(i5);
        b2.setIcon(i6);
        b2.setBackground(new Color(255, 113, 113));
        b2.setForeground(new Color(0,0,0));
        b2.setFont(new Font("Verdana", Font.PLAIN, 14));
        b2.setBorder(new LineBorder(new Color(0,0,0), 1, true));
        b2.setBounds(712, 89, 138, 33);
        this.contentPane.add(b2);

        JLabel l1 = new JLabel("Book Details");
        l1.setForeground(new Color(0,0,0));
        l1.setFont(new Font("Verdana", Font.PLAIN, 30));
        l1.setBounds(350, 10, 400, 47);

        this.contentPane.add(l1);
        this.search = new JTextField();
        this.search.setBackground(new Color(240, 228, 215));
        this.search.setBorder(new LineBorder(new Color(0,0,0), 2, true));
        //this.search.setForeground(new Color(240, 228, 215));
        this.search.setFont(new Font("Verdana", Font.PLAIN, 15));
        this.search.setBounds(189, 89, 357, 33);
        this.contentPane.add(this.search);
        this.search.setColumns(10);

        JLabel l3 = new JLabel("Back");
        l3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                BookDetails.this.setVisible(false);
                Home home = new Home();
                home.setVisible(true);
            }
        });
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Verdana", Font.PLAIN, 18));
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("LibraryManagementSystem/icons/BAck.png"));
        Image i8 = i7.getImage().getScaledInstance(20, 20, 1);
        ImageIcon i9 = new ImageIcon(i8);
        l3.setIcon(i9);
        l3.setBounds(97, 89, 72, 33);
        this.contentPane.add(l3);
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0,0,0), 3, true)));
        panel.setBounds(67, 54, 793, 368);
        this.contentPane.add(panel);
        panel.setBackground(Color.WHITE);
        Book1();
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            ConnectToDatabase con = new ConnectToDatabase();
            String sql;
            PreparedStatement st;
            if (ae.getSource() == this.b1) {
                sql = "select * from addbook where concat(bookname, bookid) like ?";
                st = con.connect.prepareStatement(sql);
                st.setString(1, "%" + this.search.getText() + "%");
                ResultSet rs = st.executeQuery();
                this.table.setModel(DbUtils.resultSetToTableModel(rs));
                rs.close();
                st.close();
            }

            if (ae.getSource() == this.b2) {
                sql = "delete from addbook where bookname = '" + this.search.getText() + "'";
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
