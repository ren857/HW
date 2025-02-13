package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.member.LoginUI;
import model.Member;
import model.Porder;
import service.impl.PorderServiceImpl;
import util.Clock;
import util.Tool;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class AddPorderUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField wrench;
	private JTextField pail;
	private JTextField hose;

	private static PorderServiceImpl porderserviceimpl = new PorderServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPorderUI frame = new AddPorderUI();
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
	public AddPorderUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 217, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 666, 90);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("鋸匞五金");
		lblNewLabel.setForeground(new Color(64, 0, 64));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 30));
		lblNewLabel.setBounds(33, 5, 602, 75);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 130, 638, 329);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel wrench1 = new JLabel("板手:");
		wrench1.setHorizontalAlignment(SwingConstants.CENTER);
		wrench1.setFont(new Font("新細明體", Font.BOLD, 20));
		wrench1.setBounds(206, 92, 76, 44);
		panel_1.add(wrench1);

		JLabel pail1 = new JLabel("水桶:");
		pail1.setHorizontalAlignment(SwingConstants.CENTER);
		pail1.setFont(new Font("新細明體", Font.BOLD, 20));
		pail1.setBounds(206, 161, 76, 44);
		panel_1.add(pail1);

		JLabel hose1 = new JLabel("水管:");
		hose1.setHorizontalAlignment(SwingConstants.CENTER);
		hose1.setFont(new Font("新細明體", Font.BOLD, 20));
		hose1.setBounds(206, 230, 76, 44);
		panel_1.add(hose1);

		wrench = new JTextField();
		wrench.setBounds(355, 99, 96, 34);
		panel_1.add(wrench);
		wrench.setColumns(10);

		pail = new JTextField();
		pail.setColumns(10);
		pail.setBounds(355, 168, 96, 34);
		panel_1.add(pail);

		hose = new JTextField();
		hose.setColumns(10);
		hose.setBounds(355, 237, 96, 34);
		panel_1.add(hose);

		JLabel showMember = new JLabel("New label");
		Member member = (Member) Tool.read("member.txt");
		showMember.setFont(new Font("新細明體", Font.BOLD, 25));
		showMember.setText("客戶:    " + member.getName());
		showMember.setBounds(221, 37, 247, 45);
		panel_1.add(showMember);

		JButton btnNewButton = new JButton("新增訂單");
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name = member.getName();
				int Wrench = Integer.parseInt(wrench.getText());
				int Pail = Integer.parseInt(pail.getText());
				int Hose = Integer.parseInt(hose.getText());

				Porder p = new Porder(Name, Wrench, Pail, Hose);
				porderserviceimpl.addPorder(p);
			}
		});
		btnNewButton.setBounds(453, 488, 105, 40);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("購物車");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddPorderCart addpordercart = new AddPorderCart();
				addpordercart.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(157, 255, 255));
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 12));
		btnNewButton_1.setBounds(574, 99, 88, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("回到登入");
		btnNewButton_2.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton_2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI login = new LoginUI();
				login.setVisible(true);
				dispose();
			}
		});

		btnNewButton_2.setBounds(117, 488, 105, 40);
		contentPane.add(btnNewButton_2);

		JLabel clock = new JLabel("New label");
		clock.setFont(new Font("新細明體", Font.BOLD, 15));
		clock.setBounds(524, 538, 152, 25);
		contentPane.add(clock);
		Timer timer = new Timer(1000, e -> Clock.updateDateTime(clock));
		timer.start();

	}
}
