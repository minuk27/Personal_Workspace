package egovframework.msa.minuk.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import reactor.core.publisher.Mono;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Claims;

import java.util.Date;
import java.util.logging.Logger;

import javax.crypto.SecretKey;

@Component
public class LocalJwtAuthenticationFilter implements GlobalFilter {
	
	private static final String SECRET_KEY = "your_very_secure_secret_key_here_which_is_longer_than_32_bytes"; //비밀키
    //private static final long EXPIRATION_TIME = 86400000; // 1일 (밀리초)
    
	private static final Logger logger = Logger.getLogger(PreFilter.class.getName());
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain){
		String path = exchange.getRequest().getURI().getPath();
		if(path.equals("/userService/Signin") || path.equals("/userService/Signup")) {
			logger.info("실행");
			exchange = addHeader(exchange);
			return chain.filter(exchange);
		}
		
		String token = extractToken(exchange);
		logger.info(token);
		
		if(token == null || !validateToken(token)) {
			
			if(token == null)
				logger.info("token null");
			else
				logger.info("token worng");
			
			exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
			return exchange.getResponse().setComplete();
		}
		
		exchange = addHeader(exchange);
		return chain.filter(exchange);
	}
	
	private ServerWebExchange addHeader(ServerWebExchange exchange) {
		exchange.getRequest().mutate()
			.header("X-Custom-Header", "yourHeaderValue")
			.build();
		return exchange;
	}
	
	//요청 헤더에서 토큰 분리
	private String extractToken(ServerWebExchange exchange) {
		String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");
		if(authHeader != null && authHeader.startsWith("Bearer")) {
			return authHeader.substring(7); //'Bearer'라는 접두사를 제외한 7번째 인덱스 부터 추출하겠다는 의미
		}
		return null;
	}
	
	//토큰 검증
	private boolean validateToken(String token) {
		try {
            SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

            Claims claims = Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
	}
}
