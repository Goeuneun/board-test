package kr.web.board;

import java.lang.reflect.Member;
import java.util.List;

import javax.inject.Inject;
import javax.swing.plaf.metal.MetalMenuBarUI;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.web.mapper.BoardMapper;
import kr.web.mapper.MemberMapper;
import kr.web.vo.BoardVO;
import kr.web.vo.MemberVO;

@Controller
public class BoardController {
	
	@Inject
	private BoardMapper mapper;
	
	@RequestMapping("/boardlist")
	public void boardlist(Model model) {
		System.out.println("�Խ��� ��� ����");
		List<BoardVO> list = mapper.boardlist();
		model.addAttribute("list", list);
	}
	
	@RequestMapping("boardContent")
	public void boardContent(int idx, Model model) {
		System.out.println("�Խñ� ���� ����, idx : " + idx);
		BoardVO vo = mapper.boardContent(idx);
		mapper.countUpdate(idx);
		model.addAttribute("vo", vo);
	}
	
	@RequestMapping("boardInsertForm")
	public void boardInsertForm() {
		System.out.println("�ۼ� �� ������ �̵�");
	}
	
	@RequestMapping("/boardInsert")
	public String boardInsert(BoardVO vo) {
		System.out.println("�ۼ����� : " + vo.toString());
		mapper.boardInsert(vo);
		return "redirect:/boardlist";	
		//�Խñ� ������ ������ redirect
	}
	
	@RequestMapping("/boardUpdateForm")
	public void boardUpdateForm(int idx, Model model) {
		BoardVO vo =  mapper.boardContent(idx);
		System.out.println(vo.toString());
		model.addAttribute("vo", vo);
		
	}
	
	@RequestMapping("/boardUpdate")
	public String boardUpdate(BoardVO vo) {
		System.out.println("�Խñۼ������� : " + vo.toString());
		mapper.boardUpdate(vo);
		return "redirect:/boardlist";	
	}
	
	@RequestMapping("/boardDelete")
	public String boardDelete(int idx) {
		System.out.println("�Խñۻ��� ����, index : " + idx);
		mapper.boardDelete(idx);
		return "redirect:/boardlist";	
	}
	
	

	
}
