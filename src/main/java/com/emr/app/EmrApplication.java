package com.emr.app;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.emr.app.swing.service.UIService;

@SpringBootApplication
public class EmrApplication {

	private final static Logger logger = Logger.getLogger(EmrApplication.class.getName());

	@Autowired
	private UIService uiService;

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(EmrApplication.class);
		ConfigurableApplicationContext context = builder.headless(false).run(args);
		EmrApplication app = context.getBean(EmrApplication.class);
		app.init();
	}

	private void init() {
		logger.info("Starting swing UI service");
		uiService.startUIComponents();
	}

}
