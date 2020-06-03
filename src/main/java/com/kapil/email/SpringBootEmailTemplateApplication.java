package com.kapil.email;

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

@SpringBootApplication
public class SpringBootEmailTemplateApplication implements ApplicationRunner {

	private static Logger log = LoggerFactory.getLogger(SpringBootEmailTemplateApplication.class);

	@Autowired
	private EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmailTemplateApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		log.info("Sending Email with Thymeleaf HTML Template Example");

		Mail mail = new Mail();
		mail.setFrom("test@gmail.com");
		mail.setTo("sendTo@gmail.com");
		mail.setSubject("Sending Email with Thymeleaf HTML Template Example");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("name", "Developer!");
		model.put("location", "United States");
		model.put("sign", "Java Developer");
		mail.setModel(model);

		emailService.sendSimpleMessage(mail);
	}

}
