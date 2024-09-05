package egovframework.msa.minuk.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceAService {
	private StringBuilder message = new StringBuilder();
	
	public String getServiceA() {
		String returnStr = null;
		if (this.message.length() != 0) {
            returnStr = this.message.toString().trim(); 
        }
		else
			returnStr = "This is Service A";
		
		return returnStr;		
	}
	
	public String getServiceAMessage(String message) {
		this.message.append(message).append("\n");
		
		return "Send of message a A";
	}
}