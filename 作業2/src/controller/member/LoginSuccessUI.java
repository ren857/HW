package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.porder.AddPorderUI;
import model.Member;
import util.Clock;
import util.Tool;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginSuccessUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSuccessUI frame = new LoginSuccessUI();
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
	public LoginSuccessUI() {
		
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

		JLabel lblNewLabel = new JLabel("登入成功");
		lblNewLabel.setForeground(new Color(64, 0, 64));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 5, 385, 59);
		panel.add(lblNewLabel);

		JLabel showMember = new JLabel("New label");
		Member member = (Member) Tool.read("member.txt");
		showMember.setText(member.getName() + "  歡迎您!");
		showMember.setFont(new Font("新細明體", Font.BOLD, 20));
		showMember.setHorizontalAlignment(SwingConstants.CENTER);
		showMember.setBounds(43, 169, 390, 108);
		contentPane.add(showMember);

		JLabel lblNewLabel_2 = new JLabel("前往購物-->");
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_2.setBounds(111, 360, 163, 37);
		contentPane.add(lblNewLabel_2);

		// ********購物按鈕********
		JButton btnNewButton = new JButton("開始購物");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddPorderUI addporder = new AddPorderUI();
				addporder.setVisible(true);
				dispose();

			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(284, 361, 136, 37);
		contentPane.add(btnNewButton);

		// *******時間******

		JLabel clock = new JLabel("");
		clock.setHorizontalAlignment(SwingConstants.CENTER);
		clock.setBounds(275, 421, 186, 25);
		contentPane.add(clock);
		Timer timer = new Timer(1000, e -> Clock.updateDateTime(clock));
		timer.start();
	}

}
