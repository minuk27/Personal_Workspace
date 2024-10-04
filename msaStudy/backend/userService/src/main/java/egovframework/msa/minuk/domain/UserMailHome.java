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
public class UserMailHome {
	@Id
	@Column(name = "userID")
	private String userID;
	@Column(name = "newMail")
	private boolean newMail;
	@Column(name = "sendMailCnt")
	private int sendMailCnt;
	@Column(name = "receiveMailCnt")
	private int receiveMailCnt;
	
	@Builder
	public UserMailHome(String userID, boolean newMail, int sendMailCnt, int receiveMailCnt) {
		this.userID = userID;
		this.newMail = newMail;
		this.sendMailCnt = sendMailCnt;
		this.receiveMailCnt = receiveMailCnt;
	}
}
