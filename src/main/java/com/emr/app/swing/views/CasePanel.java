package com.emr.app.swing.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;

import com.emr.app.dtos.CaseDto;
import com.emr.app.dtos.PatientDto;
import com.emr.app.swing.service.UIService;
import com.emr.app.utilities.DateUtil;

public class CasePanel extends RoutingPanel {

	private static final long serialVersionUID = 1L;
	private JPanel caseHeadingPanel;
	private JPanel addRefreshCaseContainer;
	private JPanel cancelPanel;
	private JPanel addPanel;
	private JLabel cancelIcon;
	private JLabel addIcon;
	private JPanel tableContainer;
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
	private List<CaseDto> cases;
	private PatientDto patientDto;
	private Class callingClass;

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
		patientProfilePanel.setPreferredSize(new Dimension(650, 10));
		patientProfilePanel.setLayout(null);
		caseHeadingPanel.add(patientProfilePanel, BorderLayout.WEST);

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
		patientProfileText.setBounds(112, 12, 513, 47);
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

		addIcon = new JLabel();
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
		caseTable.setFont(new Font("Open Sans", Font.PLAIN, 12));
		caseTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		uneditableTableDataModel = new UneditableTableDataModel(new Object[][] {},
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
				Router.INSTANCE.route(callingClass);
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
				Router.INSTANCE.routeWithData(PatientPanel.class, patientDto, new CaseDto());
			}
		});

		caseTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					Router.INSTANCE.routeWithData(PatientPanel.class, patientDto,
							cases.get(caseTable.getSelectedRow()));
				}
			}
		});
	}

	private void changeColor(Color color, Component component) {
		component.setBackground(color);
	}

	private void loadCaseTableForPatient(PatientDto patientDto) {
		this.patientDto = patientDto;
		if (uneditableTableDataModel.getRowCount() > 0) {
			uneditableTableDataModel.setRowCount(0);
		}
		uneditableTableDataModel.fireTableDataChanged();
		cases = uiService.getAllCasesForPatient(patientDto);
		cases.stream().forEach(patientCase -> {
			uneditableTableDataModel.addRow(new Object[] { uneditableTableDataModel.getRowCount() + 1,
					DateUtil.formatDate(patientCase.getCreatedAt()), patientCase.getStatus() });
		});
		uneditableTableDataModel.fireTableDataChanged();
	}

	private void displayPatientProfile(PatientDto patientDto) {
		String patientName = patientDto.getName();
		String patientId = patientDto.getPatientId();
		int patientAge = patientDto.getAge();
		String patientGender = patientDto.getGender();

		String initial = patientName.substring(0, 1).toUpperCase();
		patientLogoIcon.setText(initial);
		patientProfileText
				.setText(patientId + "  |  " + patientName + "   |  " + patientAge + " " + patientGender + "  | Cases");
	}

	@Override
	public void execute() {
	}

	@Override
	public void execute(Object... dtos) {
		if (dtos != null && dtos[0] instanceof PatientDto && dtos[1] instanceof Class) {
			TaskWorker.invoke(progressBar, () -> {
				PatientDto patientDto = (PatientDto) dtos[0];
				callingClass = (Class) dtos[1];
				displayPatientProfile(patientDto);
				loadCaseTableForPatient(patientDto);
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
}
