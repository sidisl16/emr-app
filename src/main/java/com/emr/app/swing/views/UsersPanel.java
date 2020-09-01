package com.emr.app.swing.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.emr.app.dtos.UserDto;
import com.emr.app.swing.service.UIService;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;

public class UsersPanel extends RoutingPanel {

	private static final long serialVersionUID = 1L;
	private JPanel usersHeadingPanel;
	private JPanel usersHeadingTextContainer;
	private JLabel usersTextLbl;
	private JPanel usersBody;
	private JPanel footer;
	private JLabel copyrightInfo;
	private UIService uiService;
	private JProgressBar progressBar;
	private List<UserDto> users;
	private JPanel userBodyPanel;
	private JTableHeader tableHeader;
	private JPanel userSerachHeader;
	private JTextField textField;
	private JTextField textField_1;
	private JPanel searchButton;
	private JPanel resetBtn;
	private JLabel searchBtn;
	private JTable usersTable;
	private JLabel name;
	private JLabel searchLabel;
	private JLabel lblEmail;
	private JLabel resetLbl;
	private JPanel tableBody;
	private JScrollPane scrollPane;
	private JPanel addUserPanel;
	private JLabel nameLbl;
	private JTextField nameTextField;
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
	private JLabel lblAdd;
	private JPanel addUserBodyPanel;

	/**
	 * Create the panel.
	 */
	public UsersPanel(UIService uiService, JProgressBar progressBar) {
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

		usersTextLbl = new JLabel("Users");
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
		userBodyPanel.setLayout(new BorderLayout(0, 0));

		userSerachHeader = new JPanel();
		userSerachHeader.setBorder(new LineBorder(Color.DARK_GRAY));
		userSerachHeader.setOpaque(false);
		userSerachHeader.setPreferredSize(new Dimension(10, 60));
		userBodyPanel.add(userSerachHeader, BorderLayout.NORTH);
		userSerachHeader.setLayout(null);

		textField = new JTextField();
		textField.setPreferredSize(new Dimension(5, 64));
		textField.setColumns(10);
		textField.setBorder(new LineBorder(Color.DARK_GRAY));
		textField.setBounds(121, 13, 200, 36);
		userSerachHeader.add(textField);

		name = new JLabel("Name");
		name.setFont(new Font("Open Sans", Font.BOLD, 12));
		name.setBounds(78, 22, 36, 17);
		userSerachHeader.add(name);

		searchLabel = new JLabel("Search");
		searchLabel.setFont(new Font("Open Sans", Font.BOLD, 14));
		searchLabel.setBounds(12, 12, 54, 36);
		userSerachHeader.add(searchLabel);

		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Open Sans", Font.BOLD, 12));
		lblEmail.setBounds(369, 22, 43, 17);
		userSerachHeader.add(lblEmail);

		textField_1 = new JTextField();
		textField_1.setPreferredSize(new Dimension(5, 64));
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(Color.DARK_GRAY));
		textField_1.setBounds(413, 13, 200, 36);
		userSerachHeader.add(textField_1);

		searchButton = new JPanel();
		searchButton.setBackground(new Color(77, 148, 255));
		searchButton.setBounds(641, 13, 100, 35);
		userSerachHeader.add(searchButton);
		searchButton.setLayout(new BorderLayout(0, 0));

		searchBtn = new JLabel("Search");
		searchBtn.setHorizontalAlignment(SwingConstants.CENTER);
		searchBtn.setForeground(Color.WHITE);
		searchBtn.setFont(new Font("Open Sans", Font.BOLD, 12));
		searchButton.add(searchBtn, BorderLayout.CENTER);

		resetBtn = new JPanel();
		resetBtn.setBackground(new Color(77, 148, 255));
		resetBtn.setBounds(753, 13, 100, 35);
		userSerachHeader.add(resetBtn);
		resetBtn.setLayout(new BorderLayout(0, 0));

		resetLbl = new JLabel("Refresh");
		resetLbl.setHorizontalAlignment(SwingConstants.CENTER);
		resetLbl.setForeground(Color.WHITE);
		resetLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		resetBtn.add(resetLbl, BorderLayout.CENTER);

		tableBody = new JPanel();
		tableBody.setBorder(new EmptyBorder(10, 10, 0, 0));
		tableBody.setOpaque(false);
		tableBody.setPreferredSize(new Dimension(750, 10));
		userBodyPanel.add(tableBody, BorderLayout.WEST);
		tableBody.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		tableBody.add(scrollPane, BorderLayout.CENTER);

		usersTable = new JTable();
		usersTable.setToolTipText("Double click to edit");
		usersTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Sl. No.", "Name", "Email", "Role", "Qualification" }));
		tableHeader = usersTable.getTableHeader();
		tableHeader.setPreferredSize(new Dimension(100, 32));
		usersTable.setRowHeight(32);
		scrollPane.setViewportView(usersTable);

		addUserBodyPanel = new JPanel();
		addUserBodyPanel.setOpaque(false);
		userBodyPanel.add(addUserBodyPanel, BorderLayout.CENTER);
		addUserBodyPanel.setLayout(null);

		addUserPanel = new JPanel();
		addUserPanel.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Add/Update User",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		addUserPanel.setOpaque(false);
		addUserPanel.setBounds(49, 23, 344, 371);
		addUserBodyPanel.add(addUserPanel);
		addUserPanel.setLayout(null);

		nameLbl = new JLabel("Name*");
		nameLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		nameLbl.setBounds(12, 35, 43, 17);
		addUserPanel.add(nameLbl);

		nameTextField = new JTextField();
		nameTextField.setPreferredSize(new Dimension(5, 64));
		nameTextField.setColumns(10);
		nameTextField.setBorder(new LineBorder(Color.DARK_GRAY));
		nameTextField.setBounds(100, 26, 210, 36);
		addUserPanel.add(nameTextField);

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
		qualFieldInfo.setBounds(12, 341, 298, 17);
		addUserPanel.add(qualFieldInfo);

		roleComboBox = new JComboBox();
		roleComboBox.setBounds(100, 218, 210, 36);
		addUserPanel.add(roleComboBox);

		addUserBtn = new JPanel();
		addUserBtn.setBackground(new Color(77, 148, 255));
		addUserBtn.setBounds(210, 280, 100, 35);
		addUserPanel.add(addUserBtn);
		addUserBtn.setLayout(new BorderLayout(0, 0));

		lblAdd = new JLabel("Add");
		lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd.setForeground(Color.WHITE);
		lblAdd.setFont(new Font("Open Sans", Font.BOLD, 12));
		addUserBtn.add(lblAdd, BorderLayout.CENTER);
		tableHeader.setPreferredSize(new Dimension(100, 32));
	}

	private void changeColor(Color color, Component component) {
		component.setBackground(color);
	}

	private void initEvents() {
		searchButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(Color.decode("#99c2ff"), searchButton);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(Color.decode("#4d94ff"), searchButton);
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
	}

	@Override
	public void execute() {
	}

	@Override
	public void execute(Object... dtos) {
	}
}
