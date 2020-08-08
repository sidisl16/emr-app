package com.emr.app.swing.views;

import javax.swing.table.DefaultTableModel;

public class CheckBoxTableDataModel extends DefaultTableModel {

	public CheckBoxTableDataModel() {

	}

	public CheckBoxTableDataModel(Object[][] data, Object[] columnNames) {
		super(data, columnNames);
	}

	private static final long serialVersionUID = 1L;

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex > 3) {
			return Boolean.class;
		}
		return super.getColumnClass(columnIndex);
	}

}
