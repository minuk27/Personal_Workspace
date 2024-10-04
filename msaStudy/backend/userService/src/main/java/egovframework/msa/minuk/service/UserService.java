package egovframework.msa.minuk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import egovframework.msa.minuk.common.LoginStatus;
import egovframework.msa.minuk.config.JwtTokenProvider;
import egovframework.msa.minuk.domain.User;
import egovframework.msa.minuk.domain.UserAlarm;
import egovframework.msa.minuk.domain.UserAlarmRepository;
import egovframework.msa.minuk.domain.UserMailHome;
import egovframework.msa.minuk.domain.UserMailHomeRepository;
import egovframework.msa.minuk.domain.UserRepository;
import egovframework.msa.minuk.userDto.JoinRequest;
import egovframework.msa.minuk.userDto.LoginRequest;
import egovframework.msa.minuk.userDto.TokenResponse;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserMailHomeRepository userMailHomeRepository;
	@Autowired
	private UserAlarmRepository userAlarmRepository;
	
	private final JwtTokenProvider tokenProvider;
	
	public LoginStatus loginCheck(@RequestBody LoginRequest loginRequest) {
		
		String id = loginRequest.getUserID();
		String password = loginRequest.getPassword();
		
		User user = userRepository.findByUserID(id);
		
		if(user == null) {
			return LoginStatus.NO_USER;
		}
		
		else if(!user.getPasswrod().equals(password)) {
			return LoginStatus.WRONG_PASSWORD;
		}
		
		return LoginStatus.SUCCESS;
	}
	
	public String loginToken(@RequestBody LoginRequest loginRequest) {
		return tokenProvider.createJWT(loginRequest);
	}
	
	public void reissueToken(String refreshToken) {
		
	}
	
	public boolean joinCheck(@RequestBody JoinRequest joinRequest) {
		boolean check = true;
		String name = joinRequest.getName();
		String id = joinRequest.getUserID();
		String password = joinRequest.getPassword();
		
		System.out.println("회원가입 서비스");
		
		if(userRepository.findByUserID(id) != null) {
			System.out.println("실패");
			check = false;
			return check;
		}
		
		System.out.println("회원가입 가능");
		User newUser = User.builder().name(name).id(id).password(password).build();
		userRepository.save(newUser);
		
		UserMailHome newUserMailHome = UserMailHome.builder().userID(id).newMail(false).sendMailCnt(0).receiveMailCnt(0).build();
		userMailHomeRepository.save(newUserMailHome);
		System.out.println("회원가입 성공");
		return check;
	}
	
	
	public boolean userJoinState(String id) {
		 return userRepository.findById(id) == null ? false : true;
	}

	public boolean userSendAlarm(String userId, String type, String message) {
		UserAlarm newAlarm = UserAlarm.builder().userID(userId).alarmType(type).message(message).build();
		userAlarmRepository.save(newAlarm);
		return true;
	}
	
	//알림 로그인시 확인 후 전송과 전송 후 삭제 구현
}
