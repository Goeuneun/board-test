package kr.web.board;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.web.service.MemberService;
import kr.web.vo.MemberVO;

@Controller
public class MemberController {
	
	@Inject
	private MemberService service;

	//페이지이동
	@RequestMapping("/login")
	public void login() {
		System.out.println("로긴사이트 가기");
		
	}
	
	@RequestMapping("/join")
	public void join() {

	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("info");
		return "redirect:/boardlist";

	}
	
	@RequestMapping("/memUpdateForm")
	public void memUpdateForm() {

	}
	
	// 가입
	@RequestMapping("/joinInsert")
	public String joinInsert(MemberVO vo) {
		System.out.println("회원가입실행"+vo.toString());
		service.register(vo);
		return "redirect:/login";
		
	}
	
	//로그인 
	@RequestMapping("/loginSelect") 
	public String loginSelect(HttpSession session, MemberVO vo) {
		System.out.println("로그인기능실행");
		MemberVO info =  service.login(vo);
		System.out.println(info);
		if(info!=null) {
			session.setAttribute("info", info);
		}
		return "redirect:/boardlist";
	}
	
	
	//회원정보수정
	@RequestMapping("/updateInfo")
	public String updateInfo(HttpSession session, MemberVO vo) {
		System.out.println("회원정보수정실행"+vo.toString());
		service.update(vo);
		session.setAttribute("info", vo);
		return "redirect:/boardlist";
	
	}
	
	
	
	//id체크
	@RequestMapping("/idCheck")
	public @ResponseBody MemberVO idCheck(String id) {
		System.out.println("아이디 중복체크 실행 : " + id);
		MemberVO vo = service.idCheck(id);
		System.out.println(vo);
		return vo;
	}
	
	
	// 멤버 목록
	@RequestMapping("/memberlist")
	public List<MemberVO> memberlist(Model model){
		List<MemberVO> vo = service.memberlistAll();
		model.addAttribute("mem_vo", vo);
		return vo;
	}
	
	
	
	
	
}
