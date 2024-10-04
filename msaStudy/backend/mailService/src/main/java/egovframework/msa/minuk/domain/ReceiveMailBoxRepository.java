package egovframework.msa.minuk.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import egovframework.msa.minuk.messageDto.MailBoxId;

public interface ReceiveMailBoxRepository extends JpaRepository<ReceiveMailBox, MailBoxId> {
	List<ReceiveMailBox> findByUserID(String userID);
	int countByUserID(String userID);
}
