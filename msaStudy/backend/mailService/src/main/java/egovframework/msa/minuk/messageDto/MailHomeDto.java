package egovframework.msa.minuk.messageDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MailHomeDto {
	private String user_id;
	private boolean newMail;
	private int sendMailCnt;
	private int receiveMailCnt;
	
	public MailHomeDto(String user_id, boolean newMail, int sendMailCnt, int receiveMailCnt) {
		this.user_id = user_id;
		this.newMail = newMail;
		this.sendMailCnt = sendMailCnt;
		this.receiveMailCnt = receiveMailCnt;
	}
}
