package egovframework.msa.minuk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.msa.minuk.domain.MailRepository;



@Service
public class MailService {
	
	@Autowired
	private MailRepository mailRepository;
	
	public void sendMail() {
		
	}
	
	public void readMail() {
		
	}
	
	public void watchMailBox() {
		
	}
}
