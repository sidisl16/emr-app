package com.emr.app.swing.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.stream.IntStream;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.JTableHeader;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;

import com.emr.app.dtos.PatientDto;
import com.emr.app.swing.service.UIService;
import com.emr.app.utilities.DateUtil;

public class AppointmentPanel extends RoutingPanel {

	private static final long serialVersionUID = 1L;
	private JPanel appointmentHeadingPanel;
	private JPanel addRefreshAppointmentContainer;
	private JPanel refreshPanel;
	private JPanel addPanel;
	private JLabel refreshIcon;
	private JLabel addIcon;
	private JPanel tableContainer;
	private JPanel appointmentHeadingTextContainer;
	private JLabel appointmentTextLbl;
	private JTextField searchTextField;
	private JPanel footer;
	private JScrollPane tableScrollPane;
	private JTable appointmentTable;
	private JLabel copyrightInfo;
	private JTableHeader tableHeader;
	private JProgressBar progressBar;
	private UIService uiService;
	private UneditableTableDataModel uneditableTableDataModel;
	private List<PatientDto> patientAppointments;
	private Object mutex = new Object();

	public AppointmentPanel(UIService uiService, JProgressBar progressBar) {
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

		addRefreshAppointmentContainer = new JPanel();
		addRefreshAppointmentContainer.setBackground(Color.decode("#4d94ff"));
		addRefreshAppointmentContainer.setPreferredSize(new Dimension(110, 10));
		appointmentHeadingPanel.add(addRefreshAppointmentContainer, BorderLayout.EAST);
		addRefreshAppointmentContainer.setLayout(null);

		refreshPanel = new JPanel();
		refreshPanel.setToolTipText("Refresh");
		refreshPanel.setBackground(Color.decode("#4d94ff"));
		refreshPanel.setBounds(0, 0, 53, 48);
		addRefreshAppointmentContainer.add(refreshPanel);
		refreshPanel.setLayout(new BorderLayout(0, 0));

		refreshIcon = new JLabel("");
		refreshIcon.setIcon(new ImageIcon(HomeScreen.class.getResource("/icons/refresh-32.png")));
		refreshIcon.setHorizontalTextPosition(SwingConstants.CENTER);
		refreshIcon.setHorizontalAlignment(SwingConstants.CENTER);
		refreshPanel.add(refreshIcon, BorderLayout.CENTER);

		addPanel = new JPanel();
		addPanel.setToolTipText("Add new Appointment");
		addPanel.setBackground(Color.decode("#4d94ff"));
		addPanel.setBounds(57, 0, 53, 48);
		addRefreshAppointmentContainer.add(addPanel);
		addPanel.setLayout(new BorderLayout(0, 0));

		addIcon = new JLabel("");
		addIcon.setIcon(new ImageIcon(HomeScreen.class.getResource("/icons/add-32.png")));
		addIcon.setHorizontalTextPosition(SwingConstants.CENTER);
		addIcon.setHorizontalAlignment(SwingConstants.CENTER);
		addPanel.add(addIcon, BorderLayout.CENTER);

		appointmentHeadingTextContainer = new JPanel();
		appointmentHeadingTextContainer.setBackground(Color.decode("#4d94ff"));
		appointmentHeadingTextContainer.setPreferredSize(new Dimension(150, 10));
		appointmentHeadingPanel.add(appointmentHeadingTextContainer, BorderLayout.WEST);
		appointmentHeadingTextContainer.setLayout(new BorderLayout(0, 0));

		appointmentTextLbl = new JLabel("Appointments");
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

		appointmentTable = new JTable();
		appointmentTable.setGridColor(Color.decode("#737373"));
		appointmentTable.setFont(new Font("Open Sans", Font.PLAIN, 12));
		appointmentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		uneditableTableDataModel = new UneditableTableDataModel(new Object[][] {},
				new String[] { "Sl. No.", "Patient Name", "Age", "Gender", "Patient Number", "Appointment Time" });
		appointmentTable.setModel(uneditableTableDataModel);
		tableHeader = appointmentTable.getTableHeader();
		tableHeader.setPreferredSize(new Dimension(100, 32));
		appointmentTable.setRowHeight(32);
		tableScrollPane.setViewportView(appointmentTable);
	}

	private void initEvents() {
		refreshPanel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(Color.decode("#99c2ff"), refreshPanel);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(Color.decode("#4d94ff"), refreshPanel);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				TaskWorker.invoke(progressBar, () -> {
					loadAppointmentTable();
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
				Router.INSTANCE.route(AddAppointmentPanel.class);
			}
		});

		appointmentTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					PatientDto patientDto = patientAppointments.get(appointmentTable.getSelectedRow());
					Router.INSTANCE.routeWithData(CasePanel.class, patientDto);
				}

			}
		});
	}

	private void changeColor(Color color, Component component) {
		component.setBackground(color);
	}

	private void loadAppointmentTable() {

		synchronized (mutex) {
			if (uneditableTableDataModel.getRowCount() > 0) {
				IntStream.range(0, uneditableTableDataModel.getRowCount())
						.forEach(rowIndex -> uneditableTableDataModel.removeRow(0));
			}
			patientAppointments = uiService.getAllActiveAppointments();
			if (patientAppointments != null && !patientAppointments.isEmpty()) {
				patientAppointments.stream().forEach(patient -> {
					uneditableTableDataModel.addRow(new Object[] { uneditableTableDataModel.getRowCount() + 1,
							patient.getName(), patient.getAge(), patient.getGender(), patient.getPatientId(),
							DateUtil.formatDate(patient.getAppointmentDto().getDate()) });
				});
			}
		}
	}

	@Override
	public void execute() {
		TaskWorker.invoke(progressBar, () -> {
			loadAppointmentTable();
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

class TextPrompt extends JLabel implements FocusListener, DocumentListener {

	private static final long serialVersionUID = 1L;
	JTextComponent component;
	Document document;

	public TextPrompt(String text, JTextComponent component) {
		this.component = component;
		document = component.getDocument();

		setText(text);
		setFont(new Font("Open Sans", Font.ITALIC, 12));
		setForeground(Color.decode("#4d94ff"));
		setBorder(new EmptyBorder(component.getInsets()));

		component.addFocusListener(this);
		document.addDocumentListener(this);

		component.add(this);
	}

	public void checkForPrompt() {
		if (document.getLength() == 0)
			setSize(component.getSize());
		else
			setSize(0, 0);
	}

	public void focusGained(FocusEvent e) {
		checkForPrompt();
	}

	public void focusLost(FocusEvent e) {
		setSize(0, 0);
	}

	public void insertUpdate(DocumentEvent e) {
		checkForPrompt();
	}

	public void removeUpdate(DocumentEvent e) {
		checkForPrompt();
	}

	public void changedUpdate(DocumentEvent e) {
	}

}
