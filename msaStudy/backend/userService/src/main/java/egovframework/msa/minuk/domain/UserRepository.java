package egovframework.msa.minuk.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{
	User findByUserID(String id);
}