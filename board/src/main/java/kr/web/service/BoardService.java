package kr.web.service;

import java.util.List;

import kr.web.vo.BoardVO;
import kr.web.vo.Criteria;
import kr.web.vo.Paging;
import kr.web.vo.Search;

public interface BoardService {

	public void create(BoardVO vo) throws Exception;

	public BoardVO read(int idx) throws Exception;

	public void update(BoardVO vo) throws Exception;

	public void updateCnt(int idx) throws Exception;

	public void delete(int idx) throws Exception;

	public List<BoardVO> listAll() throws Exception;
	
	public List<BoardVO> listpage(int page) throws Exception;
	
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;

	public List<BoardVO> paginList(Search search) throws Exception;
	
	public int countPaging(Criteria cri) throws Exception;

	public int boardTotal() throws Exception;
}
