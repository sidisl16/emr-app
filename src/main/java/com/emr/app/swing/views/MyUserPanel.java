package com.emr.app.swing.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.emr.app.swing.service.UIService;

public class MyUserPanel extends RoutingPanel {

	private static final long serialVersionUID = 1L;
	private JPanel usersHeadingPanel;
	private JPanel usersHeadingTextContainer;
	private JLabel usersTextLbl;
	private JPanel usersBody;
	private JPanel footer;
	private JLabel copyrightInfo;
	private UIService uiService;
	private JProgressBar progressBar;
	private JPanel userBodyPanel;
	private JPanel addUserPanel;
	private JLabel nameLbl;
	private JTextField textField;
	private JLabel emailLbl;
	private JTextField emailTextField;
	private JLabel qualificationLbl;
	private JTextField qualificationTextField;
	private JLabel contactLbl;
	private JTextField contactTextField;
	private JLabel roleLbl;
	private JLabel qualFieldInfo;
	private JComboBox roleComboBox;
	private JPanel addUserBtn;
	private JLabel lblUpdate;
	private JPanel resetPasswordPanel;
	private JLabel existingLbl;
	private JLabel newLbl;
	private JLabel confirmLbl;
	private JPanel resetBtn;
	private JLabel lblReset;
	private JPasswordField existingPasswordField;
	private JPasswordField newPasswordField;
	private JPasswordField confirmPasswordField;

	/**
	 * Create the panel.
	 */
	public MyUserPanel(UIService uiService, JProgressBar progressBar) {
		initComponents();
		initEvents();
		this.uiService = uiService;
		this.progressBar = progressBar;
	}

	private void initComponents() {
		setBackground(Color.decode("#ffffff"));
		setLayout(new BorderLayout(0, 0));
		setSize(1300, 600);

		usersHeadingPanel = new JPanel();
		usersHeadingPanel.setBorder(new LineBorder(Color.decode("#bfbfbf")));
		usersHeadingPanel.setBackground(Color.decode("#4d94ff"));
		usersHeadingPanel.setPreferredSize(new Dimension(70, 50));
		usersHeadingPanel.setLayout(new BorderLayout(0, 0));

		usersHeadingTextContainer = new JPanel();
		usersHeadingTextContainer.setBackground(Color.decode("#4d94ff"));
		usersHeadingTextContainer.setPreferredSize(new Dimension(200, 10));
		usersHeadingPanel.add(usersHeadingTextContainer, BorderLayout.WEST);
		usersHeadingTextContainer.setLayout(new BorderLayout(0, 0));

		usersTextLbl = new JLabel("Account Settings");
		usersTextLbl.setForeground(Color.decode("#ffffff"));
		usersTextLbl.setHorizontalTextPosition(SwingConstants.CENTER);
		usersTextLbl.setHorizontalAlignment(SwingConstants.CENTER);
		usersTextLbl.setFont(new Font("Open Sans", Font.BOLD, 16));
		usersHeadingTextContainer.add(usersTextLbl, BorderLayout.CENTER);

		add(usersHeadingPanel, BorderLayout.NORTH);

		usersBody = new JPanel();
		usersBody.setBackground(Color.decode("#ffffff"));
		usersBody.setLayout(new BorderLayout(0, 0));
		add(usersBody, BorderLayout.CENTER);

		footer = new JPanel();
		footer.setBackground(Color.decode("#ffffff"));
		footer.setPreferredSize(new Dimension(10, 20));
		usersBody.add(footer, BorderLayout.SOUTH);
		footer.setLayout(new BorderLayout(0, 0));

		copyrightInfo = new JLabel("Copyright \u00a9" + " 2020 Orange Inc.");
		copyrightInfo.setFont(new Font("Open Sans", Font.BOLD, 12));
		copyrightInfo.setHorizontalAlignment(SwingConstants.CENTER);
		footer.add(copyrightInfo, BorderLayout.CENTER);

		userBodyPanel = new JPanel();
		userBodyPanel.setOpaque(false);
		usersBody.add(userBodyPanel, BorderLayout.CENTER);
		userBodyPanel.setLayout(null);

		addUserPanel = new JPanel();
		addUserPanel.setLayout(null);
		addUserPanel.setOpaque(false);
		addUserPanel.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Update User Details",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		addUserPanel.setBounds(22, 23, 344, 379);
		userBodyPanel.add(addUserPanel);

		nameLbl = new JLabel("Name*");
		nameLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		nameLbl.setBounds(12, 35, 43, 17);
		addUserPanel.add(nameLbl);

		textField = new JTextField();
		textField.setPreferredSize(new Dimension(5, 64));
		textField.setColumns(10);
		textField.setBorder(new LineBorder(Color.DARK_GRAY));
		textField.setBounds(100, 26, 210, 36);
		addUserPanel.add(textField);

		emailLbl = new JLabel("Email*");
		emailLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		emailLbl.setBounds(12, 88, 43, 17);
		addUserPanel.add(emailLbl);

		emailTextField = new JTextField();
		emailTextField.setPreferredSize(new Dimension(5, 64));
		emailTextField.setColumns(10);
		emailTextField.setBorder(new LineBorder(Color.DARK_GRAY));
		emailTextField.setBounds(100, 74, 210, 36);
		addUserPanel.add(emailTextField);

		qualificationLbl = new JLabel("Qualification*");
		qualificationLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		qualificationLbl.setBounds(12, 131, 86, 17);
		addUserPanel.add(qualificationLbl);

		qualificationTextField = new JTextField();
		qualificationTextField.setPreferredSize(new Dimension(5, 64));
		qualificationTextField.setColumns(10);
		qualificationTextField.setBorder(new LineBorder(Color.DARK_GRAY));
		qualificationTextField.setBounds(100, 122, 210, 36);
		addUserPanel.add(qualificationTextField);

		contactLbl = new JLabel("Contact");
		contactLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		contactLbl.setBounds(12, 179, 70, 17);
		addUserPanel.add(contactLbl);

		contactTextField = new JTextField();
		contactTextField.setPreferredSize(new Dimension(5, 64));
		contactTextField.setColumns(10);
		contactTextField.setBorder(new LineBorder(Color.DARK_GRAY));
		contactTextField.setBounds(100, 170, 210, 36);
		addUserPanel.add(contactTextField);

		roleLbl = new JLabel("Role");
		roleLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		roleLbl.setBounds(12, 228, 43, 17);
		addUserPanel.add(roleLbl);

		qualFieldInfo = new JLabel("(*) Marked will be displayed in Prescription, ensure to fill proper value");
		qualFieldInfo.setFont(new Font("Open Sans", Font.BOLD, 8));
		qualFieldInfo.setBounds(12, 346, 298, 17);
		addUserPanel.add(qualFieldInfo);

		roleComboBox = new JComboBox();
		roleComboBox.setBounds(100, 218, 210, 36);
		addUserPanel.add(roleComboBox);

		addUserBtn = new JPanel();
		addUserBtn.setBackground(new Color(77, 148, 255));
		addUserBtn.setBounds(210, 280, 100, 35);
		addUserPanel.add(addUserBtn);
		addUserBtn.setLayout(new BorderLayout(0, 0));

		lblUpdate = new JLabel("Update");
		lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate.setForeground(Color.WHITE);
		lblUpdate.setFont(new Font("Open Sans", Font.BOLD, 12));
		addUserBtn.add(lblUpdate, BorderLayout.CENTER);

		resetPasswordPanel = new JPanel();
		resetPasswordPanel.setLayout(null);
		resetPasswordPanel.setOpaque(false);
		resetPasswordPanel.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Reset Password",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		resetPasswordPanel.setBounds(439, 23, 344, 231);
		userBodyPanel.add(resetPasswordPanel);

		existingLbl = new JLabel("Existing");
		existingLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		existingLbl.setBounds(12, 51, 79, 17);
		resetPasswordPanel.add(existingLbl);

		newLbl = new JLabel("New");
		newLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		newLbl.setBounds(12, 95, 79, 17);
		resetPasswordPanel.add(newLbl);

		confirmLbl = new JLabel("Confirm");
		confirmLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		confirmLbl.setBounds(12, 138, 86, 17);
		resetPasswordPanel.add(confirmLbl);

		resetBtn = new JPanel();
		resetBtn.setBackground(new Color(77, 148, 255));
		resetBtn.setBounds(210, 176, 100, 35);
		resetPasswordPanel.add(resetBtn);
		resetBtn.setLayout(new BorderLayout(0, 0));

		lblReset = new JLabel("Reset");
		lblReset.setHorizontalAlignment(SwingConstants.CENTER);
		lblReset.setForeground(Color.WHITE);
		lblReset.setFont(new Font("Open Sans", Font.BOLD, 12));
		resetBtn.add(lblReset, BorderLayout.CENTER);

		existingPasswordField = new JPasswordField();
		existingPasswordField.setBorder(new LineBorder(Color.DARK_GRAY));
		existingPasswordField.setBounds(109, 42, 200, 35);
		resetPasswordPanel.add(existingPasswordField);

		newPasswordField = new JPasswordField();
		newPasswordField.setBorder(new LineBorder(Color.DARK_GRAY));
		newPasswordField.setBounds(109, 86, 200, 35);
		resetPasswordPanel.add(newPasswordField);

		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setBorder(new LineBorder(Color.DARK_GRAY));
		confirmPasswordField.setBounds(110, 129, 200, 35);
		resetPasswordPanel.add(confirmPasswordField);
	}

	private void initEvents() {
		addUserBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(Color.decode("#99c2ff"), addUserBtn);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(Color.decode("#4d94ff"), addUserBtn);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		resetBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(Color.decode("#99c2ff"), resetBtn);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(Color.decode("#4d94ff"), resetBtn);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}

	private void changeColor(Color color, Component component) {
		component.setBackground(color);
	}

	@Override
	public void execute() {
	}

	@Override
	public void execute(Object... dtos) {
	}
}
