package egovframework.msa.minuk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import egovframework.msa.minuk.common.LoginStatus;
import egovframework.msa.minuk.config.JwtTokenProvider;
import egovframework.msa.minuk.domain.User;
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
		System.out.println("회원가입 성공");
		return check;
	}
}
