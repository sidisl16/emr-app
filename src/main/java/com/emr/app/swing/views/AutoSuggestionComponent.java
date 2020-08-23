package com.emr.app.swing.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.emr.app.swing.service.UIService;
import com.google.common.base.Strings;

public class AutoSuggestionComponent extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JLabel searchTextLbl;
	private DefaultListModel<String> listModel;
	private JList<String> list;
	private JScrollPane scrollPane;
	private DefaultTableModel defaultTableModel;
	private UIService uiService;
	private boolean isMedicineAdvice;

	public AutoSuggestionComponent(UIService uiService) {
		this.uiService = uiService;
		setBorder(new LineBorder(Color.DARK_GRAY));

		setLayout(null);
		searchTextLbl = new JLabel("Search");
		searchTextLbl.setFont(new Font("Open Sans", Font.BOLD, 12));
		searchTextLbl.setBounds(12, 18, 50, 28);
		add(searchTextLbl);

		textField = new JTextField();
		textField.setBorder(new LineBorder(Color.DARK_GRAY));
		textField.setFont(new Font("Open Sans", Font.PLAIN, 12));
		textField.setBounds(68, 19, 410, 28);
		add(textField);
		textField.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 49, 410, 155);
		add(scrollPane);

		listModel = new DefaultListModel<>();
		list = new JList<>(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		scrollPane.setVisible(false);
		initEvents();

	}

	public void setTable(DefaultTableModel defaultTableModel) {
		isMedicineAdvice = defaultTableModel.getColumnCount() > 2;
		this.defaultTableModel = defaultTableModel;
	}

	public void setLabelText(String label) {
		searchTextLbl.setText(label);
	}

	private void initEvents() {
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				String prefix = textField.getText();
				if (Strings.isNullOrEmpty(prefix)) {
					listModel.clear();
					scrollPane.setVisible(false);
				} else {
					listModel.clear();
					if (isMedicineAdvice) {
						setTextList(uiService.searchMedicineByPrefix(prefix));
					} else {
						setTextList(uiService.searchExaminationByPrefix(prefix));
					}
					if (!listModel.isEmpty()) {
						scrollPane.setVisible(true);
					}
				}

				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER && !Strings.isNullOrEmpty(prefix) && defaultTableModel != null) {
					if (isMedicineAdvice) {
						defaultTableModel.addRow(new Object[] { defaultTableModel.getRowCount() + 1, prefix, "0", "",
								false, false, false, false, false, false, false, false });
					} else {
						defaultTableModel.addRow(new Object[] { defaultTableModel.getRowCount() + 1, prefix });
					}

				}

			}
		});

		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				String selectedText = list.getSelectedValue();
				if (!Strings.isNullOrEmpty(selectedText)) {
					textField.setText(selectedText);
				}
			}
		});

		list.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String selectedText = list.getSelectedValue();
				if (e.getKeyCode() == KeyEvent.VK_ENTER && !Strings.isNullOrEmpty(selectedText)
						&& defaultTableModel != null) {
					if (isMedicineAdvice) {
						defaultTableModel.addRow(new Object[] { defaultTableModel.getRowCount() + 1, selectedText, "0",
								"", false, false, false, false, false, false, false, false });
					} else {
						defaultTableModel.addRow(new Object[] { defaultTableModel.getRowCount() + 1, selectedText });
					}
				}
			}
		});

		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String selectedText = list.getSelectedValue();
				if (e.getClickCount() == 2) {
					if (isMedicineAdvice) {
						defaultTableModel.addRow(new Object[] { defaultTableModel.getRowCount() + 1, selectedText, "0",
								"", false, false, false, false, false, false, false, false });
					} else {
						defaultTableModel.addRow(new Object[] { defaultTableModel.getRowCount() + 1, selectedText });
					}
				}
			}
		});

	}

	private void setTextList(Set<String> strlist) {
		strlist.stream().forEach(string -> listModel.addElement(string));
	}
}
