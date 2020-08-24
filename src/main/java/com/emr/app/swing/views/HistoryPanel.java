package com.emr.app.swing.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;

import com.emr.app.dtos.PatientDto;
import com.emr.app.swing.service.UIService;
import com.google.common.base.Strings;

public class HistoryPanel extends RoutingPanel {

	private static final long serialVersionUID = 1L;
	private JPanel appointmentHeadingPanel;
	private JPanel historyContainer;
	private JPanel appointmentHeadingTextContainer;
	private JLabel appointmentTextLbl;
	private JTextField searchTextField;
	private JPanel footer;
	private JLabel copyrightInfo;
	private JProgressBar progressBar;
	private UIService uiService;
	private JPanel searchHistoryBody;
	private JPanel searchPanel;
	private JTextField patIdTextField;
	private JTextField patContactTextField;
	private JTextField nametextField;
	private JLabel searchPatLbl;
	private JTable patientHistorytable;
	private UneditableTableDataModel uneditableTableDataModel;
	private List<PatientDto> patients;
	private JLabel searchPatIdLbl;
	private JLabel searchPatNameIdLbl;
	private JLabel lblName;
	private JPanel searchBtn;
	private JLabel serachBtnLbl;
	private JPanel resetBtn;
	private JLabel resetSearchLbl;
	private JTableHeader tableHeader;

	public HistoryPanel(UIService uiService, JProgressBar progressBar) {
		this.uiService = uiService;
		this.progressBar = progressBar;
		initComponents();
		initEvents();
	}

	private void initComponents() {
		setBackground(Color.decode("#ffffff"));
		setLayout(new BorderLayout(0, 0));

		appointmentHeadingPanel = new JPanel();
		appointmentHeadingPanel.setBorder(new LineBorder(Color.decode("#bfbfbf")));
		appointmentHeadingPanel.setBackground(Color.decode("#4d94ff"));
		appointmentHeadingPanel.setPreferredSize(new Dimension(70, 50));
		add(appointmentHeadingPanel, BorderLayout.NORTH);
		appointmentHeadingPanel.setLayout(new BorderLayout(0, 0));

		appointmentHeadingTextContainer = new JPanel();
		appointmentHeadingTextContainer.setBackground(Color.decode("#4d94ff"));
		appointmentHeadingTextContainer.setPreferredSize(new Dimension(150, 10));
		appointmentHeadingPanel.add(appointmentHeadingTextContainer, BorderLayout.WEST);
		appointmentHeadingTextContainer.setLayout(new BorderLayout(0, 0));

		appointmentTextLbl = new JLabel("Patient History");
		appointmentTextLbl.setForeground(Color.decode("#ffffff"));
		appointmentTextLbl.setHorizontalTextPosition(SwingConstants.CENTER);
		appointmentTextLbl.setHorizontalAlignment(SwingConstants.CENTER);
		appointmentTextLbl.setFont(new Font("Open Sans", Font.BOLD, 16));
		appointmentHeadingTextContainer.add(appointmentTextLbl, BorderLayout.CENTER);

		searchTextField = new JTextField();
		searchTextField.setVerifyInputWhenFocusTarget(false);
		searchTextField.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		searchTextField.setToolTipText("Search Patient");
		searchTextField.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		searchTextField.setFont(new Font("Open Sans", Font.PLAIN, 14));
		searchTextField.setSelectedTextColor(Color.decode("#4d94ff"));
		searchTextField.setSelectionColor(Color.decode("#ffffff"));
		searchTextField.setBounds(12, 8, 210, 32);
		searchTextField.setBorder(BorderFactory.createCompoundBorder(searchTextField.getBorder(),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		historyContainer = new JPanel();
		historyContainer.setBackground(Color.decode("#ffffff"));
		add(historyContainer, BorderLayout.CENTER);
		historyContainer.setLayout(new BorderLayout(0, 0));

		footer = new JPanel();
		footer.setBackground(Color.decode("#ffffff"));
		footer.setPreferredSize(new Dimension(10, 20));
		historyContainer.add(footer, BorderLayout.SOUTH);
		footer.setLayout(new BorderLayout(0, 0));

		copyrightInfo = new JLabel("Copyright \u00a9" + " 2020 Orange Inc.");
		copyrightInfo.setFont(new Font("Open Sans", Font.BOLD, 12));
		copyrightInfo.setHorizontalAlignment(SwingConstants.CENTER);
		footer.add(copyrightInfo, BorderLayout.CENTER);

		searchHistoryBody = new JPanel();
		searchHistoryBody.setOpaque(false);
		historyContainer.add(searchHistoryBody, BorderLayout.CENTER);
		searchHistoryBody.setLayout(new BorderLayout(0, 0));

		searchPanel = new JPanel();
		searchPanel.setBorder(new LineBorder(Color.DARK_GRAY));
		searchPanel.setOpaque(false);
		searchPanel.setPreferredSize(new Dimension(10, 60));
		searchHistoryBody.add(searchPanel, BorderLayout.NORTH);
		searchPanel.setLayout(null);

		patIdTextField = new JTextField();
		patIdTextField.setBorder(new LineBorder(Color.DARK_GRAY));
		patIdTextField.setBounds(177, 16, 200, 32);
		searchPanel.add(patIdTextField);
		patIdTextField.setColumns(10);

		searchPatIdLbl = new JLabel("Patient Id");
		searchPatIdLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		searchPatIdLbl.setBounds(114, 23, 59, 17);
		searchPanel.add(searchPatIdLbl);

		searchPatNameIdLbl = new JLabel("Contact No.");
		searchPatNameIdLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		searchPatNameIdLbl.setBounds(388, 23, 77, 17);
		searchPanel.add(searchPatNameIdLbl);

		patContactTextField = new JTextField();
		patContactTextField.setColumns(10);
		patContactTextField.setBorder(new LineBorder(Color.DARK_GRAY));
		patContactTextField.setBounds(464, 16, 200, 32);
		searchPanel.add(patContactTextField);

		lblName = new JLabel("Name");
		lblName.setFont(new Font("Open Sans", Font.BOLD, 12));
		lblName.setBounds(676, 23, 42, 17);
		searchPanel.add(lblName);

		nametextField = new JTextField();
		nametextField.setColumns(10);
		nametextField.setBorder(new LineBorder(Color.DARK_GRAY));
		nametextField.setBounds(720, 16, 200, 32);
		searchPanel.add(nametextField);

		searchBtn = new JPanel();
		searchBtn.setToolTipText("Search");
		searchBtn.setBackground(new Color(77, 148, 255));
		searchBtn.setBounds(977, 16, 90, 32);
		searchPanel.add(searchBtn);
		searchBtn.setLayout(new BorderLayout(0, 0));

		serachBtnLbl = new JLabel("Search");
		serachBtnLbl.setForeground(Color.WHITE);
		serachBtnLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		serachBtnLbl.setHorizontalAlignment(SwingConstants.CENTER);
		searchBtn.add(serachBtnLbl, BorderLayout.CENTER);

		resetBtn = new JPanel();
		resetBtn.setToolTipText("Refresh");
		resetBtn.setBackground(new Color(77, 148, 255));
		resetBtn.setBounds(1084, 16, 90, 32);
		searchPanel.add(resetBtn);
		resetBtn.setLayout(new BorderLayout(0, 0));

		resetSearchLbl = new JLabel("Reset");
		resetSearchLbl.setForeground(Color.WHITE);
		resetSearchLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		resetSearchLbl.setHorizontalAlignment(SwingConstants.CENTER);
		resetBtn.add(resetSearchLbl, BorderLayout.CENTER);

		searchPatLbl = new JLabel("Search:");
		searchPatLbl.setHorizontalAlignment(SwingConstants.CENTER);
		searchPatLbl.setFont(new Font("Open Sans", Font.BOLD, 14));
		searchPatLbl.setBounds(12, 16, 90, 32);
		searchPanel.add(searchPatLbl);

		JScrollPane historyScrollPane = new JScrollPane();
		searchHistoryBody.add(historyScrollPane, BorderLayout.CENTER);

		patientHistorytable = new JTable();
		uneditableTableDataModel = new UneditableTableDataModel(new Object[][] {}, new String[] { "Sl. No.", "Name",
				"Age", "Gender", "Patient Number", "Contact No.", "Email", "Address" });
		patientHistorytable.setModel(uneditableTableDataModel);
		tableHeader = patientHistorytable.getTableHeader();
		tableHeader.setPreferredSize(new Dimension(100, 32));
		patientHistorytable.setRowHeight(32);
		historyScrollPane.setViewportView(patientHistorytable);
	}

	private void reset() {
		patContactTextField.setText("");
		patIdTextField.setText("");
		nametextField.setText("");
		patients = uiService.getAllPatient();
		loadPatientTable();
	}

	private void searchExistingPatient() throws Exception {

		String name = nametextField.getText();
		String patientId = patIdTextField.getText();
		String contactNo = patContactTextField.getText();
		Pattern pattern = Pattern.compile("^\\d{10}$");
		Matcher matcher = pattern.matcher(contactNo);

		if ((Strings.isNullOrEmpty(name) && Strings.isNullOrEmpty(patientId) && Strings.isNullOrEmpty(contactNo))
				|| (!Strings.isNullOrEmpty(contactNo) && !matcher.matches())) {
			JOptionPane.showMessageDialog(getParent(), "Please enter valid search criteria.", "Warning",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		if (uneditableTableDataModel.getRowCount() > 0) {
			IntStream.range(0, uneditableTableDataModel.getRowCount())
					.forEach(rowIndex -> uneditableTableDataModel.removeRow(0));
		}

		patients = uiService.searchExistingPatient(patientId, name, contactNo);
		if (patients == null || patients.isEmpty()) {
			JOptionPane.showMessageDialog(getParent(), "No patient found.", "Info", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		loadPatientTable();
		return;
	}

	private void loadPatientTable() {
		if (uneditableTableDataModel.getRowCount() > 0) {
			uneditableTableDataModel.setRowCount(0);
		}
		uneditableTableDataModel.fireTableDataChanged();
		if (patients != null && !patients.isEmpty()) {
			patients.stream().forEach(patient -> {
				uneditableTableDataModel.addRow(new Object[] { uneditableTableDataModel.getRowCount() + 1,
						patient.getName(), patient.getAge(), patient.getGender(), patient.getPatientId(),
						patient.getContactNo(), patient.getEmail(), patient.getAddress() });
			});
		}
		uneditableTableDataModel.fireTableDataChanged();
	}

	private void initEvents() {
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
				TaskWorker.invoke(progressBar, () -> {
					reset();
					return null;
				}, new Callback() {

					@Override
					public void onSucess(Object response) {
					}

					@Override
					public void onFailure() {
						JOptionPane.showMessageDialog(getParent(), "Internal error.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				});

			}
		});

		searchBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(Color.decode("#99c2ff"), searchBtn);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(Color.decode("#4d94ff"), searchBtn);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				TaskWorker.invoke(progressBar, () -> {
					searchExistingPatient();
					return null;
				}, new Callback() {

					@Override
					public void onSucess(Object response) {
					}

					@Override
					public void onFailure() {
						JOptionPane.showMessageDialog(getParent(), "Internal error.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				});

			}
		});

		patientHistorytable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					PatientDto patientDto = patients.get(patientHistorytable.getSelectedRow());
					Router.INSTANCE.routeWithData(CasePanel.class, patientDto, HistoryPanel.class);
				}

			}
		});

	}

	private void changeColor(Color color, Component component) {
		component.setBackground(color);
	}

	@Override
	public void execute() {
		TaskWorker.invoke(progressBar, () -> {
			reset();
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

	@Override
	public void execute(Object... dtos) {
	}
}