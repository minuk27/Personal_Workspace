package egovframework.msa.minuk.messageDto;

import lombok.Getter;

@Getter
public class SendMailDto {
	String sender;
	String recipient;
	String title;
	String content;
}
