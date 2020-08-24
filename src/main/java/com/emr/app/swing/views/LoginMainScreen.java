package com.emr.app.swing.views;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginMainScreen extends JFrame {
	private JPasswordField passwordField;

	public LoginMainScreen() {

		setBackground(new Color(255, 255, 255));
		setForeground(new Color(255, 255, 255));
		getContentPane().setLayout(new CardLayout(0, 0));
		setUndecorated(true);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width / 2, screenSize.height / 2);
		setLocation(screenSize.width / 2 - getSize().width / 2, screenSize.height / 2 - getSize().height / 2);
		JDesktopPane desktopPane = new JDesktopPane();
		getContentPane().add(desktopPane, "name_4704155628759");
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(0, 0, 345, 384);
		desktopPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginMainScreen.class.getResource("/icons/breakfast.png")));
		lblNewLabel.setBounds(103, 55, 121, 152);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Orange EMR");
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setFont(new Font("Open Sans", Font.BOLD, 22));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(70, 207, 199, 44);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_5 = new JLabel("Copyright \u00a9 2020");
		lblNewLabel_5.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(122, 355, 96, 17);
		panel.add(lblNewLabel_5);

		JTextField txtUsername = new JTextField();
		txtUsername.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setForeground(Color.DARK_GRAY);
		txtUsername.setToolTipText("Username");
		txtUsername.setColumns(10);
		txtUsername.setBounds(408, 122, 234, 34);
		desktopPane.add(txtUsername);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Open Sans", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.setBounds(477, 261, 115, 42);
		desktopPane.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(LoginMainScreen.class.getResource("/icons/close.png")));
		lblNewLabel_2.setBounds(667, 12, 16, 16);
		desktopPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(LoginMainScreen.class.getResource("/icons/user.png")));
		lblNewLabel_3.setBounds(384, 122, 16, 34);
		desktopPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(LoginMainScreen.class.getResource("/icons/password.png")));
		lblNewLabel_4.setBounds(384, 168, 16, 34);
		desktopPane.add(lblNewLabel_4);

		JLabel lblUnableToLogin = new JLabel("Remember me");
		lblUnableToLogin.setBounds(408, 214, 87, 17);
		desktopPane.add(lblUnableToLogin);

		JLabel lblUnableToLogin_1 = new JLabel("Unable to login?");
		lblUnableToLogin_1.setBounds(555, 214, 87, 17);
		desktopPane.add(lblUnableToLogin_1);

		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setFont(new Font("Open Sans", Font.BOLD, 12));
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setBackground(Color.WHITE);
		chckbxNewCheckBox.setForeground(Color.WHITE);
		chckbxNewCheckBox.setBounds(484, 210, 25, 25);
		desktopPane.add(chckbxNewCheckBox);

		JLabel lblAnyQueriesSidislgmailcom = new JLabel("Support email: sidisl16@gmail.com");
		lblAnyQueriesSidislgmailcom.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblAnyQueriesSidislgmailcom.setBounds(443, 355, 199, 17);
		desktopPane.add(lblAnyQueriesSidislgmailcom);

		passwordField = new JPasswordField();
		passwordField.setBounds(408, 168, 234, 34);
		desktopPane.add(passwordField);
		setVisible(true);
	}

}
