package egovframework.msa.minuk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import egovframework.msa.minuk.messageDto.MailBoxId;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@DynamicInsert
@Entity
@Table(name = "send_mail_box_table")
@Getter
@IdClass(MailBoxId.class)
public class SendMailBox {
	@Id
	@Column(name = "userID")
	String userID;
	@Id
	@Column(name = "mailIndex")
	int mailIndex;
	@Column(name = "date")
	String date;
	@Column(name = "receiverID")
	String receiverID;
	@Column(name = "title")
	String title;
	@Column(name = "content")
	String content;
	
	@Builder
	public SendMailBox(String userID, int mailIndex, String date, String receiverID, String title, String content) {
		this.userID = userID;
		this.mailIndex = mailIndex;
		this.date = date;
		this.receiverID = receiverID;
		this.title = title;
		this.content = content;
	}
}
