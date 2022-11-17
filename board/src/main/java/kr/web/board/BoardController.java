package kr.web.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.web.service.BoardService;
import kr.web.vo.BoardVO;
import kr.web.vo.Criteria;
import kr.web.vo.PageMaker;
import kr.web.vo.Paging;
import kr.web.vo.Search;

@Controller
public class BoardController {

	@Inject
	private BoardService service;

	// 전체 조회 get
	@RequestMapping("/boardlist")
	public void boardlist(@RequestParam(required = false, defaultValue = "1") int viewPage, 
			@RequestParam(required = false, defaultValue = "1")int range, 
			@RequestParam(required = false, defaultValue = "title") String searchType, 
			@RequestParam(required = false) String keyword,
			Model model) throws Exception {

		// 전체 게시글 개수
//		Paging pg = new Paging();
//		search.pageInfo(viewPage, range, total);
		
		//int totalPage = (int) Math.ceil((double) total / 10);
		//int startIndex = (pg.getViewPage() - 1) * 10 + 1;
		//int endIndex = startIndex + (10 - 1);
		//pg.setStartIndex(startIndex);
		//pg.setEndIndex(endIndex);

		// 전체개수 기준으로 1페이지에 마지막번호부터 -10
//		int page1 = total -0;
//		int page2 = total -10;
//		int page3 = total -20;
//		int page4 = total -40;
//
//		// 게시글 행번호 출력하기위해 전체 - 현재페이지시작번호
//		//int rowNo = total - (pg.getViewPage() - 1) * 10;
//		//model.addAttribute("rowNo", rowNo);
//
//		System.out.println("게시판 목록 보기");
//		model.addAttribute("list", service.paginList(search));
//		model.addAttribute("pg", search);
	}
	
	@RequestMapping("/listPage")
	public void listPage(Criteria cri, Model model) throws Exception {
		model.addAttribute("list", service.listCriteria(cri));
		model.addAttribute("pageMaker", new PageMaker(cri, service.boardTotal(cri)));
		
	}


	// 특정 게시글 조회 get
	@RequestMapping("/boardContent")
	public void boardContent(int idx, Model model, Criteria cri) throws Exception {
		System.out.println("게시글 보기, idx : " + idx);
		BoardVO vo = service.read(idx);
		service.updateCnt(idx);
		model.addAttribute("vo", vo);
		model.addAttribute("cri", cri);
		
	}

	// 뒤로가기 버튼클릭시 조회수 카운트
//	@RequestMapping("/updateCnt")
//	public String updateCnt(int idx) throws Exception {
//		service.updateCnt(idx);
//		return "boardlist";
//	}

	// 폼 페이지 이동
	@RequestMapping("/boardInsertForm")
	public void boardInsertForm() {
		System.out.println("작성 폼 페이지 이동");
	}

	// 게시글 등록 post
	@RequestMapping("/boardInsert")
	public String boardInsert(BoardVO vo, RedirectAttributes rttr) throws Exception {
		System.out.println("작성내용 : " + vo.toString());
		service.create(vo);
		rttr.addFlashAttribute("result", "enrol success");
		return "redirect:/listPage";
	}

	// 게시글 수정폼 이동- get 방식, idx 페이지정보 가져옴
	@RequestMapping("/boardUpdateForm")
	public void boardUpdateForm(int idx, Model model, Criteria cri) throws Exception {
		BoardVO vo = service.read(idx);
		System.out.println(vo.toString());
		model.addAttribute("vo", vo);
		model.addAttribute("cri", cri);

	}

	// 게시글 수정 post
	@RequestMapping("/boardUpdate")
	public String boardUpdate(BoardVO vo, RedirectAttributes rttr) throws Exception {
		System.out.println(vo.toString());
		service.update(vo);
		rttr.addFlashAttribute("result", "modify success");
		
		return "redirect:/listPage";
	}

	// 게시글 삭제 post
	@RequestMapping("/boardDelete")
	public String boardDelete(int idx, RedirectAttributes rttr) throws Exception {
		System.out.println("게시글삭제 실행, index : " + idx);
		service.delete(idx);
		rttr.addFlashAttribute("result", "delete success");
		//스트링 데이터를 "result" 속성 값에 저장하는 addFlashAttribute() 메소드를 호출
		return "redirect:/listPage";
	}

}
