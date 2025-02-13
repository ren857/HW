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

import util.Clock;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginErrorUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginErrorUI frame = new LoginErrorUI();
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
	public LoginErrorUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 483);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(239, 182, 248));
		contentPane.setBorder(new EmptyBorder(5, 5, 480, 480));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(241, 182, 235));
		panel.setBounds(31, 54, 405, 74);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("登入失敗");
		lblNewLabel.setForeground(new Color(64, 0, 64));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 5, 385, 59);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("請重新登入-->");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_1.setBounds(80, 200, 175, 48);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("OR");
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_2.setBounds(170, 277, 53, 24);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("新增帳密-->");
		lblNewLabel_3.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_3.setBounds(80, 336, 143, 29);
		contentPane.add(lblNewLabel_3);

		// ********登入********

		JButton btnNewButton = new JButton("登入");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI login = new LoginUI();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 20));
		btnNewButton.setBounds(243, 206, 110, 38);
		contentPane.add(btnNewButton);

		// ********註冊*********

		JButton btnNewButton_1 = new JButton("註冊");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddMemberUI addmember = new AddMemberUI();
				addmember.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 255));
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 20));
		btnNewButton_1.setBounds(243, 331, 110, 38);
		contentPane.add(btnNewButton_1);

		// ********時間********

		JLabel clock = new JLabel("New label");
		clock.setHorizontalAlignment(SwingConstants.CENTER);
		clock.setBounds(300, 422, 161, 24);
		contentPane.add(clock);
		Timer timer = new Timer(1000, e -> Clock.updateDateTime(clock));
		timer.start();
	}

}
