package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.impl.PorderServiceImpl;
import util.ChangeCalculator;
import util.Clock;
import util.PrintUtility;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JButton;

public class AddPorderCheckout extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField money;
	private static PorderServiceImpl porderserviceimpl = new PorderServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPorderCheckout frame = new AddPorderCheckout();
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
	public AddPorderCheckout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 255));
		panel.setBounds(10, 10, 666, 82);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("結帳");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 30));
		lblNewLabel.setBounds(31, 5, 599, 67);
		panel.add(lblNewLabel);

		JButton btnNewButton_2 = new JButton("返回");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddPorderCart addpordercart = new AddPorderCart();
				addpordercart.setVisible(true);
				dispose();
			}
		});
		
		btnNewButton_2.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton_2.setBounds(10, 5, 75, 32);
		panel.add(btnNewButton_2);

		

		JTextArea output = new JTextArea();
		output.setBounds(10, 120, 666, 347);
		contentPane.add(output);
		
		JButton btnNewButton_3 = new JButton("列印");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PrintUtility.initiatePrintJob(output);

			}
		});
		btnNewButton_3.setForeground(new Color(0, 0, 255));
		btnNewButton_3.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton_3.setBounds(581, 5, 75, 32);
		panel.add(btnNewButton_3);

		money = new JTextField();
		money.setBounds(119, 492, 111, 35);
		contentPane.add(money);
		money.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("付款:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_1.setBounds(28, 488, 81, 40);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("購物清單");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				output.setText(porderserviceimpl.AllPorder());
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton.setBounds(552, 477, 103, 35);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("結帳");
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int total = PorderServiceImpl.grandTotal;
				int Money = Integer.parseInt(money.getText());
				if ((Money - total) > 0) {
					String changeDetails = ChangeCalculator.calculateChange(Money - total);
					output.append(changeDetails);
					System.out.println("總金額: " + total + "元");
				}

			}
		});
		btnNewButton_1.setBounds(242, 492, 85, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_2.setBounds(523, 534, 163, 29);
		contentPane.add(lblNewLabel_2);
		Timer timer = new Timer(1000, e -> Clock.updateDateTime(lblNewLabel_2));
		timer.start();
	}
}
