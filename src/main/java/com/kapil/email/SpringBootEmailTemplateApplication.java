package com.kapil.email;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.kapil.email.service.EmailService;
import com.kapil.email.service.EmailServiceFreeMaker;

@SpringBootApplication
public class SpringBootEmailTemplateApplication implements ApplicationRunner {

	private static Logger log = LoggerFactory.getLogger(SpringBootEmailTemplateApplication.class);

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private EmailServiceFreeMaker emailServiceFreeMaker;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmailTemplateApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		log.info("Sending Email with Thymeleaf HTML Template Example");

		Mail mail = new Mail();
		mail.setFrom("testFrom@email.com");
		mail.setTo("testTo@email.com");
		mail.setSubject("Sending Email with Thymeleaf HTML Template Example");
		
		Map<String, Object> model = new HashMap<String, Object>();
//		Map model =new HashMap<>();
		model.put("today", LocalDate.now());
		model.put("fileName", "Test File");
		model.put("startTime", LocalDate.now());
		model.put("endTime", LocalDate.now());
		model.put("totalRecords", 100);
		model.put("totalSuccess", 90);
		model.put("totalFailed", 90);
		model.put("totalSkipped", 10);
		model.put("status", "OOB");
		mail.setModel(model);

		emailServiceFreeMaker.sendSimpleMessage(mail);
	}

}
