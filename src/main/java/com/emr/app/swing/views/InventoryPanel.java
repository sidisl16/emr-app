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
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.JTableHeader;

import com.emr.app.dtos.ExaminationDto;
import com.emr.app.dtos.MedicineInventoryDto;
import com.emr.app.swing.service.UIService;
import com.emr.app.utilities.InputValidator;
import com.google.common.base.Strings;

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
	private JTable medicinetable;
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
	private JPanel examinationAddHeaderpanel;
	private JTextField examNameTextField;
	private JTextField examDescTextField;
	private JPanel addExamBtn;
	private JLabel addExamLbl;
	private JScrollPane examScrollPane;
	private JTable examTable;
	private JLabel examNamelbl;
	private JLabel lblDescription;
	private JTableHeader examtableHeader;
	private JPanel tablePanel;
	private JTableHeader medtableHeader;
	private JLabel updateInfoLbl;
	private UneditableTableDataModel medicinceTableModel;
	private List<MedicineInventoryDto> medicinceInventoryDtoList;
	private List<ExaminationDto> examinationList;
	private MedicineInventoryDto medicineInventoryDto;
	private JPanel clearBtn;
	private JLabel clearMedicineBtnLbl;
	private UneditableTableDataModel examTableModel;

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

		tablePanel = new JPanel();
		tablePanel.setOpaque(false);
		tablePanel.setBorder(new EmptyBorder(10, 25, 0, 0));
		tablePanel.setLayout(new BorderLayout(0, 0));
		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(750, 3));
		tablePanel.add(scrollPane, BorderLayout.WEST);
		medicineStockPanel.add(tablePanel, BorderLayout.WEST);

		medicinetable = new JTable();
		medicinceTableModel = new UneditableTableDataModel(new Object[][] {},
				new String[] { "Sl no.", "Name", "Company", "Dose", "Route", "Quantity" });
		medicinetable.setModel(medicinceTableModel);
		medtableHeader = medicinetable.getTableHeader();
		medtableHeader.setPreferredSize(new Dimension(100, 32));
		medicinetable.setRowHeight(32);
		scrollPane.setViewportView(medicinetable);

		addMedicinePanel = new JPanel();
		addMedicinePanel.setOpaque(false);
		medicineStockPanel.add(addMedicinePanel, BorderLayout.CENTER);
		addMedicinePanel.setLayout(null);

		addBodyPanel = new JPanel();
		addBodyPanel.setOpaque(false);
		addBodyPanel.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64)), "Add/Update Medicine",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
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

		updateInfoLbl = new JLabel("To update any medicine, double click on table row");
		updateInfoLbl.setFont(new Font("Open Sans", Font.BOLD, 8));
		updateInfoLbl.setBounds(12, 18, 291, 17);
		addBodyPanel.add(updateInfoLbl);

		clearBtn = new JPanel();
		clearBtn.setBackground(new Color(77, 148, 255));
		clearBtn.setBounds(12, 278, 100, 35);
		addBodyPanel.add(clearBtn);
		clearBtn.setLayout(new BorderLayout(0, 0));

		clearMedicineBtnLbl = new JLabel("Clear");
		clearMedicineBtnLbl.setHorizontalAlignment(SwingConstants.CENTER);
		clearMedicineBtnLbl.setForeground(Color.WHITE);
		clearMedicineBtnLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		clearBtn.add(clearMedicineBtnLbl, BorderLayout.CENTER);

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
		examination.setLayout(new BorderLayout(0, 0));

		examinationAddHeaderpanel = new JPanel();
		examinationAddHeaderpanel.setBorder(new LineBorder(Color.DARK_GRAY));
		examinationAddHeaderpanel.setPreferredSize(new Dimension(10, 60));
		examinationAddHeaderpanel.setOpaque(false);
		examination.add(examinationAddHeaderpanel, BorderLayout.NORTH);
		examinationAddHeaderpanel.setLayout(null);

		examNameTextField = new JTextField();
		examNameTextField.setPreferredSize(new Dimension(5, 64));
		examNameTextField.setColumns(10);
		examNameTextField.setBorder(new LineBorder(Color.DARK_GRAY));
		examNameTextField.setBounds(54, 12, 200, 36);
		examinationAddHeaderpanel.add(examNameTextField);

		examNamelbl = new JLabel("Name");
		examNamelbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		examNamelbl.setBounds(12, 21, 36, 17);
		examinationAddHeaderpanel.add(examNamelbl);

		lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Open Sans", Font.BOLD, 12));
		lblDescription.setBounds(304, 21, 83, 17);
		examinationAddHeaderpanel.add(lblDescription);

		examDescTextField = new JTextField();
		examDescTextField.setPreferredSize(new Dimension(5, 64));
		examDescTextField.setColumns(10);
		examDescTextField.setBorder(new LineBorder(Color.DARK_GRAY));
		examDescTextField.setBounds(388, 12, 200, 36);
		examinationAddHeaderpanel.add(examDescTextField);

		addExamBtn = new JPanel();
		addExamBtn.setBackground(new Color(77, 148, 255));
		addExamBtn.setBounds(623, 13, 100, 35);
		examinationAddHeaderpanel.add(addExamBtn);
		addExamBtn.setLayout(new BorderLayout(0, 0));

		addExamLbl = new JLabel("Add");
		addExamLbl.setForeground(Color.WHITE);
		addExamLbl.setHorizontalAlignment(SwingConstants.CENTER);
		addExamLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		addExamBtn.add(addExamLbl, BorderLayout.CENTER);

		examScrollPane = new JScrollPane();
		examination.add(examScrollPane, BorderLayout.CENTER);

		examTable = new JTable();
		examTableModel = new UneditableTableDataModel(new Object[][] {},
				new String[] { "Sl. no.", "Examination Name", "Description" });
		examTable.setModel(examTableModel);
		examtableHeader = examTable.getTableHeader();
		examtableHeader.setPreferredSize(new Dimension(100, 32));
		examTable.setRowHeight(32);
		examScrollPane.setViewportView(examTable);
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

				TaskWorker.invoke(progressBar, () -> {
					search();
					return null;
				}, new Callback() {

					@Override
					public void onSucess(Object response) {
					}

					@Override
					public void onFailure() {
						JOptionPane.showMessageDialog(getParent(), "Internal Error.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				});

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

				TaskWorker.invoke(progressBar, () -> {
					loadAllMedicine();
					clearAll();
					return null;
				}, new Callback() {

					@Override
					public void onSucess(Object response) {
					}

					@Override
					public void onFailure() {
						JOptionPane.showMessageDialog(getParent(), "Internal Error.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				});

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
				TaskWorker.invoke(progressBar, () -> {
					addMedicine();
					loadAllMedicine();
					clearAll();
					return null;
				}, new Callback() {

					@Override
					public void onSucess(Object response) {
						JOptionPane.showMessageDialog(getParent(), "Data saved successfully.", "Info",
								JOptionPane.INFORMATION_MESSAGE);
					}

					@Override
					public void onFailure() {
						JOptionPane.showMessageDialog(getParent(), "Internal Error.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				});
			}
		});

		addExamBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(Color.decode("#99c2ff"), addExamBtn);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(Color.decode("#4d94ff"), addExamBtn);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				TaskWorker.invoke(progressBar, () -> {
					addExamination();
					loadAllExamination();
					clearAll();
					return null;
				}, new Callback() {

					@Override
					public void onSucess(Object response) {
						JOptionPane.showMessageDialog(getParent(), "Data saved successfully.", "Info",
								JOptionPane.INFORMATION_MESSAGE);
					}

					@Override
					public void onFailure() {
						JOptionPane.showMessageDialog(getParent(), "Internal Error.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				});

			}
		});

		clearBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				changeColor(Color.decode("#99c2ff"), clearBtn);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				changeColor(Color.decode("#4d94ff"), clearBtn);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				clearAll();
			}
		});

		medicinetable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					medicineInventoryDto = medicinceInventoryDtoList.get(medicinetable.getSelectedRow());
					setMedicinevalues();
					addMedicineBtnLbl.setText("Update");
				}
			}
		});
		
		medicinetable.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					int option = JOptionPane.showConfirmDialog(getParent(),
							"Are you sure to delete the selected record in tabel?", "Confirmation",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
					if (option == 0) {
						uiService.deleteMedicineById(
								medicinceInventoryDtoList.get(medicinetable.getSelectedRow()).getMedicineInventoryId());
						loadAllMedicine();
					}
				}
			}
		});

		examTable.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					int option = JOptionPane.showConfirmDialog(getParent(),
							"Are you sure to delete the selected record in tabel?", "Confirmation",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
					if (option == 0) {
						uiService.deleteExamination(examinationList.get(examTable.getSelectedRow()).getExaminationId());
						loadAllExamination();
					}
				}
			}
		});

	}

	private void search() {
		String medName = medNameTextField.getText();
		String company = companyTextField.getText();

		if (medicinceTableModel.getRowCount() > 0) {
			medicinceTableModel.setRowCount(0);
		}
		medicinceTableModel.fireTableDataChanged();
		medicinceInventoryDtoList = uiService.searchMedicine(medName, company);
		if (medicinceInventoryDtoList != null && !medicinceInventoryDtoList.isEmpty()) {
			medicinceInventoryDtoList.stream().forEach(medicine -> {
				medicinceTableModel.addRow(
						new Object[] { medicinceTableModel.getRowCount() + 1, medicine.getName(), medicine.getCompany(),
								medicine.getDose(), medicine.getRoute(), medicine.getAvailableQuantity() });
			});
		}
		medicinceTableModel.fireTableDataChanged();
	}

	private void clearAll() {
		medicineInventoryDto = null;
		addMedicineBtnLbl.setText("Add");
		for (Component component : addBodyPanel.getComponents()) {
			if (component instanceof JTextField) {
				((JTextField) component).setText("");
			}
		}

		for (Component component : searchMedicinePanel.getComponents()) {
			if (component instanceof JTextField) {
				((JTextField) component).setText("");
			}
		}
	}

	private void setMedicinevalues() {
		medNameAddTextField.setText(medicineInventoryDto.getName());
		companyAddTextField.setText(medicineInventoryDto.getCompany());
		doseTextField.setText(String.valueOf(medicineInventoryDto.getDose()));
		routetextField.setText(medicineInventoryDto.getRoute());
		quantityTextField.setText(String.valueOf(medicineInventoryDto.getAvailableQuantity()));
	}

	private void addMedicine() throws Exception {

		String name = medNameAddTextField.getText();
		String company = companyAddTextField.getText();
		String dose = doseTextField.getText();
		String route = routetextField.getText();
		String quantity = quantityTextField.getText();

		if (validateMedicineData(name, company, dose, route, quantity)) {
			if (medicineInventoryDto != null) {
				int option = JOptionPane.showConfirmDialog(getParent(),
						"Are you sure to update the selected record in tabel? If no then please use Clear button to add new record.",
						"Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				if (option == 0) {
					uiService.storeMedicine(medicineInventoryDto);
				}
			} else {
				uiService.storeMedicine(new MedicineInventoryDto(name, Float.parseFloat(dose), route, company,
						Integer.parseInt(quantity)));
			}
		}
	}

	private void addExamination() {
		String examName = examNameTextField.getText();
		String desc = examDescTextField.getText();

		if (!Strings.isNullOrEmpty(examName)) {
			uiService.storeExamination(new ExaminationDto(examName, desc));
		} else {
			JOptionPane.showMessageDialog(getParent(), "Please fill medicine examination correctly.", "Warning",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	private boolean validateMedicineData(String name, String company, String dose, String route, String quantity) {
		if (InputValidator.validateString(name) || InputValidator.validateString(company)
				|| InputValidator.validateString(route) || InputValidator.validateString(dose)
				|| !InputValidator.isFloat(dose) || InputValidator.validateString(quantity)
				|| !InputValidator.isInteger(quantity)) {
			JOptionPane.showMessageDialog(getParent(), "Please fill medicine data correctly.", "Warning",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	private void loadAllMedicine() {
		if (medicinceTableModel.getRowCount() > 0) {
			medicinceTableModel.setRowCount(0);
		}
		medicinceTableModel.fireTableDataChanged();
		medicinceInventoryDtoList = uiService.getAllMedicine();
		if (medicinceInventoryDtoList != null && !medicinceInventoryDtoList.isEmpty()) {
			medicinceInventoryDtoList.stream().forEach(medicine -> {
				medicinceTableModel.addRow(
						new Object[] { medicinceTableModel.getRowCount() + 1, medicine.getName(), medicine.getCompany(),
								medicine.getDose(), medicine.getRoute(), medicine.getAvailableQuantity() });
			});
		}
		medicinceTableModel.fireTableDataChanged();
	}

	private void loadAllExamination() {

		if (examTableModel.getRowCount() > 0) {
			examTableModel.setRowCount(0);
		}
		examTableModel.fireTableDataChanged();
		examinationList = uiService.getAllExamination();
		if (examinationList != null && !examinationList.isEmpty()) {
			examinationList.stream().forEach(examination -> {
				examTableModel.addRow(new Object[] { examTableModel.getRowCount() + 1, examination.getName(),
						examination.getDescription() });
			});
		}
		examTableModel.fireTableDataChanged();

	}

	private void changeColor(Color color, Component component) {
		component.setBackground(color);
	}

	@Override
	public void execute() {
		clearAll();
		loadAllMedicine();
		loadAllExamination();
	}

	@Override
	public void execute(Object... dtos) {
	}
}
