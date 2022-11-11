package kr.web.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.web.service.BoardService;
import kr.web.vo.BoardVO;

@Controller
public class BoardController {
	
	@Inject
	private BoardService service;
	
	// ��ü ��ȸ get
	@RequestMapping("/boardlist")
	public void boardlist(Model model) throws Exception {
		System.out.println("�Խ��� ��� ����");
		List<BoardVO> list = service.listAll();
		model.addAttribute("list", list);
	}
	
	// Ư�� �Խñ� ��ȸ get
	@RequestMapping("boardContent")
	public void boardContent(int idx, Model model) throws Exception{
		System.out.println("�Խñ� ���� ����, idx : " + idx);
		BoardVO vo = service.read(idx);
		service.updateCnt(idx);
		model.addAttribute("vo", vo);
	}
	
	//�� ������ �̵�
	@RequestMapping("boardInsertForm")
	public void boardInsertForm() {
		System.out.println("�ۼ� �� ������ �̵�");
	}
	
	//�Խñ� ��� post
	@RequestMapping("/boardInsert")
	public String boardInsert(BoardVO vo) throws Exception{
		System.out.println("�ۼ����� : " + vo.toString());
		service.create(vo);
		return "redirect:/boardlist";	
		//�Խñ� ������ ������ redirect
	}
	
	//�Խñ� ������ �̵� 
	@RequestMapping("/boardUpdateForm")
	public void boardUpdateForm(int idx, Model model) throws Exception{
		BoardVO vo =  service.read(idx);
		System.out.println(vo.toString());
		model.addAttribute("vo", vo);
		
	}
	
	// �Խñ� ���� post
	@RequestMapping("/boardUpdate")
	public String boardUpdate(BoardVO vo) throws Exception{
		System.out.println("�Խñۼ������� : " + vo.toString());
		service.update(vo);
		return "redirect:/boardlist";	
	}
	
	//�Խñ� ���� post
	@RequestMapping("/boardDelete")
	public String boardDelete(int idx) throws Exception{
		System.out.println("�Խñۻ��� ����, index : " + idx);
		service.delete(idx);
		return "redirect:/boardlist";	
	}
	

	
}
