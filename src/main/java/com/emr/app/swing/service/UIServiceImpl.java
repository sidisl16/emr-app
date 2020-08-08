package com.emr.app.swing.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.emr.app.dtos.PatientDto;
import com.emr.app.swing.views.HomeScreen;

@Service
public class UIServiceImpl implements UIService {

	private static final Logger logger = Logger.getLogger(UIServiceImpl.class.getName());

	@Override
	public void startUIComponents() {
		HomeScreen.startUIComponent(this);
	}

	@Override
	public List<PatientDto> getAllActivePatients() {
		logger.log(Level.INFO, "get all appointments");
		List<PatientDto> list = new ArrayList<>(); 
		list.add(new PatientDto());
		return list;
	}

}
