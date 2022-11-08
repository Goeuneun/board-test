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
		System.out.println("게시판 목록 보기");
		List<BoardVO> list = mapper.boardlist();
		model.addAttribute("list", list);
	}
	
	@RequestMapping("boardContent")
	public void boardContent(int idx, Model model) {
		System.out.println("게시글 보기 실행, idx : " + idx);
		BoardVO vo = mapper.boardContent(idx);
		mapper.countUpdate(idx);
		model.addAttribute("vo", vo);
	}
	
	@RequestMapping("boardInsertForm")
	public void boardInsertForm() {
		System.out.println("작성 폼 페이지 이동");
	}
	
	@RequestMapping("/boardInsert")
	public String boardInsert(BoardVO vo) {
		System.out.println("작성내용 : " + vo.toString());
		mapper.boardInsert(vo);
		return "redirect:/boardlist";	
		//게시글 가지고 가도록 redirect
	}
	
	@RequestMapping("/boardUpdateForm")
	public void boardUpdateForm(int idx, Model model) {
		BoardVO vo =  mapper.boardContent(idx);
		System.out.println(vo.toString());
		model.addAttribute("vo", vo);
		
	}
	
	@RequestMapping("/boardUpdate")
	public String boardUpdate(BoardVO vo) {
		System.out.println("게시글수정내용 : " + vo.toString());
		mapper.boardUpdate(vo);
		return "redirect:/boardlist";	
	}
	
	@RequestMapping("/boardDelete")
	public String boardDelete(int idx) {
		System.out.println("게시글삭제 실행, index : " + idx);
		mapper.boardDelete(idx);
		return "redirect:/boardlist";	
	}
	
	

	
}
