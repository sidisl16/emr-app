package com.emr.app.swing.service;

import org.springframework.stereotype.Service;

import com.emr.app.swing.views.HomeScreen;

@Service
public class UIServiceImpl implements UIService {

	@Override
	public void startUIComponents() {
		HomeScreen.startUIComponent();
	}

}
