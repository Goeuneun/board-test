package kr.web.board;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.web.service.MemberService;
import kr.web.vo.MemberVO;

@Controller
public class MemberController {
	
	@Inject
	private MemberService service;

	//�������̵�
	@RequestMapping("/login")
	public void login() {
		System.out.println("�α����Ʈ ����");
		
	}
	
	@RequestMapping("/join")
	public void join() {

	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes rttr) {
		session.removeAttribute("info");
		rttr.addFlashAttribute("result","logout succsess");
		return "redirect:/listPage";

	}
	
	@RequestMapping("/memUpdateForm")
	public void memUpdateForm() {

	}
	
	// ����
	@RequestMapping("/joinInsert")
	public String joinInsert(MemberVO vo, RedirectAttributes rttr) {
		System.out.println("ȸ�����Խ���"+vo.toString());
		service.register(vo);
		rttr.addFlashAttribute("result","join success");
		return "redirect:/login";
		
	}
	
	//�α��� 
	@RequestMapping("/loginSelect") 
	public String loginSelect(HttpSession session, MemberVO vo, RedirectAttributes rttr) {
		System.out.println("�α��α�ɽ���");
		MemberVO info =  service.login(vo);
		System.out.println(info);
		if(info!=null) {
			session.setAttribute("info", info);
			rttr.addFlashAttribute("result","login succsess");
		} else {
			rttr.addFlashAttribute("result","login fail");
		}
		
		return "redirect:/listPage";
	}
	
	
	//ȸ����������
	@RequestMapping("/updateInfo")
	public String updateInfo(HttpSession session, MemberVO vo, RedirectAttributes rttr) {
		System.out.println("ȸ��������������"+vo.toString());
		service.update(vo);
		session.setAttribute("info", vo);
		rttr.addFlashAttribute("result","update succsess");
		return "redirect:/listPage";
	}
	
	
	
	//idüũ
	@RequestMapping("/idCheck")
	public @ResponseBody MemberVO idCheck(String id) {
		System.out.println("���̵� �ߺ�üũ ���� : " + id);
		MemberVO vo = service.idCheck(id);
		System.out.println(vo);
		return vo;
	}
	
	
	// ��� ���
	@RequestMapping("/memberlist")
	public List<MemberVO> memberlist(Model model){
		List<MemberVO> vo = service.memberlistAll();
		model.addAttribute("mem_vo", vo);
		return vo;
	}
	
	
	
	
	
}
