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
//	// ��������������ߵ� �����ȵ�
//	
//	@Bean
//	public BCryptPasswordEncoder bCryptPasswordEncoder() {
//		return new BCryptPasswordEncoder(); // <- ��й�ȣ ��ȣȭ�� ���ش�.
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// ���ͼ��ͷ� ��û�� �����ϰ� ��ȣ�ϴ� ����� �����ϱ� ���� �������̵��̴�.
//		super.configure(http); // ��� url ��������
//		
//		http.csrf().disable();// <-����Ʈ�� ���� ���� disable
//
//		http.authorizeRequests().	//�ΰ���û�� ����
//		antMatchers("/api/diary/**").authenticated()// api/diary/ �� �����ϴ� url �� ���� �ʿ�
//				.anyRequest().permitAll() // �׿ܿ��� �� ���
//				.and()
//				.formLogin()// �α����� �ʿ��ϸ�
//				.loginPage("/login");// loginForm ��� �̵�.
//		
//		//�ߺ� �α���
//        http.sessionManagement()
//                .maximumSessions(1) //���� �ִ� ��� �� 
//                .maxSessionsPreventsLogin(false); // false�̸� �ߺ� �α����ϸ� ���� �α����� Ǯ����.
//	}
//	
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		// super.configure(web); // �ƹ��� �۾��� ���� ����
//
//		// ������ ��ť��Ƽ�� ���� ������ �����ϱ� ���� �������̵��̴�.
//		// ���ܰ� ������ URL�� �����Ѵ�.
//		// ACL(Access Control List - ���� ���� ���)�� ���� URL�� ����
//	}
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// ����� ���� ���񽺸� �����ϱ� ���� �������̵��̴�.
//		super.configure(auth);
//		// auth.userDetailsService(principalDetailService).passwordEncoder(bCryptPasswordEncoder());
//	}
//}