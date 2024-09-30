package egovframework.msa.minuk.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import egovframework.msa.minuk.service.MailService;

@RestController
@RequestMapping("/mailService")
public class MailControll {
	
	private MailService mailService;
	
	
}
