package egovframework.msa.minuk.messageDto;

import lombok.Getter;

@Getter
public class ReadMailDto {
	String from;
	String title;
	String content;
	
	public ReadMailDto() {}
	
	public ReadMailDto(String from, String title, String content) {
		this.from = from;
		this.title = title;
		this.content = content;
	}
}
