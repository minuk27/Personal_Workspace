package egovframework.msa.minuk.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import egovframework.msa.minuk.messageDto.MailBoxId;

public interface SendMailBoxRepository extends JpaRepository<SendMailBox, MailBoxId>  {
	Page<SendMailBox> findByUserID(String userID, Pageable pageable);
	int countByUserID(String userID);
}
