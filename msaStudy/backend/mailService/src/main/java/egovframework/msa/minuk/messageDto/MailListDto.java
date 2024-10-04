package egovframework.msa.minuk.messageDto;

import lombok.Getter;

@Getter
public class MailListDto {
	String userID;
	int mailIndex;
	String date;
	String from;
	String title;
	
	public MailListDto(String userID, int mailIndex, String date, String from, String title) {
		this.userID = userID;
		this.mailIndex = mailIndex;
		this.date = date;
		this.from = from;
		this.title = title;
	}
}