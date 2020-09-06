package com.emr.app.swing.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

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
	private JLabel clinicNameLbl;
	private JTextField clinicNameTextField;
	private JLabel clinicEmailLbl;
	private JTextField emailTextField;
	private JLabel clinicAddressLbl;
	private JLabel contactLbl;
	private JTextField contactTextField;
	private JLabel qualFieldInfo;
	private JPanel addUserBtn;
	private JLabel lblUpdate;
	private JPanel updateDatasourcePanel;
	private JPanel updateDsBtn;
	private JLabel lblDsBtn;
	private JToggleButton editEnableToggleBtn;
	private JTextField hostTextField;
	private JTextField passwordtextField;
	private JTextField porttextField;
	private JLabel datasourceInfo;
	private JLabel passwordLbl;
	private JLabel lblPort;
	private JLabel lblHost;
	private JTextArea addressTextArea;

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
		appSettingsPanel.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Clinic Details",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		appSettingsPanel.setBounds(22, 23, 344, 360);
		settingsBodyPanel.add(appSettingsPanel);

		clinicNameLbl = new JLabel("Clinic Name*");
		clinicNameLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		clinicNameLbl.setBounds(12, 35, 86, 17);
		appSettingsPanel.add(clinicNameLbl);

		clinicNameTextField = new JTextField();
		clinicNameTextField.setPreferredSize(new Dimension(5, 64));
		clinicNameTextField.setColumns(10);
		clinicNameTextField.setBorder(new LineBorder(Color.DARK_GRAY));
		clinicNameTextField.setBounds(100, 26, 210, 36);
		appSettingsPanel.add(clinicNameTextField);

		clinicEmailLbl = new JLabel("Email*");
		clinicEmailLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		clinicEmailLbl.setBounds(12, 88, 86, 17);
		appSettingsPanel.add(clinicEmailLbl);

		emailTextField = new JTextField();
		emailTextField.setPreferredSize(new Dimension(5, 64));
		emailTextField.setColumns(10);
		emailTextField.setBorder(new LineBorder(Color.DARK_GRAY));
		emailTextField.setBounds(100, 74, 210, 36);
		appSettingsPanel.add(emailTextField);

		clinicAddressLbl = new JLabel("Address*");
		clinicAddressLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		clinicAddressLbl.setBounds(12, 131, 86, 17);
		appSettingsPanel.add(clinicAddressLbl);

		contactLbl = new JLabel("Contact*");
		contactLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		contactLbl.setBounds(12, 249, 70, 17);
		appSettingsPanel.add(contactLbl);

		contactTextField = new JTextField();
		contactTextField.setPreferredSize(new Dimension(5, 64));
		contactTextField.setColumns(10);
		contactTextField.setBorder(new LineBorder(Color.DARK_GRAY));
		contactTextField.setBounds(100, 240, 210, 36);
		appSettingsPanel.add(contactTextField);

		qualFieldInfo = new JLabel("(*) Marked will be displayed in Prescription, ensure to fill proper value");
		qualFieldInfo.setFont(new Font("Open Sans", Font.BOLD, 8));
		qualFieldInfo.setBounds(12, 335, 298, 17);
		appSettingsPanel.add(qualFieldInfo);

		addUserBtn = new JPanel();
		addUserBtn.setBackground(new Color(77, 148, 255));
		addUserBtn.setBounds(210, 288, 100, 35);
		appSettingsPanel.add(addUserBtn);
		addUserBtn.setLayout(new BorderLayout(0, 0));

		lblUpdate = new JLabel("Update");
		lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate.setForeground(Color.WHITE);
		lblUpdate.setFont(new Font("Open Sans", Font.BOLD, 12));
		addUserBtn.add(lblUpdate, BorderLayout.CENTER);

		addressTextArea = new JTextArea();
		addressTextArea.setBorder(new LineBorder(Color.DARK_GRAY));
		addressTextArea.setBounds(100, 131, 210, 97);
		appSettingsPanel.add(addressTextArea);

		updateDatasourcePanel = new JPanel();
		updateDatasourcePanel.setForeground(Color.BLACK);
		updateDatasourcePanel.setLayout(null);
		updateDatasourcePanel.setOpaque(false);
		updateDatasourcePanel.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Datasource settings",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(64, 64, 64)));
		updateDatasourcePanel.setBounds(439, 23, 344, 312);
		settingsBodyPanel.add(updateDatasourcePanel);

		updateDsBtn = new JPanel();
		updateDsBtn.setEnabled(false);
		updateDsBtn.setBackground(new Color(77, 148, 255));
		updateDsBtn.setBounds(208, 232, 100, 35);
		updateDsBtn.setLayout(new BorderLayout(0, 0));
		updateDatasourcePanel.add(updateDsBtn);

		lblDsBtn = new JLabel("Update");
		lblDsBtn.setHorizontalAlignment(SwingConstants.CENTER);
		lblDsBtn.setForeground(Color.WHITE);
		lblDsBtn.setFont(new Font("Open Sans", Font.BOLD, 12));
		updateDsBtn.add(lblDsBtn, BorderLayout.CENTER);

		editEnableToggleBtn = new JToggleButton("Click to Edit");
		editEnableToggleBtn.setForeground(Color.WHITE);
		editEnableToggleBtn.setFont(new Font("Open Sans", Font.BOLD, 12));
		editEnableToggleBtn.setBackground(Color.decode("#4d94ff"));
		editEnableToggleBtn.setBounds(128, 30, 133, 27);
		updateDatasourcePanel.add(editEnableToggleBtn);

		lblHost = new JLabel("Host*");
		lblHost.setFont(new Font("Open Sans", Font.BOLD, 12));
		lblHost.setBounds(22, 97, 78, 17);
		updateDatasourcePanel.add(lblHost);

		hostTextField = new JTextField();
		hostTextField.setPreferredSize(new Dimension(5, 64));
		hostTextField.setColumns(10);
		hostTextField.setBorder(new LineBorder(Color.DARK_GRAY));
		hostTextField.setBounds(100, 88, 210, 36);
		updateDatasourcePanel.add(hostTextField);

		passwordLbl = new JLabel("Password*");
		passwordLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		passwordLbl.setBounds(22, 193, 71, 17);
		updateDatasourcePanel.add(passwordLbl);

		passwordtextField = new JTextField();
		passwordtextField.setPreferredSize(new Dimension(5, 64));
		passwordtextField.setColumns(10);
		passwordtextField.setBorder(new LineBorder(Color.DARK_GRAY));
		passwordtextField.setBounds(100, 184, 210, 36);
		updateDatasourcePanel.add(passwordtextField);

		lblPort = new JLabel("Port*");
		lblPort.setFont(new Font("Open Sans", Font.BOLD, 12));
		lblPort.setBounds(22, 145, 64, 17);
		updateDatasourcePanel.add(lblPort);

		porttextField = new JTextField();
		porttextField.setPreferredSize(new Dimension(5, 64));
		porttextField.setColumns(10);
		porttextField.setBorder(new LineBorder(Color.DARK_GRAY));
		porttextField.setBounds(100, 136, 210, 36);
		updateDatasourcePanel.add(porttextField);

		datasourceInfo = new JLabel("(*) Mandatory fields for Mongo DB configuration");
		datasourceInfo.setFont(new Font("Open Sans", Font.BOLD, 8));
		datasourceInfo.setBounds(22, 283, 298, 17);
		updateDatasourcePanel.add(datasourceInfo);
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

		editEnableToggleBtn.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent itemEvent) {
				int state = itemEvent.getStateChange();
				if (state == ItemEvent.SELECTED) {
					enableDatasourceSettings();
				} else {
					disableDatasourceSettings();
				}
			}
		});
	}

	private void changeColor(Color color, Component component) {
		component.setBackground(color);
	}

	private void disableDatasourceSettings() {
		for (Component comp : updateDatasourcePanel.getComponents()) {
			if (!(comp instanceof JToggleButton))
				comp.setEnabled(false);
		}
		if (updateDsBtn.getMouseListeners().length > 0)
			updateDsBtn.removeMouseListener(updateDsBtn.getMouseListeners()[0]);
	}

	private void enableDatasourceSettings() {
		for (Component comp : updateDatasourcePanel.getComponents()) {
			if (!(comp instanceof JToggleButton))
				comp.setEnabled(true);
		}

		updateDsBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(Color.decode("#99c2ff"), updateDsBtn);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(Color.decode("#4d94ff"), updateDsBtn);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int option = JOptionPane.showConfirmDialog(getParent(),
						"Make sure you provided proper values else application may not work as expected.", "Warning",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				if (option == 0) {
				}
			}
		});
	}

	@Override
	public void execute() {
		disableDatasourceSettings();
	}

	@Override
	public void execute(Object... dtos) {
	}
}
