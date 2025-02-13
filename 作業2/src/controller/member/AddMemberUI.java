package controller.member;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.impl.MemberServiceImpl;
import util.Clock;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddMemberUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMemberUI frame = new AddMemberUI();
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
	public AddMemberUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 483);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(239, 182, 248));
		contentPane.setBorder(new EmptyBorder(5, 5, 480, 480));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(241, 182, 235));
		panel.setBounds(26, 10, 416, 67);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("註冊");
		lblNewLabel.setBackground(new Color(222, 80, 208));
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(21, 5, 371, 62);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(241, 182, 235));
		panel_1.setBounds(10, 81, 451, 355);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("姓名:");
		lblNewLabel_1.setBounds(60, 22, 63, 35);
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 20));
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("帳號:");
		lblNewLabel_1_1.setBounds(60, 82, 63, 35);
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 20));
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("密碼:");
		lblNewLabel_1_2.setBounds(60, 137, 63, 35);
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.BOLD, 20));
		panel_1.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("地址:");
		lblNewLabel_1_3.setBounds(60, 195, 63, 35);
		lblNewLabel_1_3.setFont(new Font("新細明體", Font.BOLD, 20));
		panel_1.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("手機:");
		lblNewLabel_1_4.setBounds(60, 261, 63, 35);
		lblNewLabel_1_4.setFont(new Font("新細明體", Font.BOLD, 20));
		panel_1.add(lblNewLabel_1_4);

		name = new JTextField();
		name.setBounds(155, 22, 191, 29);
		panel_1.add(name);
		name.setColumns(10);

		username = new JTextField();
		username.setBounds(155, 82, 191, 29);
		username.setColumns(10);
		panel_1.add(username);

		password = new JTextField();
		password.setBounds(155, 137, 191, 29);
		password.setColumns(10);
		panel_1.add(password);

		address = new JTextField();
		address.setBounds(155, 195, 191, 29);
		address.setColumns(10);
		panel_1.add(address);

		phone = new JTextField();
		phone.setBounds(155, 261, 191, 29);
		phone.setColumns(10);
		panel_1.add(phone);

		
		//*******確認按鈕*******
		
		JButton btnNewButton = new JButton("確認");
		btnNewButton.setBounds(338, 300, 86, 29);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String Username = username.getText();
				String Password = password.getText();
				String Name = name.getText();
				String Address = address.getText();
				String Phone = phone.getText();
				if (new MemberServiceImpl().isUsernameBeenUse(Username)
						|| !new MemberServiceImpl().isValidUsername(Username)
						|| !new MemberServiceImpl().isValidPassword(Password)
						|| !new MemberServiceImpl().isValidPhone(Phone)) {
					System.out.print("NO");
					AddMemberErrorUI addmembererror = new AddMemberErrorUI();
					addmembererror.setVisible(true);
					dispose();

				}

				else {

					Member member = new Member(Name, Username, Password, Address, Phone);
					new MemberServiceImpl().addMember(member);
					AddMemberSuccessUI addmembersuccess = new AddMemberSuccessUI();
					addmembersuccess.setVisible(true);
					dispose();

				}
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 20));
		panel_1.add(btnNewButton);
		
		//*******時間********
		
		JLabel clock = new JLabel("New label");
		clock.setFont(new Font("新細明體", Font.BOLD, 15));
		clock.setBounds(258, 330, 193, 25);
		panel_1.add(clock);
		clock.setHorizontalAlignment(SwingConstants.CENTER);
		Timer timer = new Timer(1000, e -> Clock.updateDateTime(clock));
		
		JButton btnNewButton_1 = new JButton("返回登入");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI login=new LoginUI();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 20));
		btnNewButton_1.setBounds(60, 316, 125, 29);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("*英文開頭後面加上數字，並且總長度不超過12個字");
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 12));
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setBounds(155, 112, 286, 29);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("*限定填寫數字");
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setFont(new Font("新細明體", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(155, 170, 205, 29);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("*限定填寫數字");
		lblNewLabel_3_1.setForeground(Color.RED);
		lblNewLabel_3_1.setFont(new Font("新細明體", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(155, 291, 205, 29);
		panel_1.add(lblNewLabel_3_1);
		timer.start();
	}
}
