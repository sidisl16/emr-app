package com.emr.app.swing.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.stream.IntStream;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.JTableHeader;

import com.emr.app.swing.service.UIService;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;

public class AddAppointmentPanel extends RoutingPanel {

	private static final long serialVersionUID = 1L;
	private JPanel appointmentHeadingPanel;
	private JPanel appointmentHeadingTextContainer;
	private JLabel appointmentTextLbl;
	private JPanel addAppointmentBody;
	private JPanel saveCancelAppointmentContainer;
	private JPanel savePanel;
	private JLabel saveIcon;
	private JPanel cancelPanel;
	private JLabel cancelIcon;
	private JPanel footer;
	private JLabel copyrightInfo;
	private JPanel addappointmentFormbody;
	private JPanel appointmentScheduleContainer;
	private JPanel patientDetailsContainer;
	private JTextField nameTextField;
	private JLabel emailLbl;
	private JLabel assignLbl;
	private JLabel schedule;
	private JTextField emailTextField;
	private JTextField contactTextField;
	private JTextField ageTextField;
	private DatePickerSettings settings;
	private DateTimePicker dateTimePicker;
	private JComboBox<String> assignDropdown;
	private JLabel nameLbl;
	private JLabel ageLbl;
	private JLabel genderLbl;
	private JLabel contactLbl;
	private JLabel addressLbl;
	private JTextArea addressTextArea;
	private JComboBox<String> genderDropdown;
	private JPanel attendNowBtn;
	private JLabel orTextLbl;
	private JLabel attendBtnLbl;
	private JTextField patientNoTextField;
	private JTextField patientNameTextField;
	private JTextField contactNoTextField;
	private JPanel searchPatientPanel;
	private JLabel lblPatientNo;
	private JLabel lblPatientName;
	private JLabel lblContactNo;
	private JPanel searchButton;
	private JLabel searchPatientBtnLbl;
	private UIService uiService;
	private JProgressBar progressBar;
	private JTable searchPatientTable;
	private JTableHeader tableHeader;
	private JScrollPane searchPatientScrollPane;
	private UneditableTableDataModel uneditableTableDataModel;

	/**
	 * Create the panel.
	 */
	public AddAppointmentPanel(UIService uiService, JProgressBar progressBar) {
		initComponents();
		initEvents();
		this.uiService = uiService;
		this.progressBar = progressBar;
	}

	private void initComponents() {
		setBackground(Color.decode("#ffffff"));
		setLayout(new BorderLayout(0, 0));
		setSize(1300, 600);

		appointmentHeadingPanel = new JPanel();
		appointmentHeadingPanel.setBorder(new LineBorder(Color.decode("#bfbfbf")));
		appointmentHeadingPanel.setBackground(Color.decode("#4d94ff"));
		appointmentHeadingPanel.setPreferredSize(new Dimension(70, 50));
		appointmentHeadingPanel.setLayout(new BorderLayout(0, 0));

		appointmentHeadingTextContainer = new JPanel();
		appointmentHeadingTextContainer.setBackground(Color.decode("#4d94ff"));
		appointmentHeadingTextContainer.setPreferredSize(new Dimension(200, 10));
		appointmentHeadingPanel.add(appointmentHeadingTextContainer, BorderLayout.WEST);
		appointmentHeadingTextContainer.setLayout(new BorderLayout(0, 0));

		appointmentTextLbl = new JLabel("Schedule Appointment");
		appointmentTextLbl.setForeground(Color.decode("#ffffff"));
		appointmentTextLbl.setHorizontalTextPosition(SwingConstants.CENTER);
		appointmentTextLbl.setHorizontalAlignment(SwingConstants.CENTER);
		appointmentTextLbl.setFont(new Font("Open Sans", Font.BOLD, 16));
		appointmentHeadingTextContainer.add(appointmentTextLbl, BorderLayout.CENTER);

		saveCancelAppointmentContainer = new JPanel();
		saveCancelAppointmentContainer.setBackground(Color.decode("#4d94ff"));
		saveCancelAppointmentContainer.setPreferredSize(new Dimension(110, 10));
		appointmentHeadingPanel.add(saveCancelAppointmentContainer, BorderLayout.EAST);
		saveCancelAppointmentContainer.setLayout(null);

		savePanel = new JPanel();
		savePanel.setToolTipText("Save");
		savePanel.setBackground(Color.decode("#4d94ff"));
		savePanel.setBounds(0, 0, 53, 48);
		saveCancelAppointmentContainer.add(savePanel);
		savePanel.setLayout(new BorderLayout(0, 0));

		saveIcon = new JLabel("");
		saveIcon.setIcon(new ImageIcon(HomeScreen.class.getResource("/icons/save-32.png")));
		saveIcon.setHorizontalTextPosition(SwingConstants.CENTER);
		saveIcon.setHorizontalAlignment(SwingConstants.CENTER);
		savePanel.add(saveIcon, BorderLayout.CENTER);

		cancelPanel = new JPanel();
		cancelPanel.setToolTipText("Go Back");
		cancelPanel.setBackground(Color.decode("#4d94ff"));
		cancelPanel.setBounds(57, 0, 53, 48);
		saveCancelAppointmentContainer.add(cancelPanel);
		cancelPanel.setLayout(new BorderLayout(0, 0));

		cancelIcon = new JLabel("");
		cancelIcon.setIcon(new ImageIcon(HomeScreen.class.getResource("/icons/back-32.png")));
		cancelIcon.setHorizontalTextPosition(SwingConstants.CENTER);
		cancelIcon.setHorizontalAlignment(SwingConstants.CENTER);
		cancelPanel.add(cancelIcon, BorderLayout.CENTER);

		add(appointmentHeadingPanel, BorderLayout.NORTH);

		addAppointmentBody = new JPanel();
		addAppointmentBody.setBackground(Color.decode("#ffffff"));
		addAppointmentBody.setLayout(new BorderLayout(0, 0));
		add(addAppointmentBody, BorderLayout.CENTER);

		footer = new JPanel();
		footer.setBackground(Color.decode("#ffffff"));
		footer.setPreferredSize(new Dimension(10, 20));
		addAppointmentBody.add(footer, BorderLayout.SOUTH);
		footer.setLayout(new BorderLayout(0, 0));

		copyrightInfo = new JLabel("Copyright \u00a9" + " 2020 Orange Inc.");
		copyrightInfo.setFont(new Font("Open Sans", Font.BOLD, 12));
		copyrightInfo.setHorizontalAlignment(SwingConstants.CENTER);
		footer.add(copyrightInfo, BorderLayout.CENTER);

		addappointmentFormbody = new JPanel();
		addappointmentFormbody.setBorder(new EmptyBorder(30, 30, 30, 30));
		addappointmentFormbody.setBackground(Color.decode("#ffffff"));
		addAppointmentBody.add(addappointmentFormbody, BorderLayout.CENTER);
		addappointmentFormbody.setLayout(new BorderLayout(0, 0));

		appointmentScheduleContainer = new JPanel();
		appointmentScheduleContainer.setBorder(new TitledBorder(new LineBorder(Color.decode("#262626")), "Assign",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		appointmentScheduleContainer.setBackground(Color.decode("#ffffff"));
		appointmentScheduleContainer.setPreferredSize(new Dimension(10, 100));
		addappointmentFormbody.add(appointmentScheduleContainer, BorderLayout.SOUTH);
		appointmentScheduleContainer.setLayout(null);

		assignLbl = new JLabel("Assign");
		assignLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		assignLbl.setBounds(12, 45, 64, 17);
		appointmentScheduleContainer.add(assignLbl);

		schedule = new JLabel("Schedule");
		schedule.setFont(new Font("Open Sans", Font.BOLD, 12));
		schedule.setBounds(373, 45, 71, 17);
		appointmentScheduleContainer.add(schedule);

		settings = new DatePickerSettings();
		dateTimePicker = new DateTimePicker(settings, null);
		settings.setDateRangeLimits(LocalDate.now(), LocalDate.now().plus(300, ChronoUnit.MONTHS));
		dateTimePicker.setDateTimePermissive(LocalDateTime.now());
		dateTimePicker.setBounds(437, 41, 242, 26);

		appointmentScheduleContainer.add(dateTimePicker);

		assignDropdown = new JComboBox<>();
		assignDropdown.setBorder(new LineBorder(Color.decode("#262626")));
		assignDropdown.setBackground(Color.decode("#ffffff"));
		assignDropdown.setFont(new Font("Open Sans", Font.BOLD, 12));
		assignDropdown.setBounds(66, 40, 231, 26);
		appointmentScheduleContainer.add(assignDropdown);

		attendNowBtn = new JPanel();
		attendNowBtn.setBackground(Color.decode("#4d94ff"));
		attendNowBtn.setBounds(716, 41, 94, 26);
		appointmentScheduleContainer.add(attendNowBtn);
		attendNowBtn.setLayout(new BorderLayout(0, 0));

		attendBtnLbl = new JLabel("Attend now");
		attendBtnLbl.setBorder(new LineBorder(Color.decode("#262626")));
		attendBtnLbl.setForeground(Color.decode("#ffffff"));
		attendBtnLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		attendBtnLbl.setHorizontalAlignment(SwingConstants.CENTER);
		attendNowBtn.add(attendBtnLbl, BorderLayout.CENTER);

		orTextLbl = new JLabel("or");
		orTextLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		orTextLbl.setForeground(Color.decode("#262626"));
		orTextLbl.setBounds(693, 45, 21, 17);
		appointmentScheduleContainer.add(orTextLbl);

		patientDetailsContainer = new JPanel();
		patientDetailsContainer.setBackground(Color.decode("#ffffff"));
		patientDetailsContainer.setBorder(new TitledBorder(new LineBorder(Color.decode("#262626")), "Patient Details",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		addappointmentFormbody.add(patientDetailsContainer, BorderLayout.CENTER);
		patientDetailsContainer.setLayout(null);

		nameLbl = new JLabel("Name");
		nameLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		nameLbl.setBounds(12, 47, 51, 17);
		patientDetailsContainer.add(nameLbl);

		nameTextField = new JTextField();
		nameTextField.setBorder(new LineBorder(Color.decode("#262626")));
		nameTextField.setBounds(92, 41, 230, 30);
		patientDetailsContainer.add(nameTextField);
		nameTextField.setColumns(10);

		ageLbl = new JLabel("Age");
		ageLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		ageLbl.setBounds(12, 242, 51, 17);
		patientDetailsContainer.add(ageLbl);

		genderLbl = new JLabel("Gender");
		genderLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		genderLbl.setBounds(12, 94, 51, 17);
		patientDetailsContainer.add(genderLbl);

		contactLbl = new JLabel("Contact No");
		contactLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		contactLbl.setBounds(12, 289, 72, 17);
		patientDetailsContainer.add(contactLbl);

		addressLbl = new JLabel("Address");
		addressLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		addressLbl.setBounds(12, 139, 51, 17);
		patientDetailsContainer.add(addressLbl);

		addressTextArea = new JTextArea();
		addressTextArea.setBorder(new LineBorder(Color.decode("#262626")));
		addressTextArea.setBounds(92, 138, 230, 90);
		patientDetailsContainer.add(addressTextArea);

		emailLbl = new JLabel("Email");
		emailLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		emailLbl.setBounds(12, 334, 51, 17);
		patientDetailsContainer.add(emailLbl);

		emailTextField = new JTextField();
		emailTextField.setBorder(new LineBorder(Color.decode("#262626")));
		emailTextField.setColumns(10);
		emailTextField.setBounds(92, 332, 230, 30);
		patientDetailsContainer.add(emailTextField);

		contactTextField = new JTextField();
		contactTextField.setBorder(new LineBorder(Color.decode("#262626")));
		contactTextField.setColumns(10);
		contactTextField.setBounds(92, 287, 230, 30);
		patientDetailsContainer.add(contactTextField);

		ageTextField = new JTextField();
		ageTextField.setBorder(new LineBorder(Color.decode("#262626")));
		ageTextField.setColumns(10);
		ageTextField.setBounds(92, 240, 230, 30);
		patientDetailsContainer.add(ageTextField);

		genderDropdown = new JComboBox<>();
		genderDropdown.addItem("Male");
		genderDropdown.addItem("Female");
		genderDropdown.addItem("Others");

		genderDropdown.setFont(new Font("Open Sans", Font.BOLD, 12));
		genderDropdown.setBorder(new LineBorder(Color.decode("#262626")));
		genderDropdown.setBackground(Color.decode("#ffffff"));
		genderDropdown.setBounds(91, 87, 230, 26);
		patientDetailsContainer.add(genderDropdown);

		searchPatientPanel = new JPanel();
		searchPatientPanel.setBackground(Color.BLUE);
		searchPatientPanel.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Search Existing Patient",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		searchPatientPanel.setOpaque(false);
		searchPatientPanel.setBounds(391, 26, 826, 332);
		patientDetailsContainer.add(searchPatientPanel);
		searchPatientPanel.setLayout(null);

		lblPatientNo = new JLabel("Patient No.");
		lblPatientNo.setFont(new Font("Open Sans", Font.BOLD, 12));
		lblPatientNo.setBounds(12, 42, 85, 17);
		searchPatientPanel.add(lblPatientNo);

		patientNoTextField = new JTextField();
		patientNoTextField.setColumns(10);
		patientNoTextField.setBorder(new LineBorder(Color.decode("#262626")));
		patientNoTextField.setBounds(103, 36, 230, 30);
		searchPatientPanel.add(patientNoTextField);

		lblPatientName = new JLabel("Patient Name");
		lblPatientName.setFont(new Font("Open Sans", Font.BOLD, 12));
		lblPatientName.setBounds(12, 100, 85, 17);
		searchPatientPanel.add(lblPatientName);

		patientNameTextField = new JTextField();
		patientNameTextField.setColumns(10);
		patientNameTextField.setBorder(new LineBorder(Color.decode("#262626")));
		patientNameTextField.setBounds(103, 94, 230, 30);
		searchPatientPanel.add(patientNameTextField);

		lblContactNo = new JLabel("Contact No.");
		lblContactNo.setFont(new Font("Open Sans", Font.BOLD, 12));
		lblContactNo.setBounds(12, 159, 85, 17);
		searchPatientPanel.add(lblContactNo);

		contactNoTextField = new JTextField();
		contactNoTextField.setColumns(10);
		contactNoTextField.setBorder(new LineBorder(Color.decode("#262626")));
		contactNoTextField.setBounds(103, 153, 230, 30);
		searchPatientPanel.add(contactNoTextField);

		searchButton = new JPanel();
		searchButton.setBorder(new LineBorder(Color.decode("#262626")));
		searchButton.setBackground(Color.decode("#4d94ff"));
		searchButton.setBounds(215, 195, 118, 30);
		searchPatientPanel.add(searchButton);
		searchButton.setLayout(new BorderLayout(0, 0));

		searchPatientBtnLbl = new JLabel("Search");
		searchPatientBtnLbl.setHorizontalAlignment(SwingConstants.CENTER);
		searchPatientBtnLbl.setForeground(Color.decode("#ffffff"));
		searchPatientBtnLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		searchButton.add(searchPatientBtnLbl, BorderLayout.CENTER);

		searchPatientScrollPane = new JScrollPane();
		searchPatientScrollPane.setBounds(345, 12, 469, 308);
		searchPatientPanel.add(searchPatientScrollPane);

		searchPatientTable = new JTable();
		uneditableTableDataModel = new UneditableTableDataModel(new Object[][] {},
				new String[] { "Patient No.", "Patient Name", "Contact No." });
		searchPatientTable.setModel(uneditableTableDataModel);
		searchPatientTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		searchPatientTable.setGridColor(Color.decode("#737373"));
		searchPatientTable.setFont(new Font("Open Sans", Font.PLAIN, 12));
		searchPatientTable.setRowHeight(32);
		tableHeader = searchPatientTable.getTableHeader();
		tableHeader.setPreferredSize(new Dimension(100, 32));

		searchPatientScrollPane.setViewportView(searchPatientTable);
	}

	private void initEvents() {
		savePanel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(Color.decode("#99c2ff"), savePanel);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(Color.decode("#4d94ff"), savePanel);
			}
		});

		cancelPanel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(Color.decode("#99c2ff"), cancelPanel);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(Color.decode("#4d94ff"), cancelPanel);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Router.INSTANCE.route(AppointmentPanel.class);
			}
		});

		attendNowBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(Color.decode("#99c2ff"), attendNowBtn);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(Color.decode("#4d94ff"), attendNowBtn);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Router.INSTANCE.route(CasePanel.class);
			}
		});

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
				searchExistingCustomer();
			}
		});
	}

	private void changeColor(Color color, Component component) {
		component.setBackground(color);
	}

	private void createAppointment() {

	}

	private void searchExistingCustomer() {
		JOptionPane.showMessageDialog(getParent(), "testing");
	}

	private void resetAll() {

		// clear all fields
		for (Component component : patientDetailsContainer.getComponents()) {

			if (component instanceof JTextField) {
				((JTextField) component).setText("");
			}

			if (component instanceof JTextArea) {
				((JTextArea) component).setText("");
			}

			if (component instanceof JComboBox) {
				((JComboBox) component).setSelectedIndex(-1);
			}
		}

		for (Component component : searchPatientPanel.getComponents()) {

			if (component instanceof JTextField) {
				((JTextField) component).setText("");
			}

		}

		for (Component component : appointmentScheduleContainer.getComponents()) {

			if (component instanceof JComboBox) {
				((JComboBox) component).setSelectedIndex(-1);
			}

		}

		IntStream.range(0, uneditableTableDataModel.getRowCount())
				.forEach(rowIndex -> uneditableTableDataModel.removeRow(0));

		dateTimePicker.setDateTimePermissive(LocalDateTime.now());

	}

	@Override
	public void execute() {
		resetAll();
	}

	@Override
	public void execute(Object... dtos) {
	}
}
