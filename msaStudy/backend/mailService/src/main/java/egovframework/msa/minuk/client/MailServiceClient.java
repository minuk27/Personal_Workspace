package egovframework.msa.minuk.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface MailServiceClient {
	
	@GetMapping("/userService/LoginUserStatus/{userID}")
	boolean getJoinUserStatus(@PathVariable("userID") String userID);
	
	@GetMapping("/userService/UserSendAlarm/{userID}/{alarmType}/{message}")
	boolean setUserAlarm(@PathVariable("userID") String userID);
}
