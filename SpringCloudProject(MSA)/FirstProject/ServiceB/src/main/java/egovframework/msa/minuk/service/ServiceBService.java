package egovframework.msa.minuk.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceBService {
	private StringBuilder message = new StringBuilder();
	
	public String getServiceB() {
		String returnStr = null;
		if (this.message.length() != 0) {
            returnStr = this.message.toString().trim(); 
        }
		else
			returnStr = "This is Service B";
		
		return returnStr;		
	}
	
	public String getServiceBMessage(String message) {
		this.message.append(message).append("\n");
		
		return "Send of message a B";
	}
}