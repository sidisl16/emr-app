package com.emr.app.swing.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.springframework.data.mongodb.core.aggregation.SetOperators.SetDifference;

import com.emr.app.swing.service.UIService;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EmptyBorder;

public class InventoryPanel extends RoutingPanel {

	private static final long serialVersionUID = 1L;
	private JPanel inventoryHeadingPanel;
	private JPanel tableContainer;
	private JPanel inventoryHeadingTextContainer;
	private JLabel inventoryTextLbl;
	private JPanel footer;
	private JLabel copyrightInfo;
	private JProgressBar progressBar;
	private UIService uiService;
	private JPanel inventoryBodyPanel;
	private JTabbedPane tabbedPane;
	private JPanel medicineStockPanel;
	private JPanel examination;
	private JPanel searchMedicinePanel;
	private JTextField medNameTextField;
	private JTextField companyTextField;
	private JLabel searchBtn;
	private JLabel searchLabel;
	private JLabel name;
	private JLabel lblComapany;
	private JPanel searchButton;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel addMedicinePanel;
	private JPanel addBodyPanel;
	private JTextField medNameAddTextField;
	private JLabel medNameLbl;
	private JLabel CompanyLbl;
	private JTextField companyAddTextField;
	private JLabel doseLbl;
	private JTextField doseTextField;
	private JLabel routeLbl;
	private JTextField routetextField;
	private JLabel lblMg;
	private JLabel quantityLbl;
	private JTextField quantityTextField;
	private JPanel addMedButton;
	private JLabel addMedicineBtnLbl;
	private JPanel addViaFilePanel;
	private JPanel csvTemplateButton;
	private JLabel csvTemplateLbl;
	private JPanel csvTemplateBrowseButton;
	private JPanel csvTemplateUploadButton;
	private JLabel csvBrowseLbl;
	private JLabel lblUpload;
	private JPanel resetBtn;
	private JLabel resetLbl;

	public InventoryPanel(UIService uiService, JProgressBar progressBar) {
		this.uiService = uiService;
		this.progressBar = progressBar;
		initComponents();
		initEvents();
	}

	private void initComponents() {
		setBackground(Color.decode("#ffffff"));
		setLayout(new BorderLayout(0, 0));
		setSize(1400, 1200);

		inventoryHeadingPanel = new JPanel();
		inventoryHeadingPanel.setBorder(new LineBorder(Color.decode("#bfbfbf")));
		inventoryHeadingPanel.setBackground(Color.decode("#4d94ff"));
		inventoryHeadingPanel.setPreferredSize(new Dimension(70, 50));
		add(inventoryHeadingPanel, BorderLayout.NORTH);
		inventoryHeadingPanel.setLayout(new BorderLayout(0, 0));

		inventoryHeadingTextContainer = new JPanel();
		inventoryHeadingTextContainer.setBackground(Color.decode("#4d94ff"));
		inventoryHeadingTextContainer.setPreferredSize(new Dimension(150, 10));
		inventoryHeadingPanel.add(inventoryHeadingTextContainer, BorderLayout.WEST);
		inventoryHeadingTextContainer.setLayout(new BorderLayout(0, 0));

		inventoryTextLbl = new JLabel("Drug Inventory");
		inventoryTextLbl.setForeground(Color.decode("#ffffff"));
		inventoryTextLbl.setHorizontalTextPosition(SwingConstants.CENTER);
		inventoryTextLbl.setHorizontalAlignment(SwingConstants.CENTER);
		inventoryTextLbl.setFont(new Font("Open Sans", Font.BOLD, 16));
		inventoryHeadingTextContainer.add(inventoryTextLbl, BorderLayout.CENTER);

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

		inventoryBodyPanel = new JPanel();
		inventoryBodyPanel.setOpaque(false);
		tableContainer.add(inventoryBodyPanel, BorderLayout.CENTER);
		inventoryBodyPanel.setLayout(new BorderLayout(0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		medicineStockPanel = new JPanel();
		medicineStockPanel.setBackground(Color.decode("#ffffff"));
		examination = new JPanel();
		examination.setBackground(Color.WHITE);
		tabbedPane.addTab("Medicine Stock", medicineStockPanel);
		medicineStockPanel.setLayout(new BorderLayout(0, 0));

		searchMedicinePanel = new JPanel();
		searchMedicinePanel.setBorder(new LineBorder(Color.DARK_GRAY));
		searchMedicinePanel.setBackground(Color.WHITE);
		searchMedicinePanel.setPreferredSize(new Dimension(10, 60));
		medicineStockPanel.add(searchMedicinePanel, BorderLayout.NORTH);
		searchMedicinePanel.setLayout(null);

		medNameTextField = new JTextField();
		medNameTextField.setBorder(new LineBorder(Color.DARK_GRAY));
		medNameTextField.setPreferredSize(new Dimension(5, 64));
		medNameTextField.setBounds(121, 13, 200, 36);
		searchMedicinePanel.add(medNameTextField);
		medNameTextField.setColumns(10);

		searchLabel = new JLabel("Search");
		searchLabel.setFont(new Font("Open Sans", Font.BOLD, 14));
		searchLabel.setBounds(12, 12, 54, 36);
		searchMedicinePanel.add(searchLabel);

		name = new JLabel("Name");
		name.setFont(new Font("Open Sans", Font.BOLD, 12));
		name.setBounds(78, 22, 43, 17);
		searchMedicinePanel.add(name);

		lblComapany = new JLabel("Comapany");
		lblComapany.setFont(new Font("Open Sans", Font.BOLD, 12));
		lblComapany.setBounds(339, 22, 69, 17);
		searchMedicinePanel.add(lblComapany);

		companyTextField = new JTextField();
		companyTextField.setPreferredSize(new Dimension(5, 64));
		companyTextField.setColumns(10);
		companyTextField.setBorder(new LineBorder(Color.DARK_GRAY));
		companyTextField.setBounds(413, 13, 200, 36);
		searchMedicinePanel.add(companyTextField);

		searchButton = new JPanel();
		searchButton.setBackground(new Color(77, 148, 255));
		searchButton.setBounds(649, 13, 100, 35);
		searchMedicinePanel.add(searchButton);
		searchButton.setLayout(new BorderLayout(0, 0));

		searchBtn = new JLabel("Search");
		searchBtn.setHorizontalAlignment(SwingConstants.CENTER);
		searchBtn.setForeground(Color.WHITE);
		searchBtn.setFont(new Font("Open Sans", Font.BOLD, 12));
		searchButton.add(searchBtn, BorderLayout.CENTER);

		resetBtn = new JPanel();
		resetBtn.setBackground(new Color(77, 148, 255));
		resetBtn.setBounds(761, 13, 100, 35);
		searchMedicinePanel.add(resetBtn);
		resetBtn.setLayout(new BorderLayout(0, 0));

		resetLbl = new JLabel("Reset");
		resetLbl.setHorizontalAlignment(SwingConstants.CENTER);
		resetLbl.setForeground(Color.WHITE);
		resetLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		resetBtn.add(resetLbl, BorderLayout.CENTER);

		JPanel tablePanel = new JPanel();
		tablePanel.setOpaque(false);
		tablePanel.setBorder(new EmptyBorder(10, 25, 0, 0));
		tablePanel.setLayout(new BorderLayout(0, 0));
		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(700, 3));
		tablePanel.add(scrollPane, BorderLayout.WEST);
		medicineStockPanel.add(tablePanel, BorderLayout.WEST);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Sl no.", "Name", "Company", "Dose", "Route", "Quantity" }));
		scrollPane.setViewportView(table);

		addMedicinePanel = new JPanel();
		addMedicinePanel.setOpaque(false);
		medicineStockPanel.add(addMedicinePanel, BorderLayout.CENTER);
		addMedicinePanel.setLayout(null);

		addBodyPanel = new JPanel();
		addBodyPanel.setOpaque(false);
		addBodyPanel.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Add Medicine",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		addBodyPanel.setBounds(50, 12, 315, 322);
		addMedicinePanel.add(addBodyPanel);
		addBodyPanel.setLayout(null);

		medNameAddTextField = new JTextField();
		medNameAddTextField.setPreferredSize(new Dimension(5, 64));
		medNameAddTextField.setColumns(10);
		medNameAddTextField.setBorder(new LineBorder(Color.DARK_GRAY));
		medNameAddTextField.setBounds(103, 38, 200, 36);
		addBodyPanel.add(medNameAddTextField);

		medNameLbl = new JLabel("Name");
		medNameLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		medNameLbl.setBounds(12, 47, 86, 17);
		addBodyPanel.add(medNameLbl);

		CompanyLbl = new JLabel("Company");
		CompanyLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		CompanyLbl.setBounds(12, 95, 86, 17);
		addBodyPanel.add(CompanyLbl);

		companyAddTextField = new JTextField();
		companyAddTextField.setPreferredSize(new Dimension(5, 64));
		companyAddTextField.setColumns(10);
		companyAddTextField.setBorder(new LineBorder(Color.DARK_GRAY));
		companyAddTextField.setBounds(103, 86, 200, 36);
		addBodyPanel.add(companyAddTextField);

		doseLbl = new JLabel("Dose");
		doseLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		doseLbl.setBounds(12, 143, 86, 17);
		addBodyPanel.add(doseLbl);

		doseTextField = new JTextField();
		doseTextField.setPreferredSize(new Dimension(5, 64));
		doseTextField.setColumns(10);
		doseTextField.setBorder(new LineBorder(Color.DARK_GRAY));
		doseTextField.setBounds(103, 134, 159, 36);
		addBodyPanel.add(doseTextField);

		routeLbl = new JLabel("Route");
		routeLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		routeLbl.setBounds(12, 191, 86, 17);
		addBodyPanel.add(routeLbl);

		routetextField = new JTextField();
		routetextField.setPreferredSize(new Dimension(5, 64));
		routetextField.setColumns(10);
		routetextField.setBorder(new LineBorder(Color.DARK_GRAY));
		routetextField.setBounds(103, 182, 200, 36);
		addBodyPanel.add(routetextField);

		lblMg = new JLabel("Mg");
		lblMg.setFont(new Font("Open Sans", Font.BOLD, 12));
		lblMg.setBounds(267, 143, 36, 17);
		addBodyPanel.add(lblMg);

		quantityLbl = new JLabel("Quantity");
		quantityLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		quantityLbl.setBounds(12, 239, 86, 17);
		addBodyPanel.add(quantityLbl);

		quantityTextField = new JTextField();
		quantityTextField.setPreferredSize(new Dimension(5, 64));
		quantityTextField.setColumns(10);
		quantityTextField.setBorder(new LineBorder(Color.DARK_GRAY));
		quantityTextField.setBounds(103, 230, 200, 36);
		addBodyPanel.add(quantityTextField);

		addMedButton = new JPanel();
		addMedButton.setBackground(new Color(77, 148, 255));
		addMedButton.setBounds(203, 278, 100, 35);
		addBodyPanel.add(addMedButton);
		addMedButton.setLayout(new BorderLayout(0, 0));

		addMedicineBtnLbl = new JLabel("Add");
		addMedicineBtnLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		addMedicineBtnLbl.setForeground(Color.WHITE);
		addMedicineBtnLbl.setHorizontalAlignment(SwingConstants.CENTER);
		addMedButton.add(addMedicineBtnLbl, BorderLayout.CENTER);

		addViaFilePanel = new JPanel();
		addViaFilePanel.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Add via file",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		addViaFilePanel.setOpaque(false);
		addViaFilePanel.setBounds(50, 346, 315, 166);
		addMedicinePanel.add(addViaFilePanel);
		addViaFilePanel.setLayout(null);

		csvTemplateButton = new JPanel();
		csvTemplateButton.setBackground(new Color(77, 148, 255));
		csvTemplateButton.setBounds(12, 25, 291, 35);
		addViaFilePanel.add(csvTemplateButton);
		csvTemplateButton.setLayout(new BorderLayout(0, 0));

		csvTemplateLbl = new JLabel("CSV Template File");
		csvTemplateLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		csvTemplateLbl.setForeground(Color.WHITE);
		csvTemplateLbl.setHorizontalAlignment(SwingConstants.CENTER);
		csvTemplateButton.add(csvTemplateLbl, BorderLayout.CENTER);

		csvTemplateBrowseButton = new JPanel();
		csvTemplateBrowseButton.setBackground(new Color(77, 148, 255));
		csvTemplateBrowseButton.setBounds(12, 72, 291, 35);
		addViaFilePanel.add(csvTemplateBrowseButton);
		csvTemplateBrowseButton.setLayout(new BorderLayout(0, 0));

		csvBrowseLbl = new JLabel("Browse File");
		csvBrowseLbl.setHorizontalAlignment(SwingConstants.CENTER);
		csvBrowseLbl.setForeground(Color.WHITE);
		csvBrowseLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		csvTemplateBrowseButton.add(csvBrowseLbl, BorderLayout.CENTER);

		csvTemplateUploadButton = new JPanel();
		csvTemplateUploadButton.setBackground(new Color(77, 148, 255));
		csvTemplateUploadButton.setBounds(12, 119, 291, 35);
		addViaFilePanel.add(csvTemplateUploadButton);
		csvTemplateUploadButton.setLayout(new BorderLayout(0, 0));

		lblUpload = new JLabel("Upload");
		lblUpload.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpload.setForeground(Color.WHITE);
		lblUpload.setFont(new Font("Open Sans", Font.BOLD, 12));
		csvTemplateUploadButton.add(lblUpload, BorderLayout.CENTER);
		tabbedPane.addTab("Examination", examination);
		inventoryBodyPanel.add(tabbedPane, BorderLayout.CENTER);
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

		csvTemplateBrowseButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(Color.decode("#99c2ff"), csvTemplateBrowseButton);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(Color.decode("#4d94ff"), csvTemplateBrowseButton);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		csvTemplateUploadButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(Color.decode("#99c2ff"), csvTemplateUploadButton);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(Color.decode("#4d94ff"), csvTemplateUploadButton);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		csvTemplateButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(Color.decode("#99c2ff"), csvTemplateButton);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(Color.decode("#4d94ff"), csvTemplateButton);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		addMedButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(Color.decode("#99c2ff"), addMedButton);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(Color.decode("#4d94ff"), addMedButton);
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
