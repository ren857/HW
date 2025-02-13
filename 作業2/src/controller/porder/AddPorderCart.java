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
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;

import java.util.List;

public class AddPorderCart extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idd;
	private JTextField id;
	private JTextField wrench;
	private JTextField pail;
	private JTextField hose;
	private static Member member = (Member) Tool.read("member.txt");
	List<String> memberNames = Tool.readNames("member.txt");
	private static PorderServiceImpl porderserviceimpl = new PorderServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPorderCart frame = new AddPorderCart();
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
	public AddPorderCart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(157, 255, 255));
		panel.setBounds(0, 0, 697, 87);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText(" " + member.getName() + "  的購物車");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 25));
		lblNewLabel.setBounds(52, 5, 543, 62);
		panel.add(lblNewLabel);

		JButton btnNewButton_4 = new JButton("返回登入");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI login = new LoginUI();
				File myObj = new File("member.txt");
				System.out.println(myObj.exists());
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setFont(new Font("新細明體", Font.BOLD, 20));
		btnNewButton_4.setBounds(10, 27, 121, 29);
		panel.add(btnNewButton_4);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 89, 432, 343);
		contentPane.add(scrollPane);

		JTextArea output = new JTextArea();
		scrollPane.setViewportView(output);

		JButton btnNewButton = new JButton("購物清單");
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 12));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				output.setText(porderserviceimpl.AllPorder());
			}
		});
		btnNewButton.setBounds(292, 442, 101, 33);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Id->");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 467, 94, 33);
		contentPane.add(lblNewLabel_1);

		idd = new JTextField();
		idd.setBounds(96, 471, 107, 27);
		contentPane.add(idd);
		idd.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(440, 87, 257, 367);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("修改購物清單");
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_2.setBounds(85, 24, 114, 37);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Id:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_3.setBounds(30, 83, 90, 37);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("板手:");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(30, 143, 90, 37);
		panel_1.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("水桶:");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_3_2.setBounds(30, 202, 90, 37);
		panel_1.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_3 = new JLabel("水管:");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_3_3.setBounds(30, 258, 90, 37);
		panel_1.add(lblNewLabel_3_3);

		id = new JTextField();
		id.setBounds(125, 91, 96, 21);
		panel_1.add(id);
		id.setColumns(10);

		wrench = new JTextField();
		wrench.setColumns(10);
		wrench.setBounds(125, 151, 96, 21);
		panel_1.add(wrench);

		pail = new JTextField();
		pail.setColumns(10);
		pail.setBounds(125, 210, 96, 21);
		panel_1.add(pail);

		hose = new JTextField();
		hose.setColumns(10);
		hose.setBounds(125, 266, 96, 21);
		panel_1.add(hose);

		JButton btnNewButton_2 = new JButton("確認");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int Id = Integer.parseInt(id.getText());
				int Wrench = Integer.parseInt(wrench.getText());
				int Pail = Integer.parseInt(pail.getText());
				int Hose = Integer.parseInt(hose.getText());
				porderserviceimpl.updatePorder(Wrench, Pail, Hose, Id);
			}
		});
		btnNewButton_2.setBounds(150, 334, 85, 23);
		panel_1.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("新增");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
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
		btnNewButton_3.setBounds(35, 334, 85, 23);
		panel_1.add(btnNewButton_3);

		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_4.setBounds(502, 536, 161, 27);
		contentPane.add(lblNewLabel_4);
		Timer timer = new Timer(1000, e -> Clock.updateDateTime(lblNewLabel_4));
		timer.start();

		JButton btnNewButton_1 = new JButton("刪除");
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 12));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int Id = Integer.parseInt(idd.getText());
				porderserviceimpl.deletePorderById(Id);
			}
		});
		btnNewButton_1.setBounds(52, 510, 94, 33);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_6 = new JButton("結帳");
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddPorderCheckout addpordercheckout = new AddPorderCheckout();
				addpordercheckout.setVisible(true);
				dispose();
			}
		});
		btnNewButton_6.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton_6.setBounds(578, 481, 85, 33);
		contentPane.add(btnNewButton_6);

	}

}
