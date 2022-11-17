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

	// ��ü ��ȸ get
	@RequestMapping("/boardlist")
	public void boardlist(@RequestParam(required = false, defaultValue = "1") int viewPage, 
			@RequestParam(required = false, defaultValue = "1")int range, 
			@RequestParam(required = false, defaultValue = "title") String searchType, 
			@RequestParam(required = false) String keyword,
			Model model) throws Exception {

		// ��ü �Խñ� ����
//		Paging pg = new Paging();
//		search.pageInfo(viewPage, range, total);
		
		//int totalPage = (int) Math.ceil((double) total / 10);
		//int startIndex = (pg.getViewPage() - 1) * 10 + 1;
		//int endIndex = startIndex + (10 - 1);
		//pg.setStartIndex(startIndex);
		//pg.setEndIndex(endIndex);

		// ��ü���� �������� 1�������� ��������ȣ���� -10
//		int page1 = total -0;
//		int page2 = total -10;
//		int page3 = total -20;
//		int page4 = total -40;
//
//		// �Խñ� ���ȣ ����ϱ����� ��ü - �������������۹�ȣ
//		//int rowNo = total - (pg.getViewPage() - 1) * 10;
//		//model.addAttribute("rowNo", rowNo);
//
//		System.out.println("�Խ��� ��� ����");
//		model.addAttribute("list", service.paginList(search));
//		model.addAttribute("pg", search);
	}
	
	@RequestMapping("/listPage")
	public void listPage(Criteria cri, Model model) throws Exception {
		model.addAttribute("list", service.listCriteria(cri));
		model.addAttribute("pageMaker", new PageMaker(cri, service.boardTotal(cri)));
		
	}


	// Ư�� �Խñ� ��ȸ get
	@RequestMapping("/boardContent")
	public void boardContent(int idx, Model model, Criteria cri) throws Exception {
		System.out.println("�Խñ� ����, idx : " + idx);
		BoardVO vo = service.read(idx);
		service.updateCnt(idx);
		model.addAttribute("vo", vo);
		model.addAttribute("cri", cri);
		
	}

	// �ڷΰ��� ��ưŬ���� ��ȸ�� ī��Ʈ
//	@RequestMapping("/updateCnt")
//	public String updateCnt(int idx) throws Exception {
//		service.updateCnt(idx);
//		return "boardlist";
//	}

	// �� ������ �̵�
	@RequestMapping("/boardInsertForm")
	public void boardInsertForm() {
		System.out.println("�ۼ� �� ������ �̵�");
	}

	// �Խñ� ��� post
	@RequestMapping("/boardInsert")
	public String boardInsert(BoardVO vo, RedirectAttributes rttr) throws Exception {
		System.out.println("�ۼ����� : " + vo.toString());
		service.create(vo);
		rttr.addFlashAttribute("result", "enrol success");
		return "redirect:/listPage";
	}

	// �Խñ� ������ �̵�- get ���, idx ���������� ������
	@RequestMapping("/boardUpdateForm")
	public void boardUpdateForm(int idx, Model model, Criteria cri) throws Exception {
		BoardVO vo = service.read(idx);
		System.out.println(vo.toString());
		model.addAttribute("vo", vo);
		model.addAttribute("cri", cri);

	}

	// �Խñ� ���� post
	@RequestMapping("/boardUpdate")
	public String boardUpdate(BoardVO vo, RedirectAttributes rttr) throws Exception {
		System.out.println(vo.toString());
		service.update(vo);
		rttr.addFlashAttribute("result", "modify success");
		
		return "redirect:/listPage";
	}

	// �Խñ� ���� post
	@RequestMapping("/boardDelete")
	public String boardDelete(int idx, RedirectAttributes rttr) throws Exception {
		System.out.println("�Խñۻ��� ����, index : " + idx);
		service.delete(idx);
		rttr.addFlashAttribute("result", "delete success");
		//��Ʈ�� �����͸� "result" �Ӽ� ���� �����ϴ� addFlashAttribute() �޼ҵ带 ȣ��
		return "redirect:/listPage";
	}

}
