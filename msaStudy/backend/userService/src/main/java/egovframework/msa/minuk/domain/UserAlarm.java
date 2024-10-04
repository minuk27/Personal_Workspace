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
@Table(name = "user_mailalarm_table")
@Getter
public class UserAlarm {
	@Id
	@Column(name = "userID")
	private String userID;
	@Column(name = "alarmType")
	private String alarmType;
	@Column(name = "message")
	private String message;
	
	@Builder
	public UserAlarm(String userID, String alarmType, String message) {
		this.userID = userID;
		this.alarmType = alarmType;
		this.message = message;
	}
}
