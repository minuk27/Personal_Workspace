package egovframework.msa.minuk.domain;

import javax.persistence.*;

import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

@NoArgsConstructor
@DynamicInsert
@Entity
@Table(name = "user_join_table")
public class User {
	@Id
	@Column(name = "user_id")
	private String userID;
	@Column(name = "user_pw")
	private String password;
	@Column(name = "user_name")
	private String name;
	
	@Builder
	public User(String name, String id, String password) {
		this.name = name;
		this.userID = id;
		this.password = password;
	}
	
	public String getID() {
		return this.userID;
	}
	
	public String getPasswrod() {
		return this.password;
	}
}
