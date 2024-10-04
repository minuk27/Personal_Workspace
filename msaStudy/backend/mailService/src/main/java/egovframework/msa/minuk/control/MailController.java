package egovframework.msa.minuk.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import egovframework.msa.minuk.common.DirectionStatus;
import egovframework.msa.minuk.domain.SendMailBox;
import egovframework.msa.minuk.messageDto.MailHomeDto;
import egovframework.msa.minuk.messageDto.MailListDto;
import egovframework.msa.minuk.messageDto.ReadMailDto;
import egovframework.msa.minuk.messageDto.SendMailDto;
import egovframework.msa.minuk.service.MailService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/mailService")
@RequiredArgsConstructor
public class MailController {
	
	private final MailService mailService;
	private DirectionStatus dirStatus;
	
	@GetMapping("/mailHome")
	public ResponseEntity<MailHomeDto> mailHome(@RequestHeader("X-User-Id") String userID){
		System.out.println("컨트롤 함수 실행");
		return ResponseEntity.ok(mailService.homeData(userID));
	}
	
	@GetMapping("/sendMailBox")
	public Page<SendMailBox> sendMailBox(@RequestHeader("X-Custom-Header") String customHeader, @RequestHeader("X-User-Id") String userID,
			@RequestParam int page, @RequestParam int size){
		//List<MailListDto> mailListData = new ArrayList<>();
		//mailListData = mailService.sendmailList(userID);
		//return ResponseEntity.ok(mailListData);
		return mailService.sendmailList(userID, page, size);
	}
	
	@PostMapping("/sendMailBox/readMail")
	public ResponseEntity<ReadMailDto> sendMailRead(@RequestHeader("X-Custom-Header") String customHeader, @RequestHeader("X-User-Id") String userID, @RequestBody int index){
		ReadMailDto mailSendData = new ReadMailDto();
		mailSendData = mailService.mailData(dirStatus.SEND, userID, index);
		return ResponseEntity.ok(mailSendData);
	}
	
	@GetMapping("/receiveMailBox")
	public ResponseEntity<List<MailListDto>> receiveMailBox(@RequestHeader("X-Custom-Header") String customHeader, @RequestHeader("X-User-Id") String userID){
		List<MailListDto> mailListData = new ArrayList<>();
		mailListData = mailService.receiveMailList(userID);
		return ResponseEntity.ok(mailListData);
	}
	
	@PostMapping("/receiveMailBox/readMail")
	public ResponseEntity<ReadMailDto> receiveMailRead(@RequestHeader("X-Custom-Header") String customHeader, @RequestHeader("X-User-Id") String userID, @RequestBody int index){
		ReadMailDto mailSendData = new ReadMailDto();
		mailSendData = mailService.mailData(dirStatus.RECEIVE, userID, index);
		return ResponseEntity.ok(mailSendData);
	}
	
	@PostMapping("/mailSend")
	public ResponseEntity<Void> mailSend(@RequestHeader("X-Custom-Header") String customHeader, @RequestHeader("X-User-Id") String userID, @RequestBody SendMailDto sendMailData){
		if(mailService.mailSend(sendMailData, userID)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		
	}
}
