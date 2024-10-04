package egovframework.msa.minuk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@DynamicInsert
@Entity
@Table(name = "mail_home_table")
@Getter
public class MailHome {
	@Id
	@Column(name = "userID")
	String userID;
	@Column(name = "newMail")
	boolean newMail;
	@Column(name = "sendMailCnt")
	int sendMailCnt;
	@Column(name = "receiveMailCnt")
	int receiveMailCnt;
	
	@Builder
	public MailHome(String userID, boolean newMail, int sendMailCnt, int receiveMailCnt) {
		this.userID = userID;
		this.newMail = newMail;
		this.sendMailCnt = sendMailCnt;
		this.receiveMailCnt = receiveMailCnt;
	}
	
	public boolean getNewMail() {
		return newMail;
	}
}
