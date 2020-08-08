package com.emr.app.swing.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;

import com.emr.app.swing.service.UIService;

public class CasePanel extends RoutingPanel {

	private static final long serialVersionUID = 1L;
	private JPanel caseHeadingPanel;
	private JPanel addRefreshCaseContainer;
	private JPanel cancelPanel;
	private JPanel addPanel;
	private JLabel cancelIcon;
	private JLabel addIcon;
	private JPanel tableContainer;
	private JPanel caseHeadingTextContainer;
	private JPanel footer;
	private JScrollPane tableScrollPane;
	private JTable caseTable;
	private JLabel copyrightInfo;
	private JTableHeader tableHeader;
	private JProgressBar progressBar;
	private UIService uiService;
	private UneditableTableDataModel uneditableTableDataModel;
	private JPanel patientProfilePanel;
	private JLabel patientLogoIcon;
	private JLabel patientProfileText;

	public CasePanel(UIService uiService, JProgressBar progressBar) {
		this.uiService = uiService;
		this.progressBar = progressBar;
		initComponents();
		initEvents();
	}

	private void initComponents() {
		setBackground(Color.decode("#ffffff"));
		setLayout(new BorderLayout(0, 0));

		caseHeadingPanel = new JPanel();
		caseHeadingPanel.setBorder(new LineBorder(Color.decode("#bfbfbf")));
		caseHeadingPanel.setBackground(Color.decode("#4d94ff"));
		caseHeadingPanel.setPreferredSize(new Dimension(70, 70));
		add(caseHeadingPanel, BorderLayout.NORTH);
		caseHeadingPanel.setLayout(new BorderLayout(0, 0));

		patientProfilePanel = new JPanel();
		patientProfilePanel.setOpaque(false);
		patientProfilePanel.setPreferredSize(new Dimension(470, 10));
		patientProfilePanel.setLayout(null);
		caseHeadingPanel.add(patientProfilePanel, BorderLayout.WEST);

		patientLogoIcon = new JLabel("S");
		patientLogoIcon.setForeground(Color.decode("#262626"));
		patientLogoIcon.setHorizontalTextPosition(SwingConstants.CENTER);
		patientLogoIcon.setHorizontalAlignment(SwingConstants.CENTER);
		patientLogoIcon.setFont(new Font("Open Sans", Font.BOLD, 35));
		patientLogoIcon.setIcon(new ImageIcon(HomeScreen.class.getResource("/icons/patient-logo.png")));
		patientLogoIcon.setBounds(22, 0, 64, 68);
		patientProfilePanel.add(patientLogoIcon);

		patientProfileText = new JLabel();
		patientProfileText.setText("PAT-32345  |  Siddharth Kumar   |  30 Male  | Cases");
		patientProfileText.setHorizontalTextPosition(SwingConstants.CENTER);
		patientProfileText.setHorizontalAlignment(SwingConstants.CENTER);
		patientProfileText.setForeground(Color.decode("#ffffff"));
		patientProfileText.setFont(new Font("Open Sans", Font.BOLD, 14));
		patientProfileText.setBounds(85, 12, 373, 47);
		patientProfilePanel.add(patientProfileText);

		addRefreshCaseContainer = new JPanel();
		addRefreshCaseContainer.setBackground(Color.decode("#4d94ff"));
		addRefreshCaseContainer.setPreferredSize(new Dimension(150, 10));
		caseHeadingPanel.add(addRefreshCaseContainer, BorderLayout.EAST);
		addRefreshCaseContainer.setLayout(null);

		cancelPanel = new JPanel();
		cancelPanel.setToolTipText("Go back");
		cancelPanel.setBackground(Color.decode("#4d94ff"));
		cancelPanel.setBounds(0, 12, 53, 44);
		addRefreshCaseContainer.add(cancelPanel);
		cancelPanel.setLayout(new BorderLayout(0, 0));

		cancelIcon = new JLabel();
		cancelIcon.setIcon(new ImageIcon(HomeScreen.class.getResource("/icons/back-32.png")));
		cancelIcon.setHorizontalTextPosition(SwingConstants.CENTER);
		cancelIcon.setHorizontalAlignment(SwingConstants.CENTER);
		cancelPanel.add(cancelIcon, BorderLayout.CENTER);

		addPanel = new JPanel();
		addPanel.setToolTipText("Create new case");
		addPanel.setBackground(Color.decode("#4d94ff"));
		addPanel.setBounds(57, 12, 53, 44);
		addRefreshCaseContainer.add(addPanel);
		addPanel.setLayout(new BorderLayout(0, 0));

		addIcon = new JLabel("");
		addIcon.setIcon(new ImageIcon(HomeScreen.class.getResource("/icons/add-32.png")));
		addIcon.setHorizontalTextPosition(SwingConstants.CENTER);
		addIcon.setHorizontalAlignment(SwingConstants.CENTER);
		addPanel.add(addIcon, BorderLayout.CENTER);

		tableContainer = new JPanel();
		tableContainer.setBackground(Color.decode("#ffffff"));
		add(tableContainer, BorderLayout.CENTER);
		tableContainer.setLayout(new BorderLayout(0, 0));

		footer = new JPanel();
		footer.setBackground(Color.decode("#ffffff"));
		footer.setPreferredSize(new Dimension(10, 20));
		tableContainer.add(footer, BorderLayout.SOUTH);
		footer.setLayout(new BorderLayout(0, 0));

		copyrightInfo = new JLabel("Copyright \u00a9" + " 2020 Orange Inc.");
		copyrightInfo.setFont(new Font("Open Sans", Font.BOLD, 12));
		copyrightInfo.setHorizontalAlignment(SwingConstants.CENTER);
		footer.add(copyrightInfo, BorderLayout.CENTER);

		tableScrollPane = new JScrollPane();
		tableScrollPane.setOpaque(false);
		tableScrollPane.setBackground(Color.WHITE);
		tableContainer.add(tableScrollPane, BorderLayout.CENTER);

		caseTable = new JTable();
		caseTable.setGridColor(Color.decode("#737373"));
		caseTable.setFont(new Font("Open Sans", Font.PLAIN, 16));
		caseTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		uneditableTableDataModel = new UneditableTableDataModel(
				new Object[][] { null, null, null, null, null, null, null },
				new String[] { "Sl. No.", "Case Created on", "Status" });
		caseTable.setModel(uneditableTableDataModel);
		tableHeader = caseTable.getTableHeader();
		tableHeader.setPreferredSize(new Dimension(100, 32));
		caseTable.setRowHeight(32);
		tableScrollPane.setViewportView(caseTable);
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
				Router.INSTANCE.route(AppointmentPanel.class);
			}
		});

		addPanel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(Color.decode("#99c2ff"), addPanel);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(Color.decode("#4d94ff"), addPanel);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Router.INSTANCE.route(PatientPanel.class);
			}
		});

		caseTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					SwingUtilities.invokeLater(() -> progressBar.setValue(50));
					SwingUtilities.invokeLater(() -> progressBar.setValue(100));
					Router.INSTANCE.route(PatientPanel.class);
				}

			}
		});
	}

	private void changeColor(Color color, Component component) {
		component.setBackground(color);
	}

	private void loadAppointmentTable() {

	}

	/**
	 * @Override public void execute() { SwingUtilities.invokeLater(() ->
	 *           this.progressBar.setValue(70)); loadAppointmentTable();
	 *           SwingUtilities.invokeLater(() -> this.progressBar.setValue(100));
	 *           SwingUtilities.invokeLater(() -> this.progressBar.setValue(0)); }
	 **/

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}
}
