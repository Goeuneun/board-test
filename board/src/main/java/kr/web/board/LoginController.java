//package kr.web.board;
//
//import org.apache.taglibs.standard.lang.jstl.Logger;
//import org.springframework.context.annotation.Role;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import kr.web.service.MemberService;
//import kr.web.vo.MemberVO;
//
//@Controller
//public class LoginController {
//
//	private final MemberService service;
//
//	private final BCryptPasswordEncoder bCryptPasswordEncoder;
//
//	public LoginController(MemberService service, BCryptPasswordEncoder bCryptPasswordEncoder) {
//		this.service = service;
//		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//	}
//
//	@PostMapping("/join")
//	public String join(MemberVO vo) {
//		String encodedPassword = bCryptPasswordEncoder.encode(vo.getPw());
//		//service.saveWriterWithSecurity(vo.getId(), encodedPassword, vo.getNick(), Role.User);
//
//		return "redirect:/login";
//	}
//
//}
