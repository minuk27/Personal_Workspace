package egovframework.msa.minuk.config;

/*import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity*/
public class SecurityConfig {
	
	/*@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.cors().and()  // CORS 허용
			.csrf().disable() // CSRF 보호 비활성화
        	.formLogin().disable() // 기본 로그인 폼 비활성화
        	.httpBasic().disable() // HTTP 기본 인증 비활성화
        	.authorizeRequests()
        	.antMatchers("/userService/Signin").permitAll() // /userService/Login 경로는 인증 없이 접근 허용
        	.antMatchers("/userService/Signup").permitAll()  // /userService/Join 경로는 인증 없이 접근 허용
        	.anyRequest().authenticated();  // 나머지 모든 요청은 인증 필요
		return http.build();
	}*/
}