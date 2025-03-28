package com.springboot.email.freemarker;

import java.util.HashMap;
import java.util.Map;

import com.springboot.email.freemarker.dto.ItemList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.email.freemarker.dto.MailRequest;
import com.springboot.email.freemarker.dto.MailResponse;
import com.springboot.email.freemarker.service.EmailService;

@SpringBootApplication
@RestController
public class SpringBootEmailFreemarkerApplication {

	@Autowired
	private EmailService service;

	@PostMapping("/sendingEmail")
	public MailResponse sendEmail(@RequestBody ItemList request) {
		Map<String, Object> model = new HashMap<>();
		model.put("totalAmount", request.getTotalAmount());
		model.put("items", request.getItems());
		return service.sendEmail(request, model);

	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmailFreemarkerApplication.class, args);
	}
}
