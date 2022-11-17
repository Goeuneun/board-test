//package kr.web.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	
//	// 의존성주입해줘야됨 아직안됨
//	
//	@Bean
//	public BCryptPasswordEncoder bCryptPasswordEncoder() {
//		return new BCryptPasswordEncoder(); // <- 비밀번호 암호화를 해준다.
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// 인터셉터로 요청을 안전하게 보호하는 방법을 설정하기 위한 오버라이딩이다.
//		super.configure(http); // 모든 url 막고있음
//		
//		http.csrf().disable();// <-사이트간 위조 방지 disable
//
//		http.authorizeRequests().	//인가요청이 오면
//		antMatchers("/api/diary/**").authenticated()// api/diary/ 로 시작하는 url 은 인증 필요
//				.anyRequest().permitAll() // 그외에는 다 허용
//				.and()
//				.formLogin()// 로그인이 필요하면
//				.loginPage("/login");// loginForm 뷰로 이동.
//		
//		//중복 로그인
//        http.sessionManagement()
//                .maximumSessions(1) //세션 최대 허용 수 
//                .maxSessionsPreventsLogin(false); // false이면 중복 로그인하면 이전 로그인이 풀린다.
//	}
//	
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		// super.configure(web); // 아무런 작업을 하지 않음
//
//		// 스프링 시큐리티의 필터 연결을 설정하기 위한 오버라이딩이다.
//		// 예외가 웹접근 URL를 설정한다.
//		// ACL(Access Control List - 접근 제어 목록)의 예외 URL을 설정
//	}
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// 사용자 세부 서비스를 설정하기 위한 오버라이딩이다.
//		super.configure(auth);
//		// auth.userDetailsService(principalDetailService).passwordEncoder(bCryptPasswordEncoder());
//	}
//}