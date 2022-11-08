package kr.web.board;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.web.mapper.MemberMapper;
import kr.web.vo.MemberVO;

@Controller
public class MemberController {
	
	@Inject
	private MemberMapper mapper;

	//�������̵�
	@RequestMapping("/login")
	public void login() {
		System.out.println("�α����Ʈ ����");
		
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
	
	// ����
	@RequestMapping("/joinInsert")
	public String joinInsert(MemberVO vo) {
		System.out.println("ȸ�����Խ���"+vo.toString());
		mapper.joinInsert(vo);
		return "redirect:/login";
		
	}
	
	//�α��� 
	@RequestMapping("/loginSelect") 
	public String loginSelect(HttpSession session, MemberVO vo) {
		System.out.println("�α��α�ɽ���");
		MemberVO info =  mapper.loginSelect(vo);
		System.out.println(info);
		if(info!=null) {
			session.setAttribute("info", info);
		}
		return "redirect:/boardlist";
	}
	
	
	//ȸ����������
	@RequestMapping("/updateInfo")
	public String updateInfo(HttpSession session, MemberVO vo) {
		System.out.println("ȸ��������������"+vo.toString());
		mapper.updateInfo(vo);
		session.setAttribute("info", vo);
		return "redirect:/boardlist";
	
	}
	
	// ��� ���
	@RequestMapping("/memberlist")
	public List<MemberVO> memberlist(Model model){
		List<MemberVO> vo = mapper.memberlist();
		model.addAttribute("mem_vo", vo);
		return vo;
	}
	
	
	
	
}
