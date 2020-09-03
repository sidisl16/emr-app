package com.emr.app.swing.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.emr.app.dtos.CaseDto;
import com.emr.app.dtos.MedicineAdviceDto;
import com.emr.app.dtos.PatientDto;
import com.emr.app.dtos.Status;
import com.emr.app.dtos.Vitals;
import com.emr.app.swing.service.UIService;
import com.emr.app.utilities.BinaryDecimalUtil;
import com.emr.app.utilities.InputValidator;
import com.google.common.base.Strings;

public class PatientPanel extends RoutingPanel {

	private static final long serialVersionUID = 1L;
	private JPanel patientHeadingPanel;
	private JPanel patientProfilePanel;
	private JLabel patientLogoIcon;
	private JPanel sideMenuPanel;
	private JLabel patientProfileText;
	private JPanel cancelPanel;
	private JPanel sideMenuContainer;
	private JPanel closeCasePanel;
	private JLabel closeCaseIcon;
	private JPanel viewPanel;
	private JLabel viewIcon;
	private JPanel downloadPanel;
	private JLabel downloadIcon;
	private JPanel savePanel;
	private JLabel saveIcon;
	private JLabel cancelIcon;
	private JPanel patientBodyPanel;
	private JPanel footer;
	private JLabel copyrightInfo;
	private JPanel patientContentContainer;
	private JTabbedPane patientTabbedPane;
	private JPanel patientDetailsPanel;
	private JLabel patientNameLbl;
	private JTextField patientNameTextField;
	private JTextField contactTextField;
	private JTextField ageTextField;
	private JTextField emailTextField;
	private JTextField pulseRatetextField;
	private JTextField heightTextField;
	private JTextField weightTextField;
	private JTextField bmiTextField;
	private JLabel bpSystolicLbl;
	private JTextField bpSysTextField;
	private JLabel mmhgSysLbl;
	private JLabel bpDiastolicLbl;
	private JTextField bpDiasTextField;
	private JLabel tempLbl_;
	private JTextField tempTextField;
	private JLabel tempfarnLbl;
	private JLabel mmhgSysLbl_1;
	private JPanel ccTextPanel;
	private JLabel ccTextLbl;
	private JTextField ccTextTextField;
	private JScrollPane ccTableScrollPane;
	private JTable ccTable;
	private DefaultTableModel ccTableDataModel;
	private JPanel ccClearTabelPanel;
	private JLabel ccClearAllLbl;
	private JPanel medicineAdvicePanel;
	private JPanel testAdvicepanel;
	private JTable medicinetable;
	private JTable examinationTable;
	private JScrollPane examinationTableScrollPane;
	private DefaultTableModel examinationTableModel;
	private JLabel legendLbl;
	private CheckBoxTableDataModel medicineTableDataModel;
	private JScrollPane medicineTableScrollPane;
	private JPanel patientAdvicePanel;
	private JLabel bmiLbl;
	private JLabel weightKgLbl;
	private JLabel weightLbl;
	private JLabel heightCmLbl;
	private JLabel heightLbl;
	private JLabel minLbl;
	private JLabel pulseRateLbl;
	private JPanel vitalsPanel;
	private JTextArea diagnosisTextArea;
	private JPanel diagnosisPanel;
	private JPanel chiefComplaintsPanel;
	private JComboBox<String> genderComboBox;
	private JLabel emailLbl;
	private JTextArea addressTextArea;
	private JLabel addressLbl;
	private JLabel ageLbl;
	private JLabel contactLbl;
	private JLabel genderLbl;
	private JPanel patientCasePanel;
	private AutoSuggestionComponent medicineAutoSuggestion;
	private AutoSuggestionComponent examinationAutoSuggestion;
	private JProgressBar progressBar;
	private UIService uiService;
	private PatientDto patientDto;
	private CaseDto caseDto;
	private JFileChooser fileChooser;
	private Class callingClass;
	private JLabel mandatoryLegend;

	public PatientPanel(UIService uiService, JProgressBar progressBar) {
		this.uiService = uiService;
		this.progressBar = progressBar;
		initComponents();
		initEvents();
	}

	private void initComponents() {
		setBackground(Color.decode("#ffffff"));
		setLayout(new BorderLayout(0, 0));
		setSize(1200, 800);

		fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Save Prescription");
		patientHeadingPanel = new JPanel();
		patientHeadingPanel.setBorder(new LineBorder(Color.decode("#bfbfbf")));
		patientHeadingPanel.setBackground(Color.decode("#4d94ff"));
		patientHeadingPanel.setPreferredSize(new Dimension(70, 70));

		add(patientHeadingPanel, BorderLayout.NORTH);
		patientHeadingPanel.setLayout(new BorderLayout(0, 0));

		patientProfilePanel = new JPanel();
		patientProfilePanel.setOpaque(false);
		patientProfilePanel.setPreferredSize(new Dimension(650, 10));
		patientHeadingPanel.add(patientProfilePanel, BorderLayout.WEST);
		patientProfilePanel.setLayout(null);

		patientLogoIcon = new JLabel();
		patientLogoIcon.setForeground(Color.decode("#262626"));
		patientLogoIcon.setHorizontalTextPosition(SwingConstants.CENTER);
		patientLogoIcon.setHorizontalAlignment(SwingConstants.CENTER);
		patientLogoIcon.setFont(new Font("Open Sans", Font.BOLD, 35));
		patientLogoIcon.setIcon(new ImageIcon(HomeScreen.class.getResource("/icons/patient-logo.png")));
		patientLogoIcon.setBounds(22, 0, 64, 68);
		patientProfilePanel.add(patientLogoIcon);

		patientProfileText = new JLabel();
		patientProfileText.setHorizontalTextPosition(SwingConstants.LEFT);
		patientProfileText.setHorizontalAlignment(SwingConstants.LEFT);
		patientProfileText.setForeground(Color.decode("#ffffff"));
		patientProfileText.setFont(new Font("Open Sans", Font.BOLD, 14));
		patientProfileText.setBounds(98, 12, 540, 47);
		patientProfilePanel.add(patientProfileText);

		sideMenuPanel = new JPanel();
		sideMenuPanel.setPreferredSize(new Dimension(400, 10));
		sideMenuPanel.setOpaque(false);
		patientHeadingPanel.add(sideMenuPanel, BorderLayout.EAST);
		sideMenuPanel.setLayout(null);

		sideMenuContainer = new JPanel();
		sideMenuContainer.setOpaque(false);
		sideMenuContainer.setBounds(12, 12, 357, 44);
		sideMenuPanel.add(sideMenuContainer);
		sideMenuContainer.setLayout(null);

		closeCasePanel = new JPanel();
		closeCasePanel.setToolTipText("Close Case");

		closeCasePanel.setBounds(77, 0, 44, 44);
		sideMenuContainer.add(closeCasePanel);
		closeCasePanel.setLayout(new BorderLayout(0, 0));
		closeCasePanel.setBackground(Color.decode("#4d94ff"));

		closeCaseIcon = new JLabel("");
		closeCaseIcon.setIcon(new ImageIcon(HomeScreen.class.getResource("/icons/close-32.png")));
		closeCaseIcon.setHorizontalTextPosition(SwingConstants.CENTER);
		closeCaseIcon.setHorizontalAlignment(SwingConstants.CENTER);
		closeCasePanel.add(closeCaseIcon, BorderLayout.CENTER);

		viewPanel = new JPanel();
		viewPanel.setToolTipText("View Prescription");
		viewPanel.setBackground(Color.decode("#4d94ff"));
		viewPanel.setBounds(133, 0, 44, 44);
		sideMenuContainer.add(viewPanel);
		viewPanel.setLayout(new BorderLayout(0, 0));

		viewIcon = new JLabel("");
		viewIcon.setIcon(new ImageIcon(HomeScreen.class.getResource("/icons/view-32.png")));
		viewIcon.setHorizontalTextPosition(SwingConstants.CENTER);
		viewIcon.setHorizontalAlignment(SwingConstants.CENTER);
		viewPanel.add(viewIcon, BorderLayout.CENTER);

		downloadPanel = new JPanel();
		downloadPanel.setToolTipText("Download Prescription");
		downloadPanel.setBackground(Color.decode("#4d94ff"));
		downloadPanel.setBounds(189, 0, 44, 44);
		sideMenuContainer.add(downloadPanel);
		downloadPanel.setLayout(new BorderLayout(0, 0));

		downloadIcon = new JLabel("");
		downloadIcon.setIcon(new ImageIcon(HomeScreen.class.getResource("/icons/download-32.png")));
		downloadIcon.setHorizontalTextPosition(SwingConstants.CENTER);
		downloadIcon.setHorizontalAlignment(SwingConstants.CENTER);
		downloadPanel.add(downloadIcon, BorderLayout.CENTER);

		savePanel = new JPanel();
		savePanel.setToolTipText("Save Data");
		savePanel.setBackground(Color.decode("#4d94ff"));
		savePanel.setBounds(245, 0, 44, 44);
		sideMenuContainer.add(savePanel);
		savePanel.setLayout(new BorderLayout(0, 0));

		saveIcon = new JLabel("");
		saveIcon.setHorizontalTextPosition(SwingConstants.CENTER);
		saveIcon.setHorizontalAlignment(SwingConstants.CENTER);
		saveIcon.setIcon(new ImageIcon(HomeScreen.class.getResource("/icons/save-32.png")));
		savePanel.add(saveIcon, BorderLayout.CENTER);

		cancelPanel = new JPanel();
		cancelPanel.setToolTipText("Go Back");
		cancelPanel.setBackground(Color.decode("#4d94ff"));
		cancelPanel.setBounds(301, 0, 44, 44);
		cancelPanel.setLayout(new BorderLayout(0, 0));
		sideMenuContainer.add(cancelPanel);

		cancelIcon = new JLabel("");
		cancelIcon.setIcon(new ImageIcon(HomeScreen.class.getResource("/icons/back-32.png")));
		cancelIcon.setHorizontalTextPosition(SwingConstants.CENTER);
		cancelIcon.setHorizontalAlignment(SwingConstants.CENTER);
		cancelPanel.add(cancelIcon, BorderLayout.CENTER);

		patientBodyPanel = new JPanel();
		patientBodyPanel.setBackground(Color.decode("#ffffff"));
		patientBodyPanel.setLayout(new BorderLayout(0, 0));

		footer = new JPanel();
		footer.setBackground(Color.decode("#ffffff"));
		footer.setPreferredSize(new Dimension(10, 20));
		footer.setLayout(new BorderLayout(0, 0));

		copyrightInfo = new JLabel("Copyright \u00a9" + " 2020 Orange Inc.");
		copyrightInfo.setFont(new Font("Open Sans", Font.BOLD, 12));
		copyrightInfo.setHorizontalAlignment(SwingConstants.CENTER);
		footer.add(copyrightInfo, BorderLayout.CENTER);
		patientBodyPanel.add(footer, BorderLayout.SOUTH);

		add(patientBodyPanel, BorderLayout.CENTER);

		patientContentContainer = new JPanel();
		patientContentContainer.setBackground(Color.decode("#ffffff"));
		patientBodyPanel.add(patientContentContainer, BorderLayout.CENTER);
		patientContentContainer.setLayout(new BorderLayout(0, 0));

		patientTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		patientTabbedPane.setBorder(null);
		patientTabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		patientTabbedPane.setBackground(Color.decode("#ffffff"));
		patientTabbedPane.setFont(new Font("Open Sans", Font.BOLD, 12));

		patientCasePanel = new JPanel();
		patientCasePanel.setBackground(Color.decode("#ffffff"));
		patientTabbedPane.addTab("Patient Profile", patientCasePanel);
		patientCasePanel.setLayout(null);

		patientDetailsPanel = new JPanel();
		patientDetailsPanel.setFont(new Font("Open Sans", Font.PLAIN, 12));
		patientDetailsPanel.setBorder(new TitledBorder(new LineBorder(Color.decode("#262626")), "Patient Details",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		patientDetailsPanel.setOpaque(false);
		patientDetailsPanel.setBounds(12, 12, 600, 250);
		patientCasePanel.add(patientDetailsPanel);
		patientDetailsPanel.setLayout(null);

		patientNameLbl = new JLabel("Name(*)");
		patientNameLbl.setBounds(12, 43, 61, 23);
		patientDetailsPanel.add(patientNameLbl);

		patientNameTextField = new JTextField();
		patientNameTextField.setBorder(new LineBorder(Color.decode("#262626")));
		patientNameTextField.setFont(new Font("Open Sans", Font.PLAIN, 12));
		patientNameTextField.setBounds(74, 41, 191, 27);
		patientDetailsPanel.add(patientNameTextField);
		patientNameTextField.setColumns(10);

		genderLbl = new JLabel("Gender(*)");
		genderLbl.setBounds(12, 93, 61, 23);
		patientDetailsPanel.add(genderLbl);

		contactLbl = new JLabel("Contact No.(*)");
		contactLbl.setBounds(301, 91, 87, 23);
		patientDetailsPanel.add(contactLbl);

		contactTextField = new JTextField();
		contactTextField.setBorder(new LineBorder(Color.decode("#262626")));
		contactTextField.setColumns(10);
		contactTextField.setBounds(391, 89, 191, 27);
		patientDetailsPanel.add(contactTextField);

		ageLbl = new JLabel("Age(*)");
		ageLbl.setBounds(301, 43, 61, 23);
		patientDetailsPanel.add(ageLbl);

		ageTextField = new JTextField();
		ageTextField.setBorder(new LineBorder(Color.decode("#262626")));
		ageTextField.setFont(new Font("Open Sans", Font.PLAIN, 12));
		ageTextField.setColumns(10);
		ageTextField.setBounds(391, 39, 191, 27);
		patientDetailsPanel.add(ageTextField);

		addressLbl = new JLabel("Address");
		addressLbl.setBounds(12, 145, 61, 23);
		patientDetailsPanel.add(addressLbl);

		addressTextArea = new JTextArea();
		addressTextArea.setBorder(new LineBorder(Color.decode("#262626")));
		addressTextArea.setBounds(74, 148, 191, 90);
		patientDetailsPanel.add(addressTextArea);

		emailLbl = new JLabel("Email");
		emailLbl.setBounds(301, 145, 74, 23);
		patientDetailsPanel.add(emailLbl);

		emailTextField = new JTextField();
		emailTextField.setBorder(new LineBorder(Color.decode("#262626")));
		emailTextField.setColumns(10);
		emailTextField.setBounds(391, 145, 191, 27);
		patientDetailsPanel.add(emailTextField);

		genderComboBox = new JComboBox<>();
		genderComboBox.setBorder(new LineBorder(Color.decode("#262626")));
		genderComboBox.setBounds(74, 91, 191, 26);
		genderComboBox.addItem("Male");
		genderComboBox.addItem("Female");
		genderComboBox.addItem("Other");
		patientDetailsPanel.add(genderComboBox);

		mandatoryLegend = new JLabel("(*) - Mandatory fields");
		mandatoryLegend.setFont(new Font("Dialog", Font.PLAIN, 9));
		mandatoryLegend.setBounds(12, 18, 102, 13);
		patientDetailsPanel.add(mandatoryLegend);

		chiefComplaintsPanel = new JPanel();
		chiefComplaintsPanel.setBorder(new TitledBorder(new LineBorder(Color.decode("#262626")), "Chief Complaints",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		chiefComplaintsPanel.setBackground(Color.decode("#ffffff"));
		chiefComplaintsPanel.setBounds(12, 289, 600, 250);
		patientCasePanel.add(chiefComplaintsPanel);
		chiefComplaintsPanel.setLayout(new BorderLayout(0, 0));

		ccTextPanel = new JPanel();
		ccTextPanel.setBorder(null);
		ccTextPanel.setBackground(Color.WHITE);
		ccTextPanel.setPreferredSize(new Dimension(10, 30));
		chiefComplaintsPanel.add(ccTextPanel, BorderLayout.NORTH);
		ccTextPanel.setLayout(null);

		ccTextLbl = new JLabel("Enter Chief Complaints");
		ccTextLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		ccTextLbl.setBounds(12, 0, 149, 30);
		ccTextPanel.add(ccTextLbl);

		ccTextTextField = new JTextField();
		ccTextTextField.setPreferredSize(new Dimension(5, 30));
		ccTextTextField.setColumns(10);
		ccTextTextField.setBorder(new LineBorder(Color.decode("#262626")));
		ccTextTextField.setBounds(165, 0, 300, 30);
		ccTextPanel.add(ccTextTextField);

		ccClearTabelPanel = new JPanel();
		ccClearTabelPanel.setBackground(Color.decode("#4d94ff"));
		ccClearTabelPanel.setBounds(493, 0, 73, 30);
		ccTextPanel.add(ccClearTabelPanel);
		ccClearTabelPanel.setLayout(new BorderLayout(0, 0));

		ccClearAllLbl = new JLabel("Clear All");
		ccClearAllLbl.setForeground(Color.WHITE);
		ccClearAllLbl.setHorizontalTextPosition(SwingConstants.CENTER);
		ccClearAllLbl.setHorizontalAlignment(SwingConstants.CENTER);
		ccClearAllLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		ccClearTabelPanel.add(ccClearAllLbl, BorderLayout.CENTER);

		ccTableScrollPane = new JScrollPane();
		chiefComplaintsPanel.add(ccTableScrollPane, BorderLayout.CENTER);

		ccTable = new JTable();
		ccTable.setRowHeight(25);
		ccTableDataModel = (DefaultTableModel) ccTable.getModel();
		ccTableDataModel.addColumn("Sl No.");
		ccTableDataModel.addColumn("Chief Complaints");
		ccTableScrollPane.setViewportView(ccTable);

		diagnosisPanel = new JPanel();
		diagnosisPanel.setBorder(new TitledBorder(new LineBorder(Color.decode("#262626")), "Diagnosis",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		diagnosisPanel.setBackground(Color.decode("#ffffff"));
		diagnosisPanel.setBounds(650, 289, 600, 250);
		patientCasePanel.add(diagnosisPanel);
		diagnosisPanel.setLayout(null);

		diagnosisTextArea = new JTextArea();
		diagnosisTextArea.setWrapStyleWord(true);
		diagnosisTextArea.setLineWrap(true);
		diagnosisTextArea.setBounds(12, 24, 576, 214);
		diagnosisPanel.add(diagnosisTextArea);

		vitalsPanel = new JPanel();
		vitalsPanel.setBackground(Color.decode("#ffffff"));
		vitalsPanel.setBorder(new TitledBorder(new LineBorder(Color.decode("#262626")), "Vitals", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		vitalsPanel.setBounds(650, 12, 600, 250);
		patientCasePanel.add(vitalsPanel);
		vitalsPanel.setLayout(null);

		pulseRateLbl = new JLabel("Pulse rate");
		pulseRateLbl.setBounds(32, 34, 61, 23);
		vitalsPanel.add(pulseRateLbl);

		pulseRatetextField = new JTextField();
		pulseRatetextField.setFont(new Font("Open Sans", Font.PLAIN, 12));
		pulseRatetextField.setColumns(10);
		pulseRatetextField.setBorder(new LineBorder(Color.decode("#262626")));
		pulseRatetextField.setBounds(124, 30, 95, 27);
		vitalsPanel.add(pulseRatetextField);

		minLbl = new JLabel("/ min");
		minLbl.setBounds(224, 32, 61, 23);
		vitalsPanel.add(minLbl);

		heightTextField = new JTextField();
		heightTextField.setFont(new Font("Open Sans", Font.PLAIN, 12));
		heightTextField.setColumns(10);
		heightTextField.setBorder(new LineBorder(Color.decode("#262626")));
		heightTextField.setBounds(399, 32, 95, 27);
		vitalsPanel.add(heightTextField);

		heightLbl = new JLabel("Height");
		heightLbl.setBounds(320, 34, 61, 23);
		vitalsPanel.add(heightLbl);

		heightCmLbl = new JLabel("cm");
		heightCmLbl.setBounds(499, 34, 61, 23);
		vitalsPanel.add(heightCmLbl);

		weightTextField = new JTextField();
		weightTextField.setFont(new Font("Open Sans", Font.PLAIN, 12));
		weightTextField.setColumns(10);
		weightTextField.setBorder(new LineBorder(Color.decode("#262626")));
		weightTextField.setBounds(399, 81, 95, 27);
		vitalsPanel.add(weightTextField);

		weightLbl = new JLabel("Weight");
		weightLbl.setBounds(320, 83, 61, 23);
		vitalsPanel.add(weightLbl);

		weightKgLbl = new JLabel("Kg");
		weightKgLbl.setBounds(499, 83, 61, 23);
		vitalsPanel.add(weightKgLbl);

		bmiTextField = new JTextField();
		bmiTextField.setFont(new Font("Open Sans", Font.PLAIN, 12));
		bmiTextField.setColumns(10);
		bmiTextField.setBorder(new LineBorder(Color.decode("#262626")));
		bmiTextField.setBounds(399, 125, 95, 27);
		vitalsPanel.add(bmiTextField);

		bmiLbl = new JLabel("BMI");
		bmiLbl.setBounds(320, 127, 61, 23);
		vitalsPanel.add(bmiLbl);

		bpSystolicLbl = new JLabel("BP Systolic");
		bpSystolicLbl.setBounds(32, 83, 74, 23);
		vitalsPanel.add(bpSystolicLbl);

		bpSysTextField = new JTextField();
		bpSysTextField.setFont(new Font("Open Sans", Font.PLAIN, 12));
		bpSysTextField.setColumns(10);
		bpSysTextField.setBorder(new LineBorder(Color.decode("#262626")));
		bpSysTextField.setBounds(124, 79, 95, 27);
		vitalsPanel.add(bpSysTextField);

		mmhgSysLbl = new JLabel("mm Hg");
		mmhgSysLbl.setBounds(224, 81, 61, 23);
		vitalsPanel.add(mmhgSysLbl);

		bpDiastolicLbl = new JLabel("BP Diastolic");
		bpDiastolicLbl.setBounds(32, 127, 74, 23);
		vitalsPanel.add(bpDiastolicLbl);

		bpDiasTextField = new JTextField();
		bpDiasTextField.setFont(new Font("Open Sans", Font.PLAIN, 12));
		bpDiasTextField.setColumns(10);
		bpDiasTextField.setBorder(new LineBorder(Color.decode("#262626")));
		bpDiasTextField.setBounds(124, 123, 95, 27);
		vitalsPanel.add(bpDiasTextField);

		tempLbl_ = new JLabel("Temp.");
		tempLbl_.setBounds(32, 176, 61, 23);
		vitalsPanel.add(tempLbl_);

		tempTextField = new JTextField();
		tempTextField.setFont(new Font("Open Sans", Font.PLAIN, 12));
		tempTextField.setColumns(10);
		tempTextField.setBorder(new LineBorder(Color.decode("#262626")));
		tempTextField.setBounds(124, 172, 95, 27);
		vitalsPanel.add(tempTextField);

		tempfarnLbl = new JLabel("\u00b0F");
		tempfarnLbl.setBounds(224, 174, 61, 23);
		vitalsPanel.add(tempfarnLbl);

		mmhgSysLbl_1 = new JLabel("mm Hg");
		mmhgSysLbl_1.setBounds(224, 125, 61, 23);
		vitalsPanel.add(mmhgSysLbl_1);

		patientAdvicePanel = new JPanel();
		patientAdvicePanel.setBackground(Color.decode("#ffffff"));
		patientTabbedPane.addTab("Advice", patientAdvicePanel);
		patientAdvicePanel.setLayout(null);

		medicineAdvicePanel = new JPanel();
		medicineAdvicePanel.setBorder(new TitledBorder(new LineBorder(Color.decode("#262626")), "Medicine Advice",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		medicineAdvicePanel.setBackground(Color.decode("#ffffff"));
		medicineAdvicePanel.setBounds(43, 12, 1199, 279);
		patientAdvicePanel.add(medicineAdvicePanel);
		medicineAdvicePanel.setLayout(null);

		medicineTableScrollPane = new JScrollPane();
		medicineTableScrollPane.setBounds(519, 23, 657, 221);
		medicineAdvicePanel.add(medicineTableScrollPane);

		medicineTableDataModel = new CheckBoxTableDataModel();
		medicineTableDataModel.addColumn("Sl No.");
		medicineTableDataModel.addColumn("Medicine");
		medicineTableDataModel.addColumn("Days");
		medicineTableDataModel.addColumn("Dosage Direction");
		medicineTableDataModel.addColumn("SOS");
		medicineTableDataModel.addColumn("BF");
		medicineTableDataModel.addColumn("AF");
		medicineTableDataModel.addColumn("BL");
		medicineTableDataModel.addColumn("AL");
		medicineTableDataModel.addColumn("EV");
		medicineTableDataModel.addColumn("BD");
		medicineTableDataModel.addColumn("AD");

		medicinetable = new JTable(medicineTableDataModel);
		medicinetable.setVerifyInputWhenFocusTarget(false);
		medicinetable.setRowHeight(25);
		medicineTableScrollPane.setViewportView(medicinetable);

		legendLbl = new JLabel(
				"SOS - if necessary, BF - Before breakfast, AF - After breakfast, BL - Before lunch, AL - After lunch, EV - Evening, BD - Before dinner, AD - After dinner");
		legendLbl.setHorizontalAlignment(SwingConstants.CENTER);
		legendLbl.setFont(new Font("Open Sans", Font.PLAIN, 12));
		legendLbl.setBounds(472, 250, 727, 17);
		medicineAdvicePanel.add(legendLbl);

		medicineAutoSuggestion = new AutoSuggestionComponent(uiService);
		medicineAutoSuggestion.setTable(medicineTableDataModel);
		medicineAutoSuggestion.setBounds(12, 25, 495, 219);

		medicineAdvicePanel.add(medicineAutoSuggestion);

		testAdvicepanel = new JPanel();
		testAdvicepanel.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Examination",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		testAdvicepanel.setBackground(Color.WHITE);
		testAdvicepanel.setBounds(43, 291, 1199, 249);
		patientAdvicePanel.add(testAdvicepanel);
		testAdvicepanel.setLayout(null);

		examinationTableScrollPane = new JScrollPane();
		examinationTableScrollPane.setBounds(517, 22, 657, 221);
		testAdvicepanel.add(examinationTableScrollPane);

		examinationTable = new JTable();
		examinationTable.setRowHeight(25);
		examinationTableModel = (DefaultTableModel) examinationTable.getModel();
		examinationTableModel.addColumn("Sl No.");
		examinationTableModel.addColumn("Examination");

		examinationTableScrollPane.setViewportView(examinationTable);

		examinationAutoSuggestion = new AutoSuggestionComponent(uiService);
		examinationAutoSuggestion.setBounds(10, 22, 495, 219);
		examinationAutoSuggestion.setTable(examinationTableModel);
		testAdvicepanel.add(examinationAutoSuggestion);

		patientContentContainer.add(patientTabbedPane, BorderLayout.CENTER);
	}

	private void initEvents() {
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
				int option = JOptionPane.showConfirmDialog(getParent(),
						"Make sure to save your changes else it will be lost.", "Confirmation",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				if (option == 0) {
					Router.INSTANCE.routeWithData(CasePanel.class, patientDto, callingClass);
				}
			}
		});

		savePanel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(Color.decode("#99c2ff"), savePanel);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(Color.decode("#4d94ff"), savePanel);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				TaskWorker.invoke(progressBar, () -> {
					boolean isRoutingRequired = saveCaseForPatient();
					if (isRoutingRequired) {
						displayPatientProfile(patientDto);
					}
					return isRoutingRequired;
				}, new Callback() {

					@Override
					public void onSucess(Object response) {
						if (response instanceof Boolean && ((Boolean) response)) {
							JOptionPane.showMessageDialog(getParent(), "Data saved successfully.", "Info",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}

					@Override
					public void onFailure() {
						JOptionPane.showMessageDialog(getParent(), "Internal Error", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				});
			}
		});

		downloadPanel.addMouseListener(new MouseAdapter() {

			private File fileToSave;

			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(Color.decode("#99c2ff"), downloadPanel);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(Color.decode("#4d94ff"), downloadPanel);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				fileToSave = new File(patientDto.getPatientId() + ".pdf");
				fileChooser.setSelectedFile(fileToSave);
				int userSelection = fileChooser.showSaveDialog(getParent());
				if (userSelection == JFileChooser.APPROVE_OPTION) {
					fileToSave = fileChooser.getSelectedFile();
					TaskWorker.invoke(progressBar, () -> {
						boolean isRoutingRequired = saveCaseForPatient()
								& uiService.storePrescriptionPDF(patientDto, null, caseDto, fileToSave);
						if (isRoutingRequired)
							displayPatientProfile(patientDto);
						return isRoutingRequired;
					}, new Callback() {

						@Override
						public void onSucess(Object response) {
							if (response instanceof Boolean && ((Boolean) response)) {
								JOptionPane.showMessageDialog(getParent(),
										"PDF successfully saved at " + fileToSave.getAbsolutePath(), "Info",
										JOptionPane.INFORMATION_MESSAGE);
							} else {
								JOptionPane.showMessageDialog(getParent(), "Internal Error", "Error",
										JOptionPane.ERROR_MESSAGE);
							}
						}

						@Override
						public void onFailure() {
							JOptionPane.showMessageDialog(getParent(), "Internal Error", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					});
				}
			}
		});

		viewPanel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(Color.decode("#99c2ff"), viewPanel);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(Color.decode("#4d94ff"), viewPanel);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				uiService.viewPrescription(patientDto, null, caseDto);
			}
		});

		closeCasePanel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(Color.decode("#99c2ff"), closeCasePanel);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(Color.decode("#4d94ff"), closeCasePanel);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int option = JOptionPane.showConfirmDialog(getParent(), "Are you sure want to close this case?",
						"Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (option == 0) {
					TaskWorker.invoke(progressBar, () -> {
						caseDto.setStatus(Status.CLOSED);
						return saveCaseForPatient();
					}, new Callback() {

						@Override
						public void onSucess(Object response) {
							Router.INSTANCE.routeWithData(CasePanel.class, patientDto, callingClass);
						}

						@Override
						public void onFailure() {
							JOptionPane.showMessageDialog(getParent(), "Internal Error", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					});
				}
			}
		});

		ccTextTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER && !Strings.isNullOrEmpty(ccTextTextField.getText())) {
					ccTableDataModel
							.addRow(new Object[] { ccTableDataModel.getRowCount() + 1, ccTextTextField.getText() });
					ccTextTextField.setText("");
					ccTable.repaint();
				}
			}
		});

		ccTable.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					int selectedRows[] = ccTable.getSelectedRows();
					int count = 0;
					for (int i = 0; i < selectedRows.length; i++) {
						ccTableDataModel.removeRow(selectedRows[i] - count);
						count++;
					}

					int rows = ccTableDataModel.getRowCount();
					if (rows > 0) {
						for (int i = 0; i < rows; i++) {
							ccTableDataModel.setValueAt(i + 1, i, 0);
						}
					}

				}
			}
		});

		ccClearTabelPanel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(Color.decode("#99c2ff"), ccClearTabelPanel);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(Color.decode("#4d94ff"), ccClearTabelPanel);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				IntStream.range(0, ccTableDataModel.getRowCount()).forEach(index -> ccTableDataModel.removeRow(0));
			}
		});

		medicinetable.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					int selectedRows[] = medicinetable.getSelectedRows();
					int count = 0;
					for (int i = 0; i < selectedRows.length; i++) {
						medicineTableDataModel.removeRow(selectedRows[i] - count);
						count++;
					}

					int rows = medicineTableDataModel.getRowCount();
					if (rows > 0) {
						for (int i = 0; i < rows; i++) {
							medicineTableDataModel.setValueAt(i + 1, i, 0);
						}
					}

				}
			}
		});

		examinationTable.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					int selectedRows[] = examinationTable.getSelectedRows();
					int count = 0;
					for (int i = 0; i < selectedRows.length; i++) {
						examinationTableModel.removeRow(selectedRows[i] - count);
						count++;
					}

					int rows = examinationTableModel.getRowCount();
					for (int i = 0; i < rows; i++) {
						examinationTableModel.setValueAt(i + 1, i, 0);
					}

				}
			}
		});
	}

	private boolean saveCaseForPatient() throws Exception {

		String patientName = patientNameTextField.getText().trim();
		String age = ageTextField.getText().trim();
		int genderIndex = genderComboBox.getSelectedIndex();
		String address = addressTextArea.getText().trim();
		String contactNo = contactTextField.getText().trim();
		String email = emailTextField.getText().trim();
		List<String> cc = new ArrayList<>();
		List<MedicineAdviceDto> medicineAdvices = new ArrayList<>();
		List<String> examinations = new ArrayList<>();
		Vitals vitals = new Vitals();

		if ((InputValidator.validateString(patientName) || InputValidator.validateAge(age)
				|| InputValidator.validateContactNo(contactNo) || genderIndex < 0)
				|| InputValidator.validateEmail(email)) {

			JOptionPane.showMessageDialog(getParent(),
					"Please fill all mandotory fields and make sure it contains proper value.", "Warning",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

		for (Component component : vitalsPanel.getComponents()) {

			if (component instanceof JTextField) {
				String value = ((JTextField) component).getText();

				if (!InputValidator.isFloat(value)) {
					JOptionPane.showMessageDialog(getParent(), "Please fill vitals data correctly, e.g. 23.56 or 23",
							"Warning", JOptionPane.WARNING_MESSAGE);
					return false;
				}
			}
		}

		if (medicineTableDataModel.getRowCount() > 0) {
			if (medicinetable.isEditing()) {
				medicinetable.getCellEditor().stopCellEditing();
			}
			for (int i = 0; i < medicineTableDataModel.getRowCount(); i++) {
				if (Strings.isNullOrEmpty((@Nullable String) medicineTableDataModel.getValueAt(i, 1))
						|| Strings.isNullOrEmpty((@Nullable String) medicineTableDataModel.getValueAt(i, 2))
						|| !InputValidator.isInteger(medicineTableDataModel.getValueAt(i, 2).toString())
						|| BinaryDecimalUtil
								.binaryToDec(new boolean[] { (boolean) medicineTableDataModel.getValueAt(i, 4),
										(boolean) medicineTableDataModel.getValueAt(i, 5),
										(boolean) medicineTableDataModel.getValueAt(i, 6),
										(boolean) medicineTableDataModel.getValueAt(i, 7),
										(boolean) medicineTableDataModel.getValueAt(i, 8),
										(boolean) medicineTableDataModel.getValueAt(i, 9),
										(boolean) medicineTableDataModel.getValueAt(i, 10),
										(boolean) medicineTableDataModel.getValueAt(i, 11) }) == 0) {
					JOptionPane.showMessageDialog(getParent(), "Please fill medicine advice correctly.", "Warning",
							JOptionPane.WARNING_MESSAGE);
					return false;
				}

				medicineAdvices.add(new MedicineAdviceDto(medicineTableDataModel.getValueAt(i, 1).toString(),
						Integer.parseInt(medicineTableDataModel.getValueAt(i, 2).toString()),
						medicineTableDataModel.getValueAt(i, 3).toString(),
						BinaryDecimalUtil.binaryToDec(new boolean[] { (boolean) medicineTableDataModel.getValueAt(i, 4),
								(boolean) medicineTableDataModel.getValueAt(i, 5),
								(boolean) medicineTableDataModel.getValueAt(i, 6),
								(boolean) medicineTableDataModel.getValueAt(i, 7),
								(boolean) medicineTableDataModel.getValueAt(i, 8),
								(boolean) medicineTableDataModel.getValueAt(i, 9),
								(boolean) medicineTableDataModel.getValueAt(i, 10),
								(boolean) medicineTableDataModel.getValueAt(i, 11) })));
			}

		}

		patientDto.setName(patientName);
		patientDto.setAge(Integer.parseInt(age));
		patientDto.setGender(genderComboBox.getItemAt(genderIndex));
		patientDto.setAddress(address);
		patientDto.setEmail(email);
		patientDto.setContactNo(contactNo);

		caseDto.setMedicineAdvices(medicineAdvices);

		if (ccTableDataModel.getRowCount() > 0) {
			if (ccTable.isEditing()) {
				ccTable.getCellEditor().stopCellEditing();
			}
			for (int i = 0; i < ccTableDataModel.getRowCount(); i++) {
				if (!Strings.isNullOrEmpty(ccTableDataModel.getValueAt(i, 1).toString())) {
					cc.add(ccTableDataModel.getValueAt(i, 1).toString());
				}
			}
		}

		if (!Strings.isNullOrEmpty(bmiTextField.getText())) {
			vitals.setBmi(Float.parseFloat(bmiTextField.getText()));
		}

		if (!Strings.isNullOrEmpty(bpDiasTextField.getText())) {
			vitals.setBpDistolic(Float.parseFloat(bpDiasTextField.getText()));
		}

		if (!Strings.isNullOrEmpty(bpSysTextField.getText())) {
			vitals.setBpSystolic(Float.parseFloat(bpSysTextField.getText()));
		}

		if (!Strings.isNullOrEmpty(heightTextField.getText())) {
			vitals.setHeight(Float.parseFloat(heightTextField.getText()));
		}

		if (!Strings.isNullOrEmpty(pulseRatetextField.getText())) {
			vitals.setPulserate(Float.parseFloat(pulseRatetextField.getText()));
		}

		if (!Strings.isNullOrEmpty(tempTextField.getText())) {
			vitals.setTemp(Float.parseFloat(tempTextField.getText()));
		}

		if (!Strings.isNullOrEmpty(weightTextField.getText())) {
			vitals.setWeight(Float.parseFloat(weightTextField.getText()));
		}

		caseDto.setChiefComplaints(cc);
		caseDto.setVitals(vitals);

		if (examinationTableModel.getRowCount() > 0) {
			if (examinationTable.isEditing()) {
				examinationTable.getCellEditor().stopCellEditing();
			}
			for (int i = 0; i < examinationTableModel.getRowCount(); i++) {
				if (!Strings.isNullOrEmpty(examinationTableModel.getValueAt(i, 1).toString())) {
					examinations.add(examinationTableModel.getValueAt(i, 1).toString());
				}
			}
		}
		caseDto.setExaminationAdvices(examinations);
		caseDto.setDiagnosis(diagnosisTextArea.getText());

		patientDto = uiService.createCaseData(patientDto, caseDto);
		caseDto = patientDto.getCaseDto();
		return true;
	}

	private void changeColor(Color color, Component component) {
		component.setBackground(color);
	}

	private void displayPatientProfile(PatientDto patientDto) {

		this.patientDto = patientDto;

		String patientName = patientDto.getName();
		String patientId = patientDto.getPatientId();
		int patientAge = patientDto.getAge();
		String patientGender = patientDto.getGender();

		String initial = patientName.substring(0, 1).toUpperCase();
		patientLogoIcon.setText(initial);
		patientProfileText.setText(patientId + "  |  " + patientName + "   |  " + patientAge + " " + patientGender);

		patientNameTextField.setText(patientName);
		ageTextField.setText(String.valueOf(patientAge));
		genderComboBox.setSelectedIndex(getIndexOfItem(genderComboBox, patientGender));
		contactTextField.setText(patientDto.getContactNo());

		if (Strings.isNullOrEmpty(patientDto.getAddress())) {
			addressTextArea.setText("");
		} else {
			addressTextArea.setText(patientDto.getAddress());
		}

		if (Strings.isNullOrEmpty(patientDto.getEmail())) {
			emailTextField.setText("");
		} else {
			emailTextField.setText(patientDto.getEmail());
		}

	}

	private void loadCaseData(CaseDto caseDto) {

		this.caseDto = caseDto;

		if (caseDto.getStatus() == Status.CLOSED) {
			patientProfileText.setText(patientProfileText.getText() + " | " + Status.CLOSED);
			closeCasePanel.setVisible(false);
		} else {
			closeCasePanel.setVisible(true);
			patientProfileText.setText(patientProfileText.getText() + " | " + Status.ACTIVE);
		}

		if (!InputValidator.validateString(caseDto.getDiagnosis())) {
			diagnosisTextArea.setText(caseDto.getDiagnosis());
		}

		if (caseDto.getVitals() != null) {
			Vitals vitals = caseDto.getVitals();

			if (vitals.getBmi() != null) {
				bmiTextField.setText(String.valueOf(vitals.getBmi()));
			}

			if (vitals.getBpDistolic() != null) {
				bpDiasTextField.setText(String.valueOf(vitals.getBpDistolic()));
			}

			if (vitals.getBpSystolic() != null) {
				bpSysTextField.setText(String.valueOf(vitals.getBpSystolic()));
			}

			if (vitals.getHeight() != null) {
				heightTextField.setText(String.valueOf(vitals.getHeight()));
			}

			if (vitals.getPulserate() != null) {
				pulseRatetextField.setText(String.valueOf(vitals.getPulserate()));
			}

			if (vitals.getTemp() != null) {
				tempTextField.setText(String.valueOf(vitals.getTemp()));
			}

			if (vitals.getWeight() != null) {
				weightTextField.setText(String.valueOf(vitals.getWeight()));
			}
		}

		if (caseDto.getChiefComplaints() != null && !caseDto.getChiefComplaints().isEmpty()) {
			caseDto.getChiefComplaints().stream()
					.forEach(cc -> ccTableDataModel.addRow(new Object[] { ccTableDataModel.getRowCount() + 1, cc }));
		}

		if (caseDto.getExaminationAdvices() != null && !caseDto.getExaminationAdvices().isEmpty()) {
			caseDto.getExaminationAdvices().stream().forEach(examination -> examinationTableModel
					.addRow(new Object[] { examinationTableModel.getRowCount() + 1, examination }));
		}

		if (caseDto.getMedicineAdvices() != null && !caseDto.getMedicineAdvices().isEmpty()) {
			caseDto.getMedicineAdvices().stream().forEach(medicineAdvice -> {
				boolean[] binary = BinaryDecimalUtil.decToBinary(medicineAdvice.getDosage());
				medicineTableDataModel.addRow(new Object[] { medicineTableDataModel.getRowCount() + 1,
						medicineAdvice.getName(), String.valueOf(medicineAdvice.getDays()),
						medicineAdvice.getDosageDirection(), binary[0], binary[1], binary[2], binary[3], binary[4],
						binary[5], binary[6], binary[7] });
			});
		}

	}

	private void resetAll() {
		// clear all fields
		for (Component component : patientDetailsPanel.getComponents()) {

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

		if (ccTableDataModel.getRowCount() > 0) {
			IntStream.range(0, ccTable.getRowCount()).forEach(rowIndex -> ccTableDataModel.removeRow(0));
		}

		diagnosisTextArea.setText("");

		for (Component component : vitalsPanel.getComponents()) {

			if (component instanceof JTextField) {
				((JTextField) component).setText("");
			}
		}

		if (medicineTableDataModel.getRowCount() > 0) {
			IntStream.range(0, medicinetable.getRowCount()).forEach(rowIndex -> medicineTableDataModel.removeRow(0));
		}

		if (examinationTableModel.getRowCount() > 0) {
			IntStream.range(0, examinationTableModel.getRowCount())
					.forEach(rowIndex -> examinationTableModel.removeRow(0));
		}

	}

	private int getIndexOfItem(JComboBox<String> combobox, String item) {
		for (int i = 0; i < combobox.getItemCount(); i++) {
			if (combobox.getItemAt(i).equals(item)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void execute() {
	}

	@Override
	public void execute(Object... dtos) {
		TaskWorker.invoke(progressBar, () -> {
			if (dtos != null && dtos[0] instanceof PatientDto && dtos[1] instanceof CaseDto
					&& dtos[2] instanceof Class) {
				resetAll();
				displayPatientProfile((PatientDto) dtos[0]);
				loadCaseData((CaseDto) dtos[1]);
				callingClass = (Class) dtos[2];
			}
			return null;
		}, new Callback() {

			@Override
			public void onSucess(Object response) {
			}

			@Override
			public void onFailure() {
				JOptionPane.showMessageDialog(getParent(), "Internal error.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
	}
}