package com.emr.app.swing.views;

import javax.swing.table.DefaultTableModel;

public class UneditableTableDataModel extends DefaultTableModel {

	public UneditableTableDataModel() {
		
	}
	
	public UneditableTableDataModel(Object[][] data, Object[] columnNames) {
		super(data, columnNames);
	}
	
	private static final long serialVersionUID = 1L;

	@Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

}
