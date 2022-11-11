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
	
	// 전체 조회 get
	@RequestMapping("/boardlist")
	public void boardlist(Model model) throws Exception {
		System.out.println("게시판 목록 보기");
		List<BoardVO> list = service.listAll();
		model.addAttribute("list", list);
	}
	
	// 특정 게시글 조회 get
	@RequestMapping("boardContent")
	public void boardContent(int idx, Model model) throws Exception{
		System.out.println("게시글 보기 실행, idx : " + idx);
		BoardVO vo = service.read(idx);
		service.updateCnt(idx);
		model.addAttribute("vo", vo);
	}
	
	//폼 페이지 이동
	@RequestMapping("boardInsertForm")
	public void boardInsertForm() {
		System.out.println("작성 폼 페이지 이동");
	}
	
	//게시글 등록 post
	@RequestMapping("/boardInsert")
	public String boardInsert(BoardVO vo) throws Exception{
		System.out.println("작성내용 : " + vo.toString());
		service.create(vo);
		return "redirect:/boardlist";	
		//게시글 가지고 가도록 redirect
	}
	
	//게시글 수정폼 이동 
	@RequestMapping("/boardUpdateForm")
	public void boardUpdateForm(int idx, Model model) throws Exception{
		BoardVO vo =  service.read(idx);
		System.out.println(vo.toString());
		model.addAttribute("vo", vo);
		
	}
	
	// 게시글 수정 post
	@RequestMapping("/boardUpdate")
	public String boardUpdate(BoardVO vo) throws Exception{
		System.out.println("게시글수정내용 : " + vo.toString());
		service.update(vo);
		return "redirect:/boardlist";	
	}
	
	//게시글 삭제 post
	@RequestMapping("/boardDelete")
	public String boardDelete(int idx) throws Exception{
		System.out.println("게시글삭제 실행, index : " + idx);
		service.delete(idx);
		return "redirect:/boardlist";	
	}
	

	
}
