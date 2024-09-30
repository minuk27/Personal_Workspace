package egovframework.msa.minuk.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import egovframework.msa.minuk.userDto.LoginRequest;
//import egovframework.msa.minuk.userDto.TokenResponse;

@Component
public class JwtTokenProvider {
	
	private static final String SECRET_KEY = "your_very_secure_secret_key_here_which_is_longer_than_32_bytes"; //비밀키
	private final static SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    
    // JWT 토큰 생성
    public String createJWT(@RequestBody LoginRequest loginRequest) {
    	long nowMillis = System.currentTimeMillis();
        Date now = new Date(System.currentTimeMillis());

        // JWT를 생성하는 부분
        return Jwts.builder()
                .claim("userId", loginRequest.getUserID()) // private claim
                .claim("token-type", "acess-token") // private claim
                .setIssuedAt(now) // 발행 시간 설정
                .setExpiration(new Date(nowMillis + 360000)) // 만료 시간 설정
                .signWith(key) // 서명 설정
                .compact(); // JWT 문자열로 변환
    	
    }
    
    public String encodeBase64SecretKey(String secretKey) {
        return Encoders.BASE64.encode(secretKey.getBytes(StandardCharsets.UTF_8));
    }
}
