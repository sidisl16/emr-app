package com.emr.app.swing.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.emr.app.dtos.UserDto;
import com.emr.app.swing.service.UIService;

public class SettingsPanel extends RoutingPanel {


	private static final long serialVersionUID = 1L;
	private JPanel settingsHeadingPanel;
	private JPanel settingsHeadingTextContainer;
	private JLabel settingsTextLbl;
	private JPanel settingsBody;
	private JPanel footer;
	private JLabel copyrightInfo;
	private UIService uiService;
	private JProgressBar progressBar;
	private JPanel settingsBodyPanel;
	private JPanel appSettingsPanel;
	private JLabel nameLbl;
	private JTextField textField;
	private JLabel emailLbl;
	private JTextField emailTextField;
	private JLabel qualificationLbl;
	private JTextField qualificationTextField;
	private JLabel contactLbl;
	private JTextField contactTextField;
	private JLabel qualFieldInfo;
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
	public SettingsPanel(UIService uiService, JProgressBar progressBar) {
		initComponents();
		initEvents();
		this.uiService = uiService;
		this.progressBar = progressBar;
	}

	private void initComponents() {
		setBackground(Color.decode("#ffffff"));
		setLayout(new BorderLayout(0, 0));
		setSize(1300, 600);

		settingsHeadingPanel = new JPanel();
		settingsHeadingPanel.setBorder(new LineBorder(Color.decode("#bfbfbf")));
		settingsHeadingPanel.setBackground(Color.decode("#4d94ff"));
		settingsHeadingPanel.setPreferredSize(new Dimension(70, 50));
		settingsHeadingPanel.setLayout(new BorderLayout(0, 0));

		settingsHeadingTextContainer = new JPanel();
		settingsHeadingTextContainer.setBackground(Color.decode("#4d94ff"));
		settingsHeadingTextContainer.setPreferredSize(new Dimension(200, 10));
		settingsHeadingPanel.add(settingsHeadingTextContainer, BorderLayout.WEST);
		settingsHeadingTextContainer.setLayout(new BorderLayout(0, 0));

		settingsTextLbl = new JLabel("Settings");
		settingsTextLbl.setForeground(Color.decode("#ffffff"));
		settingsTextLbl.setHorizontalTextPosition(SwingConstants.CENTER);
		settingsTextLbl.setHorizontalAlignment(SwingConstants.CENTER);
		settingsTextLbl.setFont(new Font("Open Sans", Font.BOLD, 16));
		settingsHeadingTextContainer.add(settingsTextLbl, BorderLayout.CENTER);

		add(settingsHeadingPanel, BorderLayout.NORTH);

		settingsBody = new JPanel();
		settingsBody.setBackground(Color.decode("#ffffff"));
		settingsBody.setLayout(new BorderLayout(0, 0));
		add(settingsBody, BorderLayout.CENTER);

		footer = new JPanel();
		footer.setBackground(Color.decode("#ffffff"));
		footer.setPreferredSize(new Dimension(10, 20));
		settingsBody.add(footer, BorderLayout.SOUTH);
		footer.setLayout(new BorderLayout(0, 0));

		copyrightInfo = new JLabel("Copyright \u00a9" + " 2020 Orange Inc.");
		copyrightInfo.setFont(new Font("Open Sans", Font.BOLD, 12));
		copyrightInfo.setHorizontalAlignment(SwingConstants.CENTER);
		footer.add(copyrightInfo, BorderLayout.CENTER);

		settingsBodyPanel = new JPanel();
		settingsBodyPanel.setOpaque(false);
		settingsBody.add(settingsBodyPanel, BorderLayout.CENTER);
		settingsBodyPanel.setLayout(null);

		appSettingsPanel = new JPanel();
		appSettingsPanel.setLayout(null);
		appSettingsPanel.setOpaque(false);
		appSettingsPanel.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "App Settings", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		appSettingsPanel.setBounds(22, 23, 344, 425);
		settingsBodyPanel.add(appSettingsPanel);

		nameLbl = new JLabel("Name*");
		nameLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		nameLbl.setBounds(12, 35, 43, 17);
		appSettingsPanel.add(nameLbl);

		textField = new JTextField();
		textField.setPreferredSize(new Dimension(5, 64));
		textField.setColumns(10);
		textField.setBorder(new LineBorder(Color.DARK_GRAY));
		textField.setBounds(100, 26, 210, 36);
		appSettingsPanel.add(textField);

		emailLbl = new JLabel("Email*");
		emailLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		emailLbl.setBounds(12, 88, 43, 17);
		appSettingsPanel.add(emailLbl);

		emailTextField = new JTextField();
		emailTextField.setPreferredSize(new Dimension(5, 64));
		emailTextField.setColumns(10);
		emailTextField.setBorder(new LineBorder(Color.DARK_GRAY));
		emailTextField.setBounds(100, 74, 210, 36);
		appSettingsPanel.add(emailTextField);

		qualificationLbl = new JLabel("Qualification*");
		qualificationLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		qualificationLbl.setBounds(12, 131, 86, 17);
		appSettingsPanel.add(qualificationLbl);

		qualificationTextField = new JTextField();
		qualificationTextField.setPreferredSize(new Dimension(5, 64));
		qualificationTextField.setColumns(10);
		qualificationTextField.setBorder(new LineBorder(Color.DARK_GRAY));
		qualificationTextField.setBounds(100, 122, 210, 36);
		appSettingsPanel.add(qualificationTextField);

		contactLbl = new JLabel("Contact");
		contactLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		contactLbl.setBounds(12, 179, 70, 17);
		appSettingsPanel.add(contactLbl);

		contactTextField = new JTextField();
		contactTextField.setPreferredSize(new Dimension(5, 64));
		contactTextField.setColumns(10);
		contactTextField.setBorder(new LineBorder(Color.DARK_GRAY));
		contactTextField.setBounds(100, 170, 210, 36);
		appSettingsPanel.add(contactTextField);

		qualFieldInfo = new JLabel("(*) Marked will be displayed in Prescription, ensure to fill proper value");
		qualFieldInfo.setFont(new Font("Open Sans", Font.BOLD, 8));
		qualFieldInfo.setBounds(12, 402, 298, 17);
		appSettingsPanel.add(qualFieldInfo);

		addUserBtn = new JPanel();
		addUserBtn.setBackground(new Color(77, 148, 255));
		addUserBtn.setBounds(210, 336, 100, 35);
		appSettingsPanel.add(addUserBtn);
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
		settingsBodyPanel.add(resetPasswordPanel);

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
