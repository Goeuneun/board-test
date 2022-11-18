package kr.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.web.vo.BoardVO;
import kr.web.vo.Criteria;
import kr.web.vo.Paging;
import kr.web.vo.Search;

@Mapper
public interface BoardMapper {

	public List<BoardVO> boardlist();
	// 전부 다 가져옴

	public BoardVO boardContent(int idx);
	// 특정글

	public void boardInsert(BoardVO vo);

	public void boardUpdate(BoardVO vo);

	public void boardDelete(int idx);

	public void countUpdate(int idx);
	
	public List<BoardVO> listpage(int page);

	public List<BoardVO> listCriteria(Criteria cri);	
	//페이지에맞는 리스트가져옴
	
	public int countPaging(Criteria cri) throws Exception;

	public int boardTotal(Criteria cri);
	// 전체 게시글 - 필터링된 글을위해 매개변수 추가

	public List<BoardVO> paginList(Search search);
	

}
