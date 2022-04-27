import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class interfaz extends JFrame {

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txtpass;
	private JTextField txtuser;
	private JTextField txtrol;
	private JTextField txtemail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfaz frame = new interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public interfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtid = new JTextField();
		txtid.setBounds(54, 78, 86, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		txtname = new JTextField();
		txtname.setBounds(189, 78, 86, 20);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txtpass = new JTextField();
		txtpass.setColumns(10);
		txtpass.setBounds(490, 78, 86, 20);
		contentPane.add(txtpass);
		
		txtuser = new JTextField();
		txtuser.setColumns(10);
		txtuser.setBounds(355, 78, 86, 20);
		contentPane.add(txtuser);
		
		txtrol = new JTextField();
		txtrol.setColumns(10);
		txtrol.setBounds(780, 78, 86, 20);
		contentPane.add(txtrol);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(645, 78, 86, 20);
		contentPane.add(txtemail);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(82, 53, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("name");
		lblNewLabel_1.setBounds(206, 53, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("user_name");
		lblNewLabel_2.setBounds(367, 53, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("password");
		lblNewLabel_3.setBounds(504, 53, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("email");
		lblNewLabel_4.setBounds(667, 53, 64, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("rol");
		lblNewLabel_5.setBounds(806, 53, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JList list = new JList();
		list.setBounds(60, 206, 806, 224);
		contentPane.add(list);
		
		DefaultListModel ltProducto2 = new DefaultListModel();
		DefaultListModel ltProducto = new DefaultListModel();
		JButton btnNewButton = new JButton("agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mysql conexion = new mysql();
				
				
				Connection cn = null;
				Statement stm = null;
				ResultSet rs = null;
				
				
				
				try {
					cn = conexion.conectar();
					stm = cn.createStatement();
					
					ltProducto.clear();
				
							
					
					stm.executeUpdate("INSERT INTO users(id_int, name, user_name, password, email, rols_id)" 
							+ "VALUES ("+txtid.getText()+",'"+ txtname.getText()+"','"+ txtuser.getText()+"','"+txtpass.getText()+"','"+
							txtemail.getText()+"',"+txtrol.getText()+")");
					
					rs = stm.executeQuery("SELECT * FROM users");
					
					while (rs.next()) {
						
						int id = rs.getInt(1);
						String name = rs.getString(2);
						String user = rs.getString(3);
						String pass = rs.getString(4);
						String email = rs.getString(5);
						int rol = rs.getInt(6);
						
						
						
						ltProducto.addElement("ID:  "+id+ "| Name: "+name+"| User:  "+user+"| Pass:  "+pass+"| Email:  "+email+"| Rol:  "+rol);
						
						list.setModel(ltProducto);
						
						}
						cn.close();
					
				} catch (SQLException eroor) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton.setBounds(427, 142, 89, 23);
		contentPane.add(btnNewButton);
	}
}
