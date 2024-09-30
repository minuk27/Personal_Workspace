package egovframework.msa.minuk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@DynamicInsert
@Entity
@Table(name = "user_message_table")
@Getter
public class Mail {
	@Column(name = "user_id")
	String user_id;
	@Column(name = "mail_count")
	int mail_count;
	@Column(name = "sender_id")
	String sender_id;
	@Column(name = "title")
	String title;
	@Column(name = "content")
	String content;
	@Column(name = "send_date")
	String send_date;
	@Column(name = "status")
	String status;
	
	@Builder
	public Mail(String user_id, int mail_count, String sender_id, String title, String content, String send_date, String status) {
		this.user_id = user_id;
		this.mail_count = mail_count;
		this.sender_id = sender_id;
		this.title = title;
		this.content = content;
		this.send_date = send_date;
		this.status = status;
	}
}
